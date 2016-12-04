package ru.sbrf.socialnetwork.loginservice.repository.impl.h2db.criteria.account;

import ru.sbrf.socialnetwork.commons.model.account.Account;
import ru.sbrf.socialnetwork.commons.repository.Criteria;
import ru.sbrf.socialnetwork.loginservice.repository.criteria.AccountCriteriaFactory;

/**
 * Created by Ivan on 04/12/2016.
 */
public class H2DbAccountCriteriaFactory implements AccountCriteriaFactory {
    @Override
    public Criteria<Account> accountByUserName(String userName) {
        return new H2DbAccountByUserNameCriteria(userName);
    }
}
