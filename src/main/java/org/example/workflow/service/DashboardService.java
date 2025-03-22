package org.example.workflow.service;

import org.example.workflow.model.ManagerAnswerModel;
import org.example.workflow.model.TaskInboxItemModel;
import org.example.workflow.model.TasksSearchModel;
import org.example.workflow.model.WorkflowStepModel;
import java.util.List;

public interface DashboardService {

    List<TaskInboxItemModel> userSearchClaimableTasks(TasksSearchModel searchParams);
    List<TaskInboxItemModel> userAssignedTasks(TasksSearchModel searchParams);
    List<TaskInboxItemModel> userCompletedTasks(TasksSearchModel searchParams);
    List<WorkflowStepModel> getWorkflowStepsFor(String processInstanceId);
    void claimTask(String taskId);
    void completeTask (ManagerAnswerModel managerAnswerModel);
    ManagerAnswerModel managerAnswer (String taskId);

}