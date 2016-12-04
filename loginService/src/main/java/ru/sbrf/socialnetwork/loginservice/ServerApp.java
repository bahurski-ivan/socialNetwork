package ru.sbrf.socialnetwork.loginservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import ru.sbrf.socialnetwork.loginservice.domain.AccessTokenGenerator;
import ru.sbrf.socialnetwork.loginservice.domain.DateTimeToStringConverter;
import ru.sbrf.socialnetwork.loginservice.domain.Md5Generator;
import ru.sbrf.socialnetwork.loginservice.domain.impl.accesstoken.SimpleAccessTokenGenerator;
import ru.sbrf.socialnetwork.loginservice.domain.impl.dtconv.Iso8601DateTimeConverter;
import ru.sbrf.socialnetwork.loginservice.domain.impl.md5.SimpleSaltMd5Generator;
import ru.sbrf.socialnetwork.loginservice.repository.AccessTokenRepository;
import ru.sbrf.socialnetwork.loginservice.repository.AccountRepository;
import ru.sbrf.socialnetwork.loginservice.repository.criteria.AccessTokenCriteriaFactory;
import ru.sbrf.socialnetwork.loginservice.repository.criteria.AccountCriteriaFactory;
import ru.sbrf.socialnetwork.loginservice.repository.impl.h2db.H2DbAccessTokenRepository;
import ru.sbrf.socialnetwork.loginservice.repository.impl.h2db.H2DbAccountRepository;
import ru.sbrf.socialnetwork.loginservice.repository.impl.h2db.criteria.accesstoken.H2DbAccessTokenCriteriaFactory;
import ru.sbrf.socialnetwork.loginservice.repository.impl.h2db.criteria.account.H2DbAccountCriteriaFactory;

/**
 * Created by Ivan on 01/12/2016.
 */
@Configuration
@SpringBootApplication
public class ServerApp {
    public static void main(String[] args) {
        SpringApplication.run(ServerApp.class, args);
    }

    @Bean
    public Md5Generator md5Generator() {
        return new SimpleSaltMd5Generator();
    }

    @Bean
    public AccountCriteriaFactory accountCriteriaFactory() {
        return new H2DbAccountCriteriaFactory();
    }

    @Bean
    public AccessTokenCriteriaFactory accessTokenCriteriaFactory() {
        return new H2DbAccessTokenCriteriaFactory();
    }

    @Bean
    public AccessTokenRepository accessTokenRepository() {
        return new H2DbAccessTokenRepository(jdbcTemplate());
    }

    @Bean
    public AccountRepository accountRepository() {
        return new H2DbAccountRepository(jdbcTemplate());
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(
                "jdbc:h2:tcp://localhost/~/authdb",
                "sa", "");

        Resource resource = new ClassPathResource("schema.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);

//        try {
//            dataSource.getConnection().commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        databasePopulator.execute(dataSource);

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public AccessTokenGenerator accessTokenGenerator() {
        return new SimpleAccessTokenGenerator(md5Generator());
    }

    @Bean
    public DateTimeToStringConverter dateTimeToStringConverter() {
        return new Iso8601DateTimeConverter();
    }
}
