package org.example.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class TaskInboxItemModel {

//    private final String processInstanceId;
    private final String taskId;
    private final String taskName;
    private final VacationBpmsModel vacationBpmsModel;

    public TaskInboxItemModel( String taskId, String taskName, Map<String, Object> values) {
//        this.processInstanceId = processInstanceId;
        this.taskId = taskId;
        this.taskName = taskName;
        this.vacationBpmsModel = VacationBpmsModel.fromMap(values);
    }

}