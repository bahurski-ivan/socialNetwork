package ru.sbrf.socialnetwork.repositories;

import java.util.List;

/**
 * Created by Ivan on 27/11/2016.
 */
public interface Repository<T> {
    void add(T value);

    void update(T value);

    void remove(T value);


    List<T> select(Criteria<T> criteria);
}
