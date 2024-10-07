package org.hoover.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hoover.serialization.HooverOutputDTOSerializer;
import org.hoover.model.Point;

@JsonSerialize(using = HooverOutputDTOSerializer.class)
public record HooverOutputDTO(Point coords, int patches) {
}
