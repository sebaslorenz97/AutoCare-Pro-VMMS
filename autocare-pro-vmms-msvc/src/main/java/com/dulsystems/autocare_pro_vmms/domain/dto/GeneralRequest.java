package com.dulsystems.autocare_pro_vmms.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class GeneralRequest {
    //REQUEST FIELDS FOR STATE (EDIT!!!)
    private Integer stateId;
    private String stateName;
    private String newStateName;

    //REQUEST FIELDS FOR MUNICIPALITY (EDIT!!!)
    private Integer municipalityId;
    private String municipalityName;
    private String newMunicipalityName;
    //FKs FOR CUSTOMER & MUNICIPALITY (EDIT!!!)
    private String stateNameFk;
    private Integer stateIdFk;

    //REQUEST FIELDS FOR CUSTOMER
    private Integer customerId;
    private String customerName;
    private Boolean customerType;
    private String customerContactPerson;
    private String customerRfc;
    private String customerZipCode;
    private String customerEmail;
    private String customerPhoneNumber;
    private String newCustomerName;
    //FKs FOR CUSTOMER ONLY (EDIT!!!)
    private String customerStateName;
    private String customerMunicipalityName;

    //REQUEST FIELDS FOR CAR BRAND (EDIT!!!)
    private Integer carBrandId;
    private String carBrandName;
    private String newCarBrandName;

    //REQUEST FIELDS FOR CAR YEAR (EDIT!!!)
    private Integer carYearId;
    private Integer carYear;
    private Integer newCarYear;

    //REQUEST FIELDS FOR CAR MODEL (EDIT!!!)
    private Integer carModelId;
    private String carModel;
    private String newCarModel;
    //FKs FOR CAR & CAR MODEL (EDIT!!!)
    private String carLineNameFk;
    private Integer carLineIdFk;

    //REQUEST FIELDS FOR CAR (EDIT!!!)
    private Integer carId;
    private String carLicensePlate;
    private String newCarLicensePlate;
    private String carColor;
    private Integer carMileage;
    //FKs FOR CAR ONLY (EDIT!!!)
    private String customerNameFk;
    private Integer customerIdFk;
    private String carModelNameFk;
    private Integer carModelIdFk;
    private Integer carYearValueFk;
    private Integer carYearIdFk;

    //REQUEST FIELDS FOR QUOTE (EDIT!!!)
    private Integer quoteId;
    private String quoteDate;
    private String quoteDeliveryDate;
    private String quoteServiceStatus;
    private Boolean quotePaymentMethod;
    private Boolean quotePaymentStatus;
    private Integer quoteAdvancePayment;
    private Boolean quoteRequiresInvoice;
    //FKs FOR QUOTE (EDIT!!!)
    private Integer carIdFk;

    //REQUEST FIELDS FOR QUOTE DETAIL (EDIT!!!)
    private Integer quoteDetailId;
    private Integer quoteDetailMechanicNumber;
    private String quoteDetailItemType;
    private Integer quoteDetailUnitPrice;
    //FKs FOR QUOTE DETAILS (EDIT!!!)
    private Integer quoteIdFk;

    //REQUEST FIELDS FOR QUOTE DETAILS LIST (EDIT!!!)
    private List<QuoteDetailDto>lqdb;
    private List<QuoteDetailDto> lqdbForUpdate;
    private int[] lqdbForDelete;
    private QuoteDetailsCUDBean quoteDetailsCud;

    //REQUEST FIELDS FOR LOGIN & USER (EDIT!!!)
    private String usernameId;
    private String userPassword;
    //REQUEST FIELDS FOR USER (EDIT!!!)
    private String userMechanicNumber;
    private String userFullName;
    private String userEnterpriseRole;
    private String userEmail;
    private Boolean userIsLocked;
    private Boolean userIsDisabled;

    //REQUEST FIELDS FOR ACOOUNT OWNER (EDIT!!!)
    private String myCurrentUserPassword;
    private String myUserPassword;
    private String myUserEmail;

    //REQUEST FIELDS FOR SYSTEM USER ROLES (EDIT!!!)
    private String systemRoleId; //ELIMINAR
    private List<String> systemRoleIds; //ELIMINAR
    private String newSystemRole;  //ELIMINAR
    private Boolean adminRole;
    private Boolean employeeRole;
    private Boolean managerRole;
    private String systemRoleAssignedAt;
    //FKs FOR SYSTEM USER ROLES (EDIT!!!)
    private String username;
}
