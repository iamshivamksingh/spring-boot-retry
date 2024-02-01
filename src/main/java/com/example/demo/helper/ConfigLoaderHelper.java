package com.example.demo.helper;

import com.example.demo.bean.EmailProperty;
import com.example.demo.bean.OrderStatusesForRemoval;
import com.example.demo.bean.ConfigProperty;
import com.example.demo.bean.Workflow;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

import static com.example.demo.util.ConfigUtil.configId;
import static com.example.demo.util.ConfigUtil.getClusterType;

/**
 * @author sksingh created on 18/01/24
 */
@Component
@RequiredArgsConstructor
public class ConfigLoaderHelper {

    private final ObjectMapper MAPPER = new ObjectMapper();

    private final Map<String, ConfigProperty> configPropertyMap;

    public EmailProperty getEmailProperty() {
        Map<String, EmailProperty> emailLink = getMetadataFieldValue(
                "emailLink",
                new TypeReference<>() {
                }
        );

        return emailLink.get(getClusterType());
    }

    public List<String> getSupportEmails() {
        Map<String, List<String>> supportEmailsMapOnClusterType =
                getMetadataFieldValue(
                        "supportEmailInCaseOrderConfirmationRetryAttemptsExhausted",
                        new TypeReference<>() {
                        }
                );

        return supportEmailsMapOnClusterType.get(getClusterType());
    }

    public OrderStatusesForRemoval getOrderStatusesForRemoval() {
        return getMetadataFieldValue("orderStatusesForRemoval", new TypeReference<>() {
        });
    }

    public <T> T getMetadataFieldValue(String field, TypeReference<T> typeReference) {
        return transform(getMetadata().get(field), typeReference);
    }

    public Map<String, Object> getMetadata() {
        return getConfigProperty().getMetadata();
    }

    public Workflow getWorkflow(String workflowId) {
        return getConfigProperty().getWorkflowConfig().get(workflowId);
    }

    private <T> T transform(Object val, TypeReference<T> typeReference) {
        return MAPPER.convertValue(val, typeReference);
    }

    private ConfigProperty getConfigProperty() {
        String configId = configId();

        return configPropertyMap.get(configId);
    }
}
