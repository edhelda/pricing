package ru.tender.pricing.util.specification.impl;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.tender.pricing.service.dto.Filter;
import ru.tender.pricing.service.dto.SearchCondition;
import ru.tender.pricing.util.specification.PredicateBuilder;
import ru.tender.pricing.util.specification.SpecificationBuilder;
import ru.tender.pricing.util.specification.predicates.EqPredicateBuilder;
import ru.tender.pricing.util.specification.predicates.LikePredicateBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ru.tender.pricing.util.ProblemSupplier.badRequest;

@Component
public class SpecificationBuilderImpl<T> implements SpecificationBuilder<T> {

    private final Map<SearchCondition, PredicateBuilder> predicatesBuilderMap;

    public SpecificationBuilderImpl() {
        this.predicatesBuilderMap = initPredicatesBuilderMap();
    }

    public Specification<T> build(List<Filter> filters) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = getPredicates(filters, root, criteriaBuilder);

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    private List<Predicate> getPredicates(List<Filter> filters, Root<T> root, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>(filters.size());

        for (Filter filter : filters) {
            var path = root.get(filter.getKey());
            predicates.add(buildPredicate(path, criteriaBuilder, filter));
        }

        return predicates;
    }

    private Predicate buildPredicate(Path<?> path, CriteriaBuilder criteriaBuilder, Filter filter) {
        var predicateBuilder = predicatesBuilderMap.get(filter.getSearchCondition());

        try {
            return predicateBuilder.build(criteriaBuilder, path, filter);
        } catch (Exception ex) {
            throw badRequest("Ошибка построения фильтра: {0}. С сообщением об ошибке: {1}", filter, ex.getMessage());
        }
    }

    private Map<SearchCondition, PredicateBuilder> initPredicatesBuilderMap() {
        return Map.ofEntries(
                Map.entry(SearchCondition.EQUALS, new EqPredicateBuilder()),
                Map.entry(SearchCondition.LIKE, new LikePredicateBuilder())
        );
    }
}
