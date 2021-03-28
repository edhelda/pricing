package ru.tender.pricing.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@ToString
@ApiModel("Фильтр, содержащий информацию для построения запроса")
@AllArgsConstructor
@NoArgsConstructor
public class Filter {

    @NotBlank
    @ApiModelProperty(value = "Наименование поля, по которому необходимо построить условие поиска", example = "productName")
    private String key;

    @NotNull
    @ApiModelProperty(value = "Условие поиска", example = "EQUALS")
    private SearchCondition searchCondition;

    @ApiModelProperty(value = "Значение поиска", example = "Молоко")
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
