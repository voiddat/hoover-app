package org.hoover.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hoover.model.Point;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public record HooverInputDTO(Point roomSize, Point coords, Set<Point> patches, String instructions) {
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public HooverInputDTO(@JsonProperty("roomSize") int[] roomSize, @JsonProperty("coords") int[] coords, @JsonProperty("patches") int[][] patches, @JsonProperty("instructions") String instructions) {
        this(new Point(roomSize[0], roomSize[1]), new Point(coords[0], coords[1]), Arrays.stream(patches).map(patch -> new Point(patch[0], patch[1])).collect(Collectors.toSet()), instructions);
    }
}
