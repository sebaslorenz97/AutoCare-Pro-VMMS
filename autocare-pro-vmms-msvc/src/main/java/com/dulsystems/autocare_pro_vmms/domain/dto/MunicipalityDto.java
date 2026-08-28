package com.dulsystems.autocare_pro_vmms.domain.dto;

import lombok.Data;

@Data
public class MunicipalityDto {
    private Integer municipalityId;
    private String municipalityName;
    private String stateName;
    private Integer stateId;
}
