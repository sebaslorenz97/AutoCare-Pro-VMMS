package com.dulsystems.autocare_pro_vmms.domain.dto;

public record QuoteDto(
        Integer quoteId,
        String quoteDate,
        String quoteDeliveryDate,
        String quoteServiceStatus,
        Boolean quotePaymentMethod,
        Boolean quotePaymentStatus,
        Integer quoteAdvancePayment,
        Boolean quoteRequiresInvoice,
        Integer quoteCarId,
        String quoteCarName
) {}
