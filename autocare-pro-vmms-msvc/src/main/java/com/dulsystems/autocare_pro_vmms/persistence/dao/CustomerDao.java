package com.dulsystems.autocare_pro_vmms.persistence.dao;

import com.dulsystems.autocare_pro_vmms.domain.dto.CustomerDto;
import com.dulsystems.autocare_pro_vmms.domain.dto.GeneralRequest;
import com.dulsystems.autocare_pro_vmms.domain.dto.MunicipalityDto;
import com.dulsystems.autocare_pro_vmms.domain.dto.StateDto;
import com.dulsystems.autocare_pro_vmms.persistence.util.Queries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class CustomerDao implements ICustomerDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public CustomerDto searchCustomerByName(String name) {
        try {
            CustomerDto customer = jdbcTemplate.queryForObject(Queries.DQL_CUSTOMERS_SEARCH_BY_NAME, (ResultSet rs, int rowNum) -> {
                CustomerDto customerMap = new CustomerDto();
                customerMap.setCustomerId((rs.getInt("customer_id_pk")));
                customerMap.setCustomerName((rs.getString("customer_name")));
                customerMap.setCustomerType((rs.getBoolean("customer_type")));
                customerMap.setCustomerContactPerson((rs.getString("contact_person")));
                customerMap.setCustomerRfc((rs.getString("rfc")));
                customerMap.setCustomerZipCode((rs.getString("zip_code")));
                customerMap.setCustomerEmail((rs.getString("email")));
                customerMap.setCustomerPhoneNumber((rs.getString("phone_number")));
                customerMap.setCustomerStateName((rs.getString("state_name")));
                customerMap.setCustomerMunicipalityName((rs.getString("municipality_name")));
                customerMap.setCustomerStateId((rs.getInt("state_id_fk")));
                customerMap.setCustomerMunicipalityId((rs.getInt("municipality_id_fk")));
                return customerMap;
            },name);
            return customer;
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<String> searchCustomersByPatternName(String patternName) {
        try {
            StringBuilder patternCompleted = new StringBuilder();
            patternCompleted.append("%");
            patternCompleted.append(patternName);
            patternCompleted.append("%");
            List<String> customerList = jdbcTemplate.queryForList(Queries.DQL_CUSTOMERS_SEARCH_CONTAINS, String.class, patternCompleted.toString());
            return customerList;
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public boolean executeSaveCustomer(GeneralRequest request, StateDto state, MunicipalityDto municipality) {
        boolean bin = false;
        int result = jdbcTemplate.update(Queries.DML_CUSTOMERS_SAVE, new Object[] { state.getStateId(), municipality.getMunicipalityId(), request.getCustomerName(), request.getCustomerType(), request.getCustomerContactPerson(), request.getCustomerRfc(), request.getCustomerZipCode(), request.getCustomerEmail(), request.getCustomerPhoneNumber() });
        if (result > 0) {
            bin = true;
        }
        return bin;
    }

    @Override
    public boolean executeUpdateCustomerByName(GeneralRequest request, StateDto state, MunicipalityDto municipality) {
        System.out.println("YA ESTA EN UPDATE CUSTOMER DAO");
        boolean bin = false;
        int result = jdbcTemplate.update(Queries.DML_CUSTOMERS_UPDATE_BY_NAME, new Object[] { state.getStateId(), municipality.getMunicipalityId(), request.getNewCustomerName(), request.getCustomerType(), request.getCustomerContactPerson(), request.getCustomerRfc(), request.getCustomerZipCode(), request.getCustomerEmail(), request.getCustomerPhoneNumber(), request.getCustomerName() });
        if (result > 0) {
            bin = true;
        }
        return bin;
    }

    @Override
    public boolean removeCustomerByName(String name) {
        boolean bin = false;
        int result = jdbcTemplate.update(Queries.DML_CUSTOMERS_REMOVE_BY_NAME, name);
        if (result > 0) {
            bin = true;
        }
        return bin;
    }
}
