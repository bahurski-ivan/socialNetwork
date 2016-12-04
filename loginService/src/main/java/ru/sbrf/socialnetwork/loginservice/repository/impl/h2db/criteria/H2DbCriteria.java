package ru.sbrf.socialnetwork.loginservice.repository.impl.h2db.criteria;

import ru.sbrf.socialnetwork.commons.repository.Criteria;

/**
 * Created by Ivan on 04/12/2016.
 */
public interface H2DbCriteria<T> extends Criteria<T> {
    String getClausePart();

    Object[] getArguments();
}
