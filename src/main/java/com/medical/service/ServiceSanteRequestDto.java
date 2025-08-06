package com.medical.service;

import java.io.Serializable;

/**
 * DTO for {@link ServiceSante}
 */
public record ServiceSanteRequestDto(String name, TypeService type, Long structureID) implements Serializable {
}