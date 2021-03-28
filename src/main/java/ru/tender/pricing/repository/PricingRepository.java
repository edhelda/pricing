package ru.tender.pricing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.tender.pricing.domain.Pricing;

public interface PricingRepository extends JpaRepository<Pricing, Integer>, JpaSpecificationExecutor<Pricing> {
}
