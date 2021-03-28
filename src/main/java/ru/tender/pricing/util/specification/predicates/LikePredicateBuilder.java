package ru.tender.pricing.util.specification.predicates;


import ru.tender.pricing.service.dto.Filter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import static java.text.MessageFormat.format;
import static java.util.Objects.requireNonNull;

public class LikePredicateBuilder extends AbstractPredicateBuilder {

    @Override
    public Predicate build(CriteriaBuilder criteriaBuilder, Path<?> path, Filter filter) {
        requireNonNull(filter.getValue(), format("Не задан фильтр для поля {0}", filter.getKey()));

        Expression<String> expression = path.as(String.class);
        String valueFilter = filter.getValue();

        return criteriaBuilder.like(criteriaBuilder.lower(expression), wrapLikeFilter(valueFilter));
    }

    private String wrapLikeFilter(String filter) {
        return "%" + filter.toLowerCase() + "%";
    }
}
