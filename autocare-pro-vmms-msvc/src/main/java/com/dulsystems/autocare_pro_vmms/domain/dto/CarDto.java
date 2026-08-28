package com.dulsystems.autocare_pro_vmms.domain.dto;

public record CarDto(
        Integer carId,
        String carLicensePlate,
        String carColor,
        Integer carMileage,
        String customerName,
        Integer customerId,
        String carModelName,
        Integer carModelId,
        Integer carYear,
        Integer carYearId,
        String carBrandName,
        Integer carBrandId

        //REQUEST FIELDS IN MAPPER: FOR GET CUSTOMER VEHICLES
) {}
