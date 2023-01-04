package com.kefas.CrudBackendAndFrontend.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {

    private String Message;

    private String debugMessage;

    private HttpStatus status;

    private LocalDateTime date = LocalDateTime.now();
}
