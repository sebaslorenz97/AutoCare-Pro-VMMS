package com.dulsystems.autocare_pro_vmms.domain.dto;

import java.util.List;

public record QuoteDetailsCUDBean(
        List<QuoteDetailDto> lqdb,
        int[] lqdbForDelete
) {}
