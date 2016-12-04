package ru.sbrf.socialnetwork.loginservice.repository.impl.h2db.criteria.account;

import ru.sbrf.socialnetwork.commons.model.account.Account;
import ru.sbrf.socialnetwork.loginservice.repository.impl.h2db.criteria.H2DbCriteria;

/**
 * Created by Ivan on 04/12/2016.
 */
class H2DbAccountByUserNameCriteria implements H2DbCriteria<Account> {
    private final String userName;

    H2DbAccountByUserNameCriteria(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean isValueMatches(Account value) {
        return value.getUserName().equals(userName);
    }

    @Override
    public String getClausePart() {
        return "user_name = ?";
    }

    @Override
    public Object[] getArguments() {
        return new Object[]{userName};
    }
}
