package ru.sbrf.socialnetwork.loginservice.repository.impl.h2db.criteria.accesstoken;

import ru.sbrf.socialnetwork.commons.model.account.AccessToken;
import ru.sbrf.socialnetwork.commons.repository.Criteria;
import ru.sbrf.socialnetwork.loginservice.repository.criteria.AccessTokenCriteriaFactory;
import ru.sbrf.socialnetwork.loginservice.repository.impl.h2db.criteria.H2DbCriteria;

/**
 * Created by Ivan on 04/12/2016.
 */
public class H2DbAccessTokenCriteriaFactory implements AccessTokenCriteriaFactory {
    @Override
    public H2DbCriteria<AccessToken> accessTokenByItsValue(String accessTokenValue) {
        return new H2DbCriteria<AccessToken>() {
            @Override
            public String getClausePart() {
                return "access_token = ?";
            }

            @Override
            public Object[] getArguments() {
                return new Object[]{accessTokenValue};
            }

            @Override
            public boolean isValueMatches(AccessToken value) {
                return value.getAccessToken().equals(accessTokenValue);
            }
        };
    }

    @Override
    public Criteria<AccessToken> accessTokenByAccountId(long accountId) {
        return new H2DbCriteria<AccessToken>() {
            @Override
            public String getClausePart() {
                return "account_id = ?";
            }

            @Override
            public Object[] getArguments() {
                return new Object[]{accountId};
            }

            @Override
            public boolean isValueMatches(AccessToken value) {
                return value.getAccountId() == accountId;
            }
        };
    }
}
