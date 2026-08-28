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

@Repository
public class AddressCatalogDao implements IAddressCatalogsDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public StateDto searchStateById(Integer id) {
        try {
            StateDto state = jdbcTemplate.queryForObject(Queries.DQL_STATES_SEARCH_BY_ID,  (ResultSet rs, int rowNum) -> {
                StateDto stateMap = new StateDto();
                stateMap.setStateId(rs.getInt("state_id_pk"));
                stateMap.setStateName(rs.getString("state_name"));
                return stateMap;
            },id);
            return state;
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public StateDto searchStateByName(String stateName) {
        try {
            StateDto state = jdbcTemplate.queryForObject(Queries.DQL_STATES_SEARCH_BY_STATE, (ResultSet rs, int rowNum) -> {
                StateDto stateMap = new StateDto();
                stateMap.setStateId(rs.getInt("state_id_pk"));
                stateMap.setStateName(rs.getString("state_name"));
                return stateMap;
            }, stateName);
            return state;
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public boolean executeSaveState(GeneralRequest request) {
        boolean bin = false;
        int result = jdbcTemplate.update(Queries.DML_STATES_SAVE, new Object[] { request.getStateName() });
        if (result > 0) {
            bin = true;
        }
        return bin;
    }

    @Override
    public boolean executeUpdateStateByName(GeneralRequest request) {
        boolean bin = false;
        int result = jdbcTemplate.update(Queries.DML_STATES_UPDATE_BY_STATE, new Object[] { request.getNewStateName(), request.getStateName() });
        if (result > 0) {
            bin = true;
        }
        return bin;
    }

    @Override
    public boolean removeStateByName(String stateName) {
        boolean bin = false;
        int result = jdbcTemplate.update(Queries.DML_STATES_REMOVE_BY_STATE, stateName);
        if (result > 0) {
            bin = true;
        }
        return bin;
    }

    @Override
    public MunicipalityDto searchMunicipalityById(Integer id) {
        try {
            MunicipalityDto municipality = jdbcTemplate.queryForObject(Queries.DQL_MUNICIPALITIES_SEARCH_BY_ID, (ResultSet rs, int rowNum) -> {
                MunicipalityDto municipalityMap = new MunicipalityDto();
                municipalityMap.setMunicipalityId(rs.getInt("municipality_id_pk"));
                municipalityMap.setMunicipalityName(rs.getString("municipality_name"));
                municipalityMap.setStateId(rs.getInt("state_id_fk"));
                return municipalityMap;
            }, id);
            return municipality;
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public MunicipalityDto searchMunicipalityByName(String municipalityName) {
        try {
            MunicipalityDto municipality = jdbcTemplate.queryForObject(Queries.DQL_MUNICIPALITIES_SEARCH_BY_MUNICIPALITY, (ResultSet rs, int rowNum) -> {
                MunicipalityDto municipalityMap = new MunicipalityDto();
                municipalityMap.setMunicipalityId(rs.getInt("municipality_id_pk"));
                municipalityMap.setMunicipalityName(rs.getString("municipality_name"));
                municipalityMap.setStateId(rs.getInt("state_id_fk"));
                return municipalityMap;
            }, municipalityName);
            return municipality;
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public boolean executeSaveMunicipality(GeneralRequest request, StateDto state) {
        boolean bin = false;
        int result = jdbcTemplate.update(Queries.DML_MUNICIPALITIES_SAVE, new Object[] { state.getStateId(), request.getMunicipalityName() });
        if (result > 0) {
            bin = true;
        }
        return bin;
    }

    @Override
    public boolean executeUpdateMunicipalityByName(GeneralRequest request, StateDto state) {
        boolean bin = false;
        int result = jdbcTemplate.update(Queries.DML_MUNICIPALITIES_UPDATE_BY_MUNICIPALITY, new Object[] { state.getStateId(), request.getNewMunicipalityName(), request.getMunicipalityName() });
        if (result > 0) {
            bin = true;
        }
        return bin;
    }

    @Override
    public boolean removeMunicipalityByName(String municipalityName) {
        boolean bin = false;
        int result = jdbcTemplate.update(Queries.DML_MUNICIPALITIES_REMOVE_BY_MUNICIPALITY, municipalityName);
        if (result > 0) {
            bin = true;
        }
        return bin;
    }
}
