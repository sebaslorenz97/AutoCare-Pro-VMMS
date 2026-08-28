package com.dulsystems.autocare_pro_vmms.web.controller;

import com.dulsystems.autocare_pro_vmms.domain.dto.GeneralRequest;
import com.dulsystems.autocare_pro_vmms.domain.dto.GeneralResponse;
import com.dulsystems.autocare_pro_vmms.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("autocare-pro-vmms/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customerName}")
    public ResponseEntity<GeneralResponse> searcuCustomerByName(@PathVariable("customerName") String customerName){
        return new ResponseEntity<GeneralResponse>(customerService.searchCustomerByName(customerName), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<GeneralResponse> searchCustomersByPatternName(@RequestParam(required = true) String patternName)  {
        return new ResponseEntity<GeneralResponse>(customerService.searchCustomersByPatternName(patternName),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GeneralResponse> executeSaveCustomer(@Validated @RequestBody GeneralRequest request) {
        return new ResponseEntity<GeneralResponse>(customerService.executeSaveCustomer(request),HttpStatus.CREATED);
    }

    @PutMapping("{customerName}")
    public ResponseEntity<GeneralResponse> executeUpdateCustomerByName(@PathVariable("customerName") String customerName, @Validated @RequestBody GeneralRequest request) {
        return new ResponseEntity<GeneralResponse>(customerService.executeUpdateCustomerByName(request),HttpStatus.OK);
    }

    @DeleteMapping("/{customerName}")
    public ResponseEntity<GeneralResponse> removeCustomerByName(@PathVariable("customerName") String customerName) {
        return new ResponseEntity<GeneralResponse>(customerService.removeCustomerByName(customerName),HttpStatus.OK);
    }

}
