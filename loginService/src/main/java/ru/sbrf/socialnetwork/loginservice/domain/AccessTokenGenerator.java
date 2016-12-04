package ru.sbrf.socialnetwork.loginservice.domain;

import ru.sbrf.socialnetwork.commons.model.account.AccessToken;
import ru.sbrf.socialnetwork.commons.model.account.Account;

/**
 * utility used only for token generation
 */
public interface AccessTokenGenerator {
    AccessToken generate(Account account);
}
