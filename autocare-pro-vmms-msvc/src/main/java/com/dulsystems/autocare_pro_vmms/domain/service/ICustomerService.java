package com.dulsystems.autocare_pro_vmms.domain.service;

import com.dulsystems.autocare_pro_vmms.domain.dto.GeneralRequest;
import com.dulsystems.autocare_pro_vmms.domain.dto.GeneralResponse;

public interface ICustomerService {
    GeneralResponse searchCustomerByName(String name);

    GeneralResponse searchCustomersByPatternName(String string);

    GeneralResponse executeSaveCustomer(GeneralRequest request);

    GeneralResponse executeUpdateCustomerByName(GeneralRequest request);

    GeneralResponse removeCustomerByName(String name);
}
