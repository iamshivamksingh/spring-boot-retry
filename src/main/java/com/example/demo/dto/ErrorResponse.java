package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author sksingh created on 01/02/24
 */
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private String status;
    private String code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ErrorBody body;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ErrorBody {
        private String errorMsg;
        private String debugMsg;
    }

}
