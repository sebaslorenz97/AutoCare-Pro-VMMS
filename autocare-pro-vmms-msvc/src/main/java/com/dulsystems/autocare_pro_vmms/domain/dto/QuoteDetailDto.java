package com.dulsystems.autocare_pro_vmms.domain.dto;

public record QuoteDetailDto(
        Integer quoteDetailId,
        Integer quoteDetailMechanicNumber,
        String quoteDetailItemType,
        Integer quoteDetailUnitPrice,
        Integer quoteId
) {}