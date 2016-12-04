package ru.sbrf.socialnetwork.loginservice.repository.impl.h2db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.sbrf.socialnetwork.commons.model.account.AccessToken;
import ru.sbrf.socialnetwork.commons.repository.Criteria;
import ru.sbrf.socialnetwork.loginservice.repository.AccessTokenRepository;
import ru.sbrf.socialnetwork.loginservice.repository.impl.h2db.criteria.H2DbCriteria;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Ivan on 04/12/2016.
 */
public class H2DbAccessTokenRepository implements AccessTokenRepository {
    private final JdbcTemplate jdbcTemplate;
    private final AccessTokenRowMapper rowMapper = new AccessTokenRowMapper();

    @Autowired
    public H2DbAccessTokenRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public AccessToken add(AccessToken value) {
        final String sql = "INSERT INTO ACCESS_TOKENS " +
                "(account_id, access_token, expiration_date) VALUES (?, ?, ?)";

        int result = jdbcTemplate.update(sql,
                value.getAccountId(),
                value.getAccessToken(),
                Timestamp.valueOf(value.getExpirationDate()));

        assert result == 1;

        return value;
    }

    @Override
    public boolean update(AccessToken value) {
        final String sql = "UPDATE ACCESS_TOKENS set account_id = ?, expiration_date = ?) " +
                "WHERE access_token = ?";

        int result = jdbcTemplate.update(sql,
                value.getAccountId(),
                value.getExpirationDate(),
                Timestamp.valueOf(value.getAccessToken())
        );

        return result == 1;
    }

    @Override
    public void remove(AccessToken value) {
        final String sql = "DELETE FROM ACCESS_TOKENS WHERE access_token = ?";

        assert value.getAccessToken() != null;

        jdbcTemplate.update(sql, value.getAccessToken());
    }

    @Override
    public List<AccessToken> select(Criteria<AccessToken> criteria) {
        if (!(criteria instanceof H2DbCriteria))
            throw new IllegalArgumentException("criteria must implement H2DbCriteria");

        H2DbCriteria c = (H2DbCriteria) criteria;

        String sql = "SELECT account_id, access_token, expiration_date FROM ACCESS_TOKENS " +
                "WHERE " + c.getClausePart();
        Object[] args = c.getArguments();

        return jdbcTemplate.query(sql, rowMapper, args);
    }


    private static class AccessTokenRowMapper implements RowMapper<AccessToken> {
        @Override
        public AccessToken mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new AccessToken(
                    rs.getLong("account_id"),
                    rs.getString("access_token"),
                    rs.getTimestamp("expiration_date").toLocalDateTime()
            );
        }
    }
}
