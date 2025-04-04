package org.example.workflow.service.impl;

import org.camunda.bpm.dmn.engine.DmnDecisionTableResult;
import org.camunda.bpm.engine.*;
import org.camunda.bpm.engine.repository.DecisionDefinition;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.example.workflow.model.CustomerDrmsModel;
import org.example.workflow.model.CustomerRegistrationResponseModel;
import org.example.workflow.service.CustomerDrmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDrmsServiceImpl implements CustomerDrmsService {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private DecisionService decisionService;

    @Override
    public CustomerRegistrationResponseModel registerCustomerByAge(CustomerDrmsModel customerDrmsModel) {


        DecisionDefinition decision = repositoryService
                .createDecisionDefinitionQuery()
                .decisionDefinitionKey("customerRegistrationDecision")
                .latestVersion()
                .singleResult();

        VariableMap customerAge = Variables.createVariables()
                .putValue("customerAge", customerDrmsModel.getCustomerAge());

        DmnDecisionTableResult result = decisionService
                .evaluateDecisionTableById(decision.getId(), customerAge);

        boolean approve = result.getFirstResult().getEntry("approve");

        CustomerRegistrationResponseModel responseModel = new CustomerRegistrationResponseModel();
        responseModel.setRegistrationApprove(approve);
        if (approve){
            responseModel.setMessage("Registration Approved");
        }else responseModel.setMessage("Registration Not Approved");

        return responseModel;
    }

}
