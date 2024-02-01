package com.App.Documentation.SNPC.exception;

import java.time.LocalDateTime;

public record ApiError(
        String path,
        String message,

        int statusCode,
        LocalDateTime timestamp
) {


}
