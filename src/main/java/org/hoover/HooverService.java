package org.hoover;

import org.hoover.dto.HooverInputDTO;
import org.hoover.dto.HooverOutputDTO;
import org.hoover.model.Point;
import org.springframework.stereotype.Service;

@Service
public class HooverService {
    public HooverOutputDTO cleanTheRoom(HooverInputDTO hooverInputDTO) {
        validateInput(hooverInputDTO);

        String instructions = hooverInputDTO.instructions();
        Point coords = hooverInputDTO.coords();
        int patches = 0;

        for (int i = 0; i < instructions.length(); i++) {
            patches = cleanIfDirty(hooverInputDTO, coords, patches);
            Point instruction = InstructionsParser.parseInstruction(instructions.charAt(i));
            coords = moveHoover(coords, instruction, hooverInputDTO.roomSize());
        }

        return new HooverOutputDTO(coords, patches);
    }

    private void validateInput(HooverInputDTO hooverInputDTO) {
        if (hooverInputDTO.coords().x() > hooverInputDTO.roomSize().x() || hooverInputDTO.coords().y() > hooverInputDTO.roomSize().y()) {
            throw new IllegalArgumentException("Error! Incorrect initial position of the hoover - x must be less or equal to roomSize.x and y must be less or equal to roomSize.y");
        }

        if (hooverInputDTO.coords().x() < 0 || hooverInputDTO.coords().y() < 0 || hooverInputDTO.patches().stream().anyMatch(point -> point.x() < 0 || point.y() < 0)) {
            throw new IllegalArgumentException("Error! Coordinates must be not negative");
        }
    }

    private int cleanIfDirty(HooverInputDTO hooverInputDTO, Point coords, int patches) {
        if (hooverInputDTO.patches().contains(coords)) {
            patches++;
            hooverInputDTO.patches().remove(coords);
        }
        return patches;
    }

    private Point moveHoover(Point coords, Point instruction, Point roomSize) {
        int x = coords.x() + instruction.x();
        int y = coords.y() + instruction.y();
        return new Point(x >= 0 && x <= roomSize.x() ? x : coords.x(),
                y >= 0 && y <= roomSize.y() ? y : coords.y());
    }
}
