package org.example.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.ReflectionUtils;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDrmsModel {

    private String customerFullName;
    private String customerRequestAccount;
    private Long customerAge;


    public static CustomerDrmsModel fromMap(Map<String, Object> map) {
        CustomerDrmsModel result = new CustomerDrmsModel();
        ReflectionUtils.doWithFields(CustomerDrmsModel.class, field -> field.set(result, map.get(field.getName())));
        return result;
    }

    public Map<String, Object> createMap() {
        Map<String, Object> result = new HashMap<>();
        ReflectionUtils.doWithFields(CustomerDrmsModel.class, field -> result.put(field.getName(), field.get(this)));
        return result;
    }
}
