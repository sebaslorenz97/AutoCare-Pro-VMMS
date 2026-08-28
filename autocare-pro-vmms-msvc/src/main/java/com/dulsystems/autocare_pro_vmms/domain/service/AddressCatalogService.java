package com.dulsystems.autocare_pro_vmms.domain.service;

import com.dulsystems.autocare_pro_vmms.domain.dto.GeneralRequest;
import com.dulsystems.autocare_pro_vmms.domain.dto.GeneralResponse;
import com.dulsystems.autocare_pro_vmms.domain.dto.MunicipalityDto;
import com.dulsystems.autocare_pro_vmms.domain.dto.StateDto;
import com.dulsystems.autocare_pro_vmms.domain.exception.BusinessException;
import com.dulsystems.autocare_pro_vmms.persistence.dao.IAddressCatalogsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AddressCatalogService implements IAddressCatalogService{

    @Autowired
    private IAddressCatalogsDao addressCatalogsDao;

    @Override
    public GeneralResponse searchStateByName(String stateName) {
        GeneralResponse response = new GeneralResponse();
        StateDto sb = addressCatalogsDao.searchStateByName(stateName);
        if(sb != null) {
            response.setCode("OK");
            response.setMessage("Consulta realizada");
            response.setStateDto(sb);
        }else {
            throw new BusinessException("E-SERVICE-DAO", HttpStatus.BAD_REQUEST,"No existe el estado");
        }
        return response;
    }

    @Override
    public GeneralResponse executeSaveState(GeneralRequest request) {
        GeneralResponse response = new GeneralResponse();
        if(addressCatalogsDao.searchStateByName(request.getStateName())==null) {
            if(addressCatalogsDao.executeSaveState(request) == true) {
                response.setCode("OK");
                response.setMessage("Se guardo el registro");

            }else{
                throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo guardar el registro");
            }
        }else {
            throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese estado ya existe, intenta con otro");
        }
        return response;
    }

    @Override
    public GeneralResponse executeUpdateStateByName(GeneralRequest request) {
        GeneralResponse response = new GeneralResponse();
        if(addressCatalogsDao.searchStateByName(request.getStateName())!=null) {
            if(addressCatalogsDao.searchStateByName(request.getNewStateName())==null) {
                if(addressCatalogsDao.executeUpdateStateByName(request) == true) {
                    response.setCode("OK");
                    response.setMessage("Se actualizo el registro");

                }else{
                    throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo actualizar el registro");
                }
            }else {
                throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese estado ya existe, intenta con otro");
            }
        }else{
            throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el estado que quieres actualizar");
        }
        return response;
    }

    @Override
    public GeneralResponse removeStateByName(String stateName) {
        GeneralResponse response = new GeneralResponse();
        if(addressCatalogsDao.searchStateByName(stateName)!=null) {
            if(addressCatalogsDao.removeStateByName(stateName)) {
                response.setCode("OK");
                response.setMessage("Se elimino el registro");
            }else{
                throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo eliminar el registro");
            }
        }else{
            throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se elimino porque el estado no existe");
        }
        return response;
    }

    @Override
    public GeneralResponse searchMunicipalityByName(String municipalityName) {
        GeneralResponse response = new GeneralResponse();
        MunicipalityDto municipality = addressCatalogsDao.searchMunicipalityByName(municipalityName);
        if(municipality != null) {
            response.setCode("OK");
            response.setMessage("Consulta realizada");
            municipality.setStateName(addressCatalogsDao.searchStateById(municipality.getStateId()).getStateName());
            response.setMunicipalityDto(municipality);
        }else {
            throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No existe el municipio");
        }
        return response;
    }

    @Override
    public GeneralResponse executeSaveMunicipality(GeneralRequest request) {
        GeneralResponse response = new GeneralResponse();
        if(addressCatalogsDao.searchMunicipalityByName(request.getMunicipalityName())==null) {
            StateDto sb = addressCatalogsDao.searchStateByName(request.getStateNameFk());
            if(sb != null) {
                if(addressCatalogsDao.executeSaveMunicipality(request, sb) == true) {
                    response.setCode("OK");
                    response.setMessage("Se guardo el registro");

                }else{
                    throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo guardar el registro");
                }
            }else {
                throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el estado");
            }
        }else {
            throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese municipio ya existe, intenta con otro");
        }
        return response;
    }

    @Override
    public GeneralResponse executeUpdateMunicipalityByName(GeneralRequest request) {
        GeneralResponse response = new GeneralResponse();
        if(addressCatalogsDao.searchMunicipalityByName(request.getMunicipalityName())!=null) {
            if(addressCatalogsDao.searchMunicipalityByName(request.getNewMunicipalityName())==null) {
                StateDto state = addressCatalogsDao.searchStateByName(request.getStateNameFk());
                if(state != null) {
                    if(addressCatalogsDao.executeUpdateMunicipalityByName(request, state) == true) {
                        response.setCode("OK");
                        response.setMessage("Se actualizo el registro");

                    }else{
                        throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo actualizar el registro");
                    }
                }else {
                    throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el estado");
                }
            }else {
                throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese municipio ya existe, intenta con otro");
            }
        }else {
            throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el municipio que quieres actualizar");
        }
        return response;
    }

    @Override
    public GeneralResponse removeMunicipalityByName(String municipalityName) {
        GeneralResponse response = new GeneralResponse();
        if(addressCatalogsDao.searchMunicipalityByName(municipalityName)!=null) {
            if(addressCatalogsDao.removeMunicipalityByName(municipalityName)) {
                response.setCode("OK");
                response.setMessage("Se elimino el registro");

            }else{
                throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo eliminar el registro");
            }
        }else {
            throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se elimino porque el municipio no existe");
        }
        return response;
    }
}
