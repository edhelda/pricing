package ru.tender.pricing.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import ru.tender.pricing.AbstractIntegrationTest;
import ru.tender.pricing.domain.Pricing;
import ru.tender.pricing.service.dto.Filter;
import ru.tender.pricing.service.dto.SearchCondition;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PricingControllerTest extends AbstractIntegrationTest {

    /**
     * Сбрасываем репозиторий перед выполнение каждого теста
     */
    @BeforeEach
    void resetRepository() {
        pricingRepository.deleteAllInBatch();
    }

    /**
     * Добавляем в репозиторий один товар и ожидаем получение этого товара при запросе без фильтров.
     */
    @Test
    @DisplayName("Поиск без учета фильтров")
    void findAllWithoutFilters() throws Exception {
        Pricing pricing = Pricing.builder().id(1).productName("Молоко").build();

        pricingRepository.save(pricing);

        mockMvc.perform(post("/api/pricing/find-all")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Collections.emptyList())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements").value(pricingRepository.count()))
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content").isNotEmpty())
                .andExpect(jsonPath("$.content.[0].productName").value(pricing.getProductName()));
    }

    /**
     * Добавляем в репозиторий 2 товара и производим поиск одного товара по полному соответствию одного из атрибутов.
     */
    @Test
    @DisplayName("Поиск с фильтром по полному соответствию атрибута")
    void findSpecificProductByEqualsFilter() throws Exception {
        Pricing milk = Pricing.builder().id(1).productName("Молоко").fifthAttributeId(1).firstAttributeName("Пакет")
                .build();
        Pricing butter = Pricing.builder().id(2).productName("Масло").fifthAttributeId(2).firstAttributeName("Бумага")
                .build();
        List<Pricing> pricingList = List.of(milk, butter);

        pricingRepository.saveAll(pricingList);
        assertEquals(pricingList.size(), pricingRepository.count());

        Filter filter = Filter.of("firstAttributeName", SearchCondition.EQUALS, "Бумага");

        mockMvc.perform(post("/api/pricing/find-all")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Collections.singletonList(filter))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements").value(1))
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content").isNotEmpty())
                .andExpect(jsonPath("$.content.[0].productName").value(butter.getProductName()));
    }

    /**
     * Добавляем в репозиторий 2 товара и производим поиск одного товара по частичному соответствию одного из атрибутов.
     */
    @Test
    @DisplayName("Поиск с фильтром по частичному соответствию атрибута")
    void findSpecificProductByLikeFilter() throws Exception {
        Pricing milk = Pricing.builder().id(1).productName("Молоко").fifthAttributeId(1).firstAttributeName("Пакет")
                .build();
        Pricing butter = Pricing.builder().id(2).productName("Масло").fifthAttributeId(2).firstAttributeName("Бумага")
                .build();
        List<Pricing> pricingList = List.of(milk, butter);

        pricingRepository.saveAll(pricingList);
        assertEquals(pricingList.size(), pricingRepository.count());

        Filter filter = Filter.of("firstAttributeName", SearchCondition.LIKE, "акет");

        mockMvc.perform(post("/api/pricing/find-all")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(Collections.singletonList(filter))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements").value(1))
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content").isNotEmpty())
                .andExpect(jsonPath("$.content.[0].productName").value(milk.getProductName()));
    }
}