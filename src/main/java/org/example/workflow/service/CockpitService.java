package org.example.workflow.service;

import org.example.workflow.model.VacationBpmsModel;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface CockpitService {

    void deployBpmnFile(MultipartFile multipartBpmnFile);
    void deleteProcess(String definitionKey);
    List<String> deployedProcesses();
    String getBpmnModel(String processInstanceId);
    void startProcessInstance(VacationBpmsModel model, String processName);
    void deleteAllProcesses();
}
