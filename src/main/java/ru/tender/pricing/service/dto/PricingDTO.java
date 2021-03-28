package ru.tender.pricing.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@ApiModel("Продукт")
@NoArgsConstructor
@AllArgsConstructor
public class PricingDTO {

    @ApiModelProperty(value = "Идентификатор продукта", example = "1")
    private Integer id;

    @ApiModelProperty(value = "Наименование продукта", example = "Молоко")
    private String productName;

    @ApiModelProperty(value = "Идентификатор атрибута продукта", example = "1")
    private Integer firstAttributeId;
    @ApiModelProperty(value = "Наименование атрибута продукта", example = "Пастеризованное")
    private String firstAttributeName;

    @ApiModelProperty(value = "Идентификатор атрибута продукта", example = "1")
    private Integer secondAttributeId;
    @ApiModelProperty(value = "Наименование атрибута продукта", example = "Пакет")
    private String secondAttributeName;

    @ApiModelProperty(value = "Идентификатор атрибута продукта", example = "1")
    private Integer thirdAttributeId;
    @ApiModelProperty(value = "Наименование атрибута продукта", example = "Простосквашено")
    private String thirdAttributeName;

    @ApiModelProperty(value = "Идентификатор атрибута продукта", example = "1")
    private Integer fourthAttributeId;
    @ApiModelProperty(value = "Наименование атрибута продукта", example = "Прочее")
    private String fourthAttributeName;

    @ApiModelProperty(value = "Идентификатор атрибута продукта", example = "1")
    private Integer fifthAttributeId;
    @ApiModelProperty(value = "Наименование атрибута продукта", example = "Прочее")
    private String fifthAttributeName;

    @ApiModelProperty(value = "Идентификатор атрибута продукта", example = "1")
    private Integer sixthAttributeId;
    @ApiModelProperty(value = "Наименование атрибута продукта", example = "Прочее")
    private String sixthAttributeName;

    @ApiModelProperty(value = "Идентификатор атрибута продукта", example = "1")
    private Integer seventhAttributeId;
    @ApiModelProperty(value = "Наименование атрибута продукта", example = "Прочее")
    private String seventhAttributeName;

    @ApiModelProperty(value = "Идентификатор атрибута продукта", example = "1")
    private Integer eighthAttributeId;
    @ApiModelProperty(value = "Наименование атрибута продукта", example = "Прочее")
    private String eighthAttributeName;

    @ApiModelProperty(value = "Идентификатор атрибута продукта", example = "1")
    private Integer ninthAttributeId;
    @ApiModelProperty(value = "Наименование атрибута продукта", example = "Прочее")
    private String ninthAttributeName;

    @ApiModelProperty(value = "Идентификатор атрибута продукта", example = "1")
    private Integer tenthAttributeId;
    @ApiModelProperty(value = "Наименование атрибута продукта", example = "Прочее")
    private String tenthAttributeName;
}
