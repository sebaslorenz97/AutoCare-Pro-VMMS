package com.dulsystems.autocare_pro_vmms.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {
    String code;
    String message;
    String level;
    String description;
    String moreInfo;
}
