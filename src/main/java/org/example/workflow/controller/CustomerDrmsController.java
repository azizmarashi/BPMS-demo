package org.example.workflow.controller;

import org.example.workflow.model.CustomerDrmsModel;
import org.example.workflow.model.CustomerRegistrationResponseModel;
import org.example.workflow.service.CustomerDrmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drms")
public class CustomerDrmsController {

    @Autowired
    private CustomerDrmsService customerDrmsService;

    @ResponseBody
    @PostMapping("/register-customer-by-age")
    public CustomerRegistrationResponseModel registerCustomerByAge(@RequestBody CustomerDrmsModel customerDrmsModel){
        return customerDrmsService.registerCustomerByAge(customerDrmsModel);
    }

}