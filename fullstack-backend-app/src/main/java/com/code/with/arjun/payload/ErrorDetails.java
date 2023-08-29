package com.code.with.arjun.payload;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    private String message;
    private String details;
    private LocalDateTime timestamp;
}
