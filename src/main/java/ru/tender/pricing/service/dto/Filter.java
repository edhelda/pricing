package ru.tender.pricing.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Filter {

    @NotBlank
    private String key;

    @NotNull
    private SearchCondition searchCondition;

    private String value;

    @JsonIgnore
    public static Filter of(String key, SearchCondition searchCondition, String value) {
        return Filter.builder()
            .key(key)
            .searchCondition(searchCondition)
            .value(value)
            .build();
    }
}
