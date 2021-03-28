package ru.tender.pricing.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tender.pricing.service.PricingService;
import ru.tender.pricing.service.dto.Filter;
import ru.tender.pricing.service.dto.PricingDTO;

import java.util.List;

@RestController
@RequestMapping("/api/pricing")
@RequiredArgsConstructor
public class PricingController {

    private final PricingService pricingService;

    @PostMapping("/find-all")
    public ResponseEntity<Page<PricingDTO>> findAll(@RequestBody List<Filter> filters, Pageable pageable) {
        Page<PricingDTO> resultPage = pricingService.findAll(filters, pageable);
        return ResponseEntity.ok(resultPage);
    }
}
