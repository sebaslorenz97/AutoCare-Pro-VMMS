package com.dulsystems.autocare_pro_vmms.domain.service;

import com.dulsystems.autocare_pro_vmms.domain.dto.GeneralRequest;
import com.dulsystems.autocare_pro_vmms.domain.dto.GeneralResponse;

public interface IAddressCatalogService {
    //SERVICES FOR STATES
    GeneralResponse searchStateByName(String stateName);
    GeneralResponse executeSaveState(GeneralRequest request);
    GeneralResponse executeUpdateStateByName(GeneralRequest request);
    GeneralResponse removeStateByName(String stateName);

    //SERVICES FOR MUNICIPALITIES
    GeneralResponse searchMunicipalityByName(String municipalityName);
    GeneralResponse executeSaveMunicipality(GeneralRequest request);
    GeneralResponse executeUpdateMunicipalityByName(GeneralRequest request);
    GeneralResponse removeMunicipalityByName(String municipalityName);
}
