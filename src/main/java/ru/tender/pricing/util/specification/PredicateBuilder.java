package ru.tender.pricing.util.specification;


import ru.tender.pricing.service.dto.Filter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

public interface PredicateBuilder {

    Predicate build(CriteriaBuilder criteriaBuilder, Path<?> path, Filter filter);
}
