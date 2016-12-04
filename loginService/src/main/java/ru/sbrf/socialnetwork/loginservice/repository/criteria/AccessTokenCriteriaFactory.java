package ru.sbrf.socialnetwork.loginservice.repository.criteria;

import ru.sbrf.socialnetwork.commons.model.account.AccessToken;
import ru.sbrf.socialnetwork.commons.repository.Criteria;

/**
 * Created by Ivan on 04/12/2016.
 */
public interface AccessTokenCriteriaFactory {
    Criteria<AccessToken> accessTokenByItsValue(String accessTokenValue);

    Criteria<AccessToken> accessTokenByAccountId(long accountId);
}
