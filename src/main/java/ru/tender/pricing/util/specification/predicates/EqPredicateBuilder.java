package ru.tender.pricing.util.specification.predicates;



import ru.tender.pricing.service.dto.Filter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import static java.util.Objects.isNull;

public class EqPredicateBuilder extends AbstractPredicateBuilder {

    @Override
    public Predicate build(CriteriaBuilder criteriaBuilder, Path<?> path, Filter filter) {
        if (isNull(filter.getValue())) {
            return criteriaBuilder.isNull(path);
        }

        return buildPredicate(criteriaBuilder, path, filter);
    }

    @SuppressWarnings("unchecked")
    private <T extends Comparable<T>> Predicate buildPredicate(CriteriaBuilder criteriaBuilder,
                                                               Path<?> path,
                                                               Filter filter) {
        Expression<? extends T> expression = buildExpression(path);
        Class<T> clazz = (Class<T>) path.getJavaType();
        T value = castValueToClass(clazz, filter.getValue());
        return isNull(expression) || isNull(value) ? null : criteriaBuilder.equal(expression, value);
    }
}
