package com.dulsystems.autocare_pro_vmms.domain.dto;

public record CarModelDto(
        Integer carModelId,
        String carModelName,
        String carLineName,
        Integer carLineId
) {}
