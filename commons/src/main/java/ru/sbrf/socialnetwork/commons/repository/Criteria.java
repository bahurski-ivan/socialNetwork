package ru.sbrf.socialnetwork.commons.repository;

/**
 * Created by Ivan on 27/11/2016.
 */
public interface Criteria<T> {
    boolean isValueMatches(T value);
}
