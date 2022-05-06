package com.restfulApi.VoTrungHaW4.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> implements Serializable {
    private int code = HttpStatus.OK.value();
    private String status;
    private String message;
    private T result;
}