package com.medical.utils;

import com.medical.model.ApiResponse;

public final class ApiUtil {

    private ApiUtil() {
        // Utility class, prevent instantiation
    }

    public static <T> ApiResponse<T> createSuccessResponse(String message, T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .message(message)
                .build();
    }

    public static <T> ApiResponse<T> createErrorResponse(String message) {
        return ApiResponse.<T>builder()
                .success(false)
                .data(null)
                .message(message)
                .build();
    }
}