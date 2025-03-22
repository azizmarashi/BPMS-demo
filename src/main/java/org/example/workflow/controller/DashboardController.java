package org.example.workflow.controller;

import org.example.workflow.model.ManagerAnswerModel;
import org.example.workflow.model.TaskInboxItemModel;
import org.example.workflow.model.TasksSearchModel;
import org.example.workflow.model.WorkflowStepModel;
import org.example.workflow.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartable")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;


    @GetMapping("/search-claimable-tasks")
    public List<TaskInboxItemModel>  searchClaimableTasks(@RequestBody TasksSearchModel params){
        return dashboardService.userSearchClaimableTasks(params);
    }

    @GetMapping("/user-assigned-tasks")
    public List<TaskInboxItemModel> userAssignedTasks(@RequestBody TasksSearchModel searchParams){
        return dashboardService.userAssignedTasks(searchParams);
    }

    @GetMapping("/user-completed-tasks")
    public List<TaskInboxItemModel> myCompletedTasks(@RequestBody TasksSearchModel searchParams){
        return dashboardService.userCompletedTasks(searchParams);
    }

    @GetMapping("/claim-task")
    public void claimTask(@RequestBody String taskId){
        dashboardService.claimTask(taskId);
    }

    @GetMapping("/get-workflow-steps-for")
    public List<WorkflowStepModel> getWorkflowStepsFor(@RequestBody String processInstanceId){
        return dashboardService.getWorkflowStepsFor(processInstanceId);
    }

    @PostMapping("/answer-task")
    public void answerTask(@RequestBody ManagerAnswerModel managerAnswerModel){
        dashboardService.completeTask(managerAnswerModel);
    }

    @GetMapping("get-answer/{taskID}")
    public ManagerAnswerModel managerAnswer (@PathVariable String taskID){
        return dashboardService.managerAnswer(taskID);
    }

}
