package ru.tender.pricing.service.mapper;

import org.mapstruct.Mapper;
import ru.tender.pricing.domain.Pricing;
import ru.tender.pricing.service.dto.PricingDTO;

@Mapper(componentModel = "spring")
public interface PricingMapper {

    PricingDTO toPricingDTO(Pricing entity);
}
