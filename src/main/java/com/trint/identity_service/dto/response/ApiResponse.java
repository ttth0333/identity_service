package com.trint.identity_service.dto.response;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
// khi hien thi qua json object nao null thi k hiện
public class ApiResponse<T> {
    //api tra ve code 1000 = success => gan cung
    private int code = 1000;
    private String message;
    private T result;
}
