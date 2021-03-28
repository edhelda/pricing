package ru.tender.pricing.util.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.tender.pricing.service.dto.Filter;

import java.util.List;

public interface SpecificationBuilder<T> {

    /**
     * Построение спецификации.
     *
     * @param filters фильтры, содержащие условия для запроса данных.
     * @return спецификацию.
     */
    Specification<T> build(List<Filter> filters);
}
