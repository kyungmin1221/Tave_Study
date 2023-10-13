package com.in28minutes.rest.webservices.restfulwebservices.exception;


import java.time.LocalDate;
import java.time.LocalDateTime;

// 에러가 발생했을 시 시간
// 에러 메시지 , 에러의 상세 정보
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
