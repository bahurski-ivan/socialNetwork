package ru.sbrf.socialnetwork.loginservice.repository.impl.h2db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.sbrf.socialnetwork.commons.model.account.Account;
import ru.sbrf.socialnetwork.commons.repository.Criteria;
import ru.sbrf.socialnetwork.loginservice.repository.AccountRepository;
import ru.sbrf.socialnetwork.loginservice.repository.impl.h2db.criteria.H2DbCriteria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Ivan on 04/12/2016.
 */
@Component
public class H2DbAccountRepository implements AccountRepository {
    private final JdbcTemplate jdbcTemplate;
    private final AccountRowMapper rowMapper = new AccountRowMapper();

    @Autowired
    public H2DbAccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Account add(Account value) {
        final String sql = "INSERT INTO ACCOUNTS (user_name, password_md5, creation_date) VALUES (?,?,?)";
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        final LocalDateTime creationDate = LocalDateTime.now();

        int result = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, value.getUserName());
            ps.setString(2, value.getPasswordMd5());
            ps.setTimestamp(3, Timestamp.valueOf(creationDate));
            return ps;
        }, keyHolder);

        assert result == 1;

        return new Account(
                keyHolder.getKey().longValue(),
                value.getUserName(),
                value.getPasswordMd5(),
                creationDate
        );
    }

    @Override
    public boolean update(Account value) {
        final String sql = "UPDATE ACCOUNTS set " +
                "user_name = ?, " +
                "password_md5 = ?, " +
                "creation_date = ?) " +
                "WHERE id = ?";

        assert value.getId() != null;

        int result = jdbcTemplate.update(sql,
                value.getUserName(),
                value.getPasswordMd5(),
                Timestamp.valueOf(value.getCreationDate()),
                value.getId());

        return result == 1;
    }

    @Override
    public void remove(Account value) {
        final String sql = "DELETE FROM ACCOUNTS WHERE id = ?";

        assert value.getId() != null;

        jdbcTemplate.update(sql, value.getId());
    }

    @Override
    public List<Account> select(Criteria<Account> criteria) throws IllegalArgumentException {
        if (!(criteria instanceof H2DbCriteria))
            throw new IllegalArgumentException("criteria must implement H2DbCriteria");

        H2DbCriteria c = (H2DbCriteria) criteria;

        String sql = "SELECT id, user_name, password_md5, creation_date FROM ACCOUNTS " +
                "WHERE " + c.getClausePart();
        Object[] args = c.getArguments();

        return jdbcTemplate.query(sql, rowMapper, args);
    }


    private static class AccountRowMapper implements RowMapper<Account> {
        @Override
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Account(
                    rs.getInt("id"),
                    rs.getString("user_name"),
                    rs.getString("password_md5"),
                    rs.getTimestamp("creation_date").toLocalDateTime()
            );
        }
    }
}
