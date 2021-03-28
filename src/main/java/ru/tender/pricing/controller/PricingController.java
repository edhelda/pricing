package ru.tender.pricing.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tender.pricing.service.PricingService;
import ru.tender.pricing.service.dto.PricingDTO;

@RestController
@RequestMapping("/api/pricing")
@RequiredArgsConstructor
public class PricingController {

    private final PricingService pricingService;

    @PostMapping("/find-all")
    public ResponseEntity<Page<PricingDTO>> findAll(Pageable pageable) {
        Page<PricingDTO> resultPage = pricingService.findAll(pageable);
        return ResponseEntity.ok(resultPage);
    }
}
