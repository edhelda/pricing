package ru.tender.pricing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tender.pricing.PricingRepository;
import ru.tender.pricing.domain.Pricing;
import ru.tender.pricing.service.dto.Filter;
import ru.tender.pricing.service.dto.PricingDTO;
import ru.tender.pricing.service.mapper.PricingMapper;
import ru.tender.pricing.util.specification.SpecificationBuilder;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PricingService {

    private final PricingRepository pricingRepository;
    private final PricingMapper pricingMapper;
    private final SpecificationBuilder<Pricing> specificationBuilder;

    public Page<PricingDTO> findAll(List<Filter> filters, Pageable pageable) {
        Specification<Pricing> specification = specificationBuilder.build(filters);

        return pricingRepository.findAll(specification, pageable)
                .map(pricingMapper::toPricingDTO);
    }
}
