package com.dulsystems.autocare_pro_vmms.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class GeneralResponse {
    String code;
    String message;
    String customer;
    String car;
    String quote;
    CustomerDto customerDto;
    StateDto stateDto;
    MunicipalityDto municipalityDto;
    CarDto carDto;
    CarBrandDto carBrandDto;
    CarModelDto carModelDto;
    CarYearDto carYearDto;
    QuoteDto quoteDto;
    List<QuoteDetailDto> quoteDetailDtoList;
    List<CarDto> carDtoList;
    List<QuoteDto> quoteDtoList;
    UserDto userDto;
    UserSystemRoleDto userSystemRoleDto;
    List<String> carBrands;
    List<String> carModels;
    List<String> carYears;
    List<String> SystemRoles;
    List<String> cars;
    List<String> cl; //PENDING WHAT IS THIS FIEL USED FOR?
    String roleAssignmentOperationResult;
    //List<GrantedAuthority> rolesFromAuthentication;
}
