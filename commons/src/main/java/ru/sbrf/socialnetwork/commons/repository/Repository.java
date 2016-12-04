package ru.sbrf.socialnetwork.commons.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by Ivan on 27/11/2016.
 */
public interface Repository<T> {
    /**
     * add value to repository
     *
     * @param value to add
     * @return inserted value
     */
    T add(T value);

    /**
     * update specified value in repository
     *
     * @param value to update
     * @return updated value
     */
    boolean update(T value);

    void remove(T value);

    List<T> select(Criteria<T> criteria);


    /**
     * get first value from selection
     */
    default Optional<T> selectFirst(Criteria<T> criteria) {
        List<T> values = select(criteria);
        return values.isEmpty() ? Optional.empty() : Optional.of(values.get(0));
    }

    /**
     * select first value check it with predicate and remove this value if it's not matching it
     *
     * @return if value passed test and it exist then optional of found value,
     * {@code Optional.empty()} otherwise
     */
    default Optional<T> selectFirstRemoveIfInvalid(Criteria<T> criteria, Predicate<T> predicate) {
        Optional<T> first = selectFirst(criteria);

        if (first.isPresent()) {
            if (!predicate.test(first.get())) {
                remove(first.get());
                first = Optional.empty();
            }
        }

        return first;
    }

    /**
     * remove multiple specified values
     */
    default void removeAll(List<T> values) {
        values.forEach(this::remove);
    }

    default T computeIfAbsent(Criteria<T> criteria, Supplier<T> supplier) {
        Optional<T> value = selectFirst(criteria);
        return value.isPresent() ? value.get() : add(supplier.get());
    }
}
