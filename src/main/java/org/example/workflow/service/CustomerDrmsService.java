package org.example.workflow.service;

import org.example.workflow.model.CustomerDrmsModel;
import org.example.workflow.model.CustomerRegistrationResponseModel;

public interface CustomerDrmsService {

    CustomerRegistrationResponseModel registerCustomerByAge(CustomerDrmsModel customerDrmsModel);
}
