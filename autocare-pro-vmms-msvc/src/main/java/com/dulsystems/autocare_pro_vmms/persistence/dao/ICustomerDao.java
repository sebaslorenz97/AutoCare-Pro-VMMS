package com.dulsystems.autocare_pro_vmms.persistence.dao;

import com.dulsystems.autocare_pro_vmms.domain.dto.CustomerDto;
import com.dulsystems.autocare_pro_vmms.domain.dto.GeneralRequest;
import com.dulsystems.autocare_pro_vmms.domain.dto.MunicipalityDto;
import com.dulsystems.autocare_pro_vmms.domain.dto.StateDto;

import java.util.List;

public interface ICustomerDao {
    CustomerDto searchCustomerByName(String name);

    List<String> searchCustomersByPatternName(String pattern);

    boolean executeSaveCustomer(GeneralRequest request, StateDto state, MunicipalityDto municipality);

    boolean executeUpdateCustomerByName(GeneralRequest request, StateDto state, MunicipalityDto municipality);

    boolean removeCustomerByName(String name);
}
