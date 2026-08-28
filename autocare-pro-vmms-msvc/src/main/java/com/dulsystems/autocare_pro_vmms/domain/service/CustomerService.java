package com.dulsystems.autocare_pro_vmms.domain.service;

import com.dulsystems.autocare_pro_vmms.domain.dto.*;
import com.dulsystems.autocare_pro_vmms.domain.exception.BusinessException;
import com.dulsystems.autocare_pro_vmms.persistence.dao.AddressCatalogDao;
import com.dulsystems.autocare_pro_vmms.persistence.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    CustomerDao customerDao;

    @Autowired
    AddressCatalogDao addressCatalogDao;

    @Override
    public GeneralResponse searchCustomerByName(String name) {
        GeneralResponse response = new GeneralResponse();
        CustomerDto customer = customerDao.searchCustomerByName(name);
        if(customer != null) {
            response.setCode("OK");
            response.setMessage("Consulta realizada");
            response.setCustomerDto(customer);
        }else {
            throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No existe el cliente");
        }
        return response;
    }

    @Override
    public GeneralResponse searchCustomersByPatternName(String patternName) {
        GeneralResponse response = new GeneralResponse();
        List<String> customerList = new ArrayList<String>();
        customerList = customerDao.searchCustomersByPatternName(patternName);
        response.setCode("OK");
        response.setMessage("Consulta realizada");
        response.setCl(customerList);
        return response;
    }

    @Override
    public GeneralResponse executeSaveCustomer(GeneralRequest request) {
        GeneralResponse response = new GeneralResponse();
        if(customerDao.searchCustomerByName(request.getCustomerName())==null) {
            StateDto state = addressCatalogDao.searchStateByName(request.getCustomerStateName());
            MunicipalityDto mb = addressCatalogDao.searchMunicipalityByName(request.getCustomerMunicipalityName());
            if(state != null) {
                if(mb != null) {
                    if(customerDao.executeSaveCustomer(request, state, mb) == true) {
                        response.setCode("OK");
                        response.setMessage("Se guardo el registro");
                        response.setCustomerDto(customerDao.searchCustomerByName(request.getCustomerName()));
                    }else{
                        throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo guardar el registro");
                    }
                }else {
                    throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el municipio");
                }
            }else {
                throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el estado");
            }
        }else {
            throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese cliente ya existe, intenta con otro");
        }
        return response;
    }

    @Override
    public GeneralResponse executeUpdateCustomerByName(GeneralRequest request) {
        GeneralResponse response = new GeneralResponse();
        if(customerDao.searchCustomerByName(request.getCustomerName())!=null) {
            //StateDto state = addressCatalogDao.searchStateByName(request.getCustomerStateName());
            //MunicipalityDto municipality = addressCatalogDao.searchMunicipalityByName(request.getCustomerMunicipalityName());
            if(request.getNewCustomerName().equals(request.getCustomerName())) {
                StateDto state = addressCatalogDao.searchStateByName(request.getCustomerStateName());
                MunicipalityDto municipality = addressCatalogDao.searchMunicipalityByName(request.getCustomerMunicipalityName());
                if(state != null) {
                    if(municipality != null) {
                        if(customerDao.executeUpdateCustomerByName(request, state, municipality) == true) {
                            response.setCode("OK");
                            response.setMessage("Se actualizo el registro");
                        }else{
                            throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo actualizar el registro");
                        }
                    }else {
                        throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el municipio");
                    }
                }else {
                    throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el estado");
                }
            }else {
                if(customerDao.searchCustomerByName(request.getNewCustomerName())==null) {
                    StateDto state = addressCatalogDao.searchStateByName(request.getCustomerStateName());
                    MunicipalityDto municipality = addressCatalogDao.searchMunicipalityByName(request.getCustomerMunicipalityName());
                    if(state != null) {
                        if(municipality != null) {
                            if(customerDao.executeUpdateCustomerByName(request, state, municipality) == true) {
                                response.setCode("OK");
                                response.setMessage("Se actualizo el registro");
                            }else{
                                throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo actualizar el registro");
                            }
                        }else {
                            throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el municipio");
                        }
                    }else {
                        throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el estado");
                    }
                }else {
                    throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"Ese cliente ya existe, intenta con otro");
                }
            }
        }else {
            throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No existe el cliente que quieres actualizar");
        }
        return response;
    }

    @Override
    public GeneralResponse removeCustomerByName(String name) {
        GeneralResponse response = new GeneralResponse();
        if(customerDao.searchCustomerByName(name)!=null){
            if(customerDao.removeCustomerByName(name)) {
                response.setCode("OK");
                response.setMessage("Se elimino el registro");
            }else{
                throw new BusinessException("E-SERVICE-DAO",HttpStatus.BAD_REQUEST,"No se pudo eliminar el registro");
            }
        }else {
            throw new BusinessException("E-SERVICE-DAO_VALIDATIONS",HttpStatus.BAD_REQUEST,"No se elimino porque el cliente no existe");
        }
        return response;
    }
}
