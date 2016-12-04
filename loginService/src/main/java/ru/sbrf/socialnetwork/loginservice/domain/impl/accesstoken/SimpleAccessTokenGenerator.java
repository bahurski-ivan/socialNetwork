package ru.sbrf.socialnetwork.loginservice.domain.impl.accesstoken;

import ru.sbrf.socialnetwork.commons.model.account.AccessToken;
import ru.sbrf.socialnetwork.commons.model.account.Account;
import ru.sbrf.socialnetwork.loginservice.domain.AccessTokenGenerator;
import ru.sbrf.socialnetwork.loginservice.domain.Md5Generator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

/**
 * Created by Ivan on 04/12/2016.
 */
public class SimpleAccessTokenGenerator implements AccessTokenGenerator {
    private final Md5Generator md5Generator;
    private final Random random = new Random();

    public SimpleAccessTokenGenerator(Md5Generator md5Generator) {
        this.md5Generator = md5Generator;
    }

    @Override
    public AccessToken generate(Account account) {
        String tokenValue = Long.toString(Math.abs(random.nextInt())) +
                md5Generator.generate(account.getUserName()) +
                md5Generator.generate(Long.toString(LocalDate.now().toEpochDay() + account.getId()));

        return new AccessToken(
                account.getId(),
                tokenValue,
                LocalDateTime.now().plus(2, ChronoUnit.MINUTES)
        );
    }
}
