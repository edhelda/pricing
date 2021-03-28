package ru.tender.pricing.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tender.pricing.service.PricingService;
import ru.tender.pricing.service.dto.Filter;
import ru.tender.pricing.service.dto.PricingDTO;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@Api(tags = "Продукты")
@RequestMapping("/api/pricing")
@RequiredArgsConstructor
public class PricingController {

    private final PricingService pricingService;

    @PostMapping("/find-all")
    @ApiOperation("Поиск продуктов")
    public ResponseEntity<Page<PricingDTO>> findAll(@RequestBody @Valid List<Filter> filters, Pageable pageable) {
        Page<PricingDTO> resultPage = pricingService.findAll(filters, pageable);
        return ResponseEntity.ok(resultPage);
    }
}
