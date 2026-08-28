package com.dulsystems.autocare_pro_vmms.web.controller;

import com.dulsystems.autocare_pro_vmms.domain.dto.GeneralRequest;
import com.dulsystems.autocare_pro_vmms.domain.dto.GeneralResponse;
import com.dulsystems.autocare_pro_vmms.domain.service.IAddressCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("autocare-pro-vmms/v1/address-catalog")
public class AddressCatalogController {

    @Autowired
    private IAddressCatalogService addressCatalogsService;

    //CONTROLLERS FOR STATE
    @GetMapping("/states/{stateName}")
    public ResponseEntity<GeneralResponse> searchStateByName(@PathVariable("stateName") String stateName)  {
        return new ResponseEntity<GeneralResponse>(addressCatalogsService.searchStateByName(stateName), HttpStatus.OK);
    }

    @PostMapping("/states")
    public ResponseEntity<GeneralResponse> executeSaveState(@Validated @RequestBody GeneralRequest request) {
        return new ResponseEntity<GeneralResponse>(addressCatalogsService.executeSaveState(request),HttpStatus.CREATED);
    }

    @PutMapping("/states/{stateName}")
    public ResponseEntity<GeneralResponse> executeUpdateStateByName(@PathVariable("stateName") String stateName, @Validated @RequestBody GeneralRequest request) {
        return new ResponseEntity<GeneralResponse>(addressCatalogsService.executeUpdateStateByName(request),HttpStatus.OK);
    }

    @DeleteMapping("/states/{stateName}")
    public ResponseEntity<GeneralResponse> removeStateByName(@PathVariable("stateName") String stateName) {
        return new ResponseEntity<GeneralResponse>(addressCatalogsService.removeStateByName(stateName),HttpStatus.OK);
    }

    //CONTROLLERS FOR MUNICIPALITY
    @GetMapping("/municipalities/{municipalityName}")
    public ResponseEntity<GeneralResponse> searchMunicipalityByName(@PathVariable("municipalityName") String municipalityName)  {
        return new ResponseEntity<GeneralResponse>(addressCatalogsService.searchMunicipalityByName(municipalityName),HttpStatus.OK);
    }

    @PostMapping("/municipalities")
    public ResponseEntity<GeneralResponse> executeSaveMunicipality(@Validated @RequestBody GeneralRequest request) {
        return new ResponseEntity<GeneralResponse>(addressCatalogsService.executeSaveMunicipality(request),HttpStatus.CREATED);
    }

    @PutMapping("/municipalities/{municipalityName}")
    public ResponseEntity<GeneralResponse> executeUpdateMunicipalityByName(@PathVariable("municipalityName") String municipalityName, @Validated @RequestBody GeneralRequest request) {
        return new ResponseEntity<GeneralResponse>(addressCatalogsService.executeUpdateMunicipalityByName(request),HttpStatus.OK);
    }

    @DeleteMapping("/municipalities/{municipalityName}")
    public ResponseEntity<GeneralResponse> removeMunicipalityByName(@PathVariable("municipalityName") String municipalityName) {
        return new ResponseEntity<GeneralResponse>(addressCatalogsService.removeMunicipalityByName(municipalityName),HttpStatus.OK);
    }

}
