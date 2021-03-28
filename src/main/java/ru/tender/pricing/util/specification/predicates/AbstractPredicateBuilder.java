package ru.tender.pricing.util.specification.predicates;

import ru.tender.pricing.util.specification.PredicateBuilder;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;

import static org.springframework.util.ObjectUtils.isEmpty;

public abstract class AbstractPredicateBuilder implements PredicateBuilder {

    @SuppressWarnings("unchecked")
    protected <T> Expression<T> buildExpression(Path<?> path) {
        Class<?> entityType = path.getJavaType();
        return (Expression<T>) path.as(entityType);
    }

    @SuppressWarnings("unchecked")
    protected <T extends Comparable<T>> T castValueToClass(Class<? extends T> clazz, Object value) {
        if (isEmpty(value)) return null;
        return clazz.cast(value);
    }
}
