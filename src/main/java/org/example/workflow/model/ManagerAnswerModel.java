package org.example.workflow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ReflectionUtils;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerAnswerModel {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String taskId;
    private boolean accept;
    private String letter;

    public static ManagerAnswerModel fromMap(Map<String, Object> map) {
        ManagerAnswerModel result = new ManagerAnswerModel();
        ReflectionUtils.doWithFields(ManagerAnswerModel.class, field -> field.set(result, map.get(field.getName())));
        return result;
    }

    public Map<String, Object> createMap() {
        Map<String, Object> result = new HashMap<>();
        ReflectionUtils.doWithFields(ManagerAnswerModel.class, field -> result.put(field.getName(), field.get(this)));
        return result;
    }

}
