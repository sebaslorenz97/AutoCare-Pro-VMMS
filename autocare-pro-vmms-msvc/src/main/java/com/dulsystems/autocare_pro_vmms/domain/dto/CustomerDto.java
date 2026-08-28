package com.dulsystems.autocare_pro_vmms.domain.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private Integer customerId;
    private String customerName;
    private Boolean customerType;
    private String customerContactPerson;
    private String customerRfc;
    private String customerZipCode;
    private String customerEmail;
    private String customerPhoneNumber;
    private String customerStateName;
    private String customerMunicipalityName;
    private Integer customerStateId;
    private Integer customerMunicipalityId;
}