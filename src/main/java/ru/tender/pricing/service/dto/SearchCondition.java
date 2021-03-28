package ru.tender.pricing.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Условия поиска")
public enum SearchCondition {

    @ApiModelProperty(value = "Полное совпадение")
    EQUALS,
    @ApiModelProperty(value = "Частичное совпадение")
    LIKE
}
