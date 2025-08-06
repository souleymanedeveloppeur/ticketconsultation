package com.medical.model;

import lombok.Builder;

@Builder
public record ApiResponse<T>(boolean success, String message, T data) {
}
