package com.dulsystems.autocare_pro_vmms.persistence.dao;

import com.dulsystems.autocare_pro_vmms.domain.dto.GeneralRequest;
import com.dulsystems.autocare_pro_vmms.domain.dto.MunicipalityDto;
import com.dulsystems.autocare_pro_vmms.domain.dto.StateDto;

public interface IAddressCatalogsDao {

    //DAO FOR STATE
    StateDto searchStateById(Integer id);
    StateDto searchStateByName(String stateName);
    boolean executeSaveState(GeneralRequest request);
    boolean executeUpdateStateByName(GeneralRequest request);
    boolean removeStateByName(String stateName);

    //DAO FOR MUNICIPALITY
    MunicipalityDto searchMunicipalityById(Integer id);
    MunicipalityDto searchMunicipalityByName(String municipalityName);
    boolean executeSaveMunicipality(GeneralRequest request, StateDto state);
    boolean executeUpdateMunicipalityByName(GeneralRequest request, StateDto state);
    boolean removeMunicipalityByName(String municipalityName);

}
