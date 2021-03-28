package ru.tender.pricing.service.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PricingDTO {

    private Integer id;

    private String productName;

    private Integer firstAttributeId;
    private String firstAttributeName;

    private Integer secondAttributeId;
    private String secondAttributeName;

    private Integer thirdAttributeId;
    private String thirdAttributeName;

    private Integer fourthAttributeId;
    private String fourthAttributeName;

    private Integer fifthAttributeId;
    private String fifthAttributeName;

    private Integer sixthAttributeId;
    private String sixthAttributeName;

    private Integer seventhAttributeId;
    private String seventhAttributeName;

    private Integer eighthAttributeId;
    private String eighthAttributeName;

    private Integer ninthAttributeId;
    private String ninthAttributeName;

    private Integer tenthAttributeId;
    private String tenthAttributeName;
}
