package ru.sbrf.socialnetwork.loginservice.repository.criteria;

import ru.sbrf.socialnetwork.commons.model.account.Account;
import ru.sbrf.socialnetwork.commons.repository.Criteria;

/**
 * Created by Ivan on 01/12/2016.
 */
public interface AccountCriteriaFactory {
    Criteria<Account> accountByUserName(String userName);
}
