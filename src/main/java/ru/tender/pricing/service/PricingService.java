package ru.tender.pricing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tender.pricing.PricingRepository;
import ru.tender.pricing.service.dto.PricingDTO;
import ru.tender.pricing.service.mapper.PricingMapper;

@Service
@Transactional
@RequiredArgsConstructor
public class PricingService {

    private final PricingRepository pricingRepository;
    private final PricingMapper pricingMapper;

    public Page<PricingDTO> findAll(Pageable pageable) {
        return pricingRepository.findAll(pageable)
                .map(pricingMapper::toPricingDTO);
    }
}
