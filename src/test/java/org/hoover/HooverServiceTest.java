package org.hoover;

import org.hoover.dto.HooverInputDTO;
import org.hoover.dto.HooverOutputDTO;
import org.hoover.model.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HooverServiceTest {
    HooverService hooverService = new HooverService();

    @Test
    public void shouldProperlyCleanTheRoom() {
        HooverInputDTO hooverInputDTO = new HooverInputDTO(
                new int[]{5,5},
                new int[]{1,2},
                new int[][]{new int[]{1,0}, new int[]{2,2}, new int[]{2,3}},
                "NNESEESWNWW"
        );

        HooverOutputDTO hooverOutputDTO = hooverService.cleanTheRoom(hooverInputDTO);
        Assertions.assertEquals(new Point(1, 3), hooverOutputDTO.coords());
        Assertions.assertEquals(1, hooverOutputDTO.patches());
    }

    @Test
    public void shouldProperlyCleanTheRoomWithoutVisitingTheSamePlaceAgain() {
        HooverInputDTO hooverInputDTO = new HooverInputDTO(
                new int[]{5,5},
                new int[]{1,2},
                new int[][]{new int[]{1,0}, new int[]{2,2}, new int[]{2,3}},
                "NNESEESWNWW"
        );

        HooverOutputDTO hooverOutputDTO = hooverService.cleanTheRoom(hooverInputDTO);
        Assertions.assertEquals(new Point(1, 3), hooverOutputDTO.coords());
        Assertions.assertEquals(1, hooverOutputDTO.patches());
    }

    @Test
    public void shouldProperlyCleanTheRoomWhichWasAlreadyClean() {
        HooverInputDTO hooverInputDTO = new HooverInputDTO(
                new int[]{5,5},
                new int[]{1,2},
                new int[][]{},
                "NNESEESWNWW"
        );

        HooverOutputDTO hooverOutputDTO = hooverService.cleanTheRoom(hooverInputDTO);
        Assertions.assertEquals(new Point(1, 3), hooverOutputDTO.coords());
        Assertions.assertEquals(0, hooverOutputDTO.patches());
    }

    @Test
    public void shouldProperlyExecuteWithoutInstructions() {
        HooverInputDTO hooverInputDTO = new HooverInputDTO(
                new int[]{5,5},
                new int[]{1,2},
                new int[][]{},
                ""
        );

        HooverOutputDTO hooverOutputDTO = hooverService.cleanTheRoom(hooverInputDTO);
        Assertions.assertEquals(new Point(1, 2), hooverOutputDTO.coords());
        Assertions.assertEquals(0, hooverOutputDTO.patches());
    }

    @Test
    public void shouldFailBecauseCoordsXGreaterThanRoomSizeX() {
        HooverInputDTO hooverInputDTO = new HooverInputDTO(
                new int[]{5,5},
                new int[]{6,2},
                new int[][]{},
                ""
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> hooverService.cleanTheRoom(hooverInputDTO));
    }

    @Test
    public void shouldFailBecauseCoordsYGreaterThanRoomSizeY() {
        HooverInputDTO hooverInputDTO = new HooverInputDTO(
                new int[]{5,5},
                new int[]{1,7},
                new int[][]{},
                ""
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> hooverService.cleanTheRoom(hooverInputDTO));
    }

    @Test
    public void shouldFailBecauseRoomSizeXNegative() {
        HooverInputDTO hooverInputDTO = new HooverInputDTO(
                new int[]{-1,5},
                new int[]{1,4},
                new int[][]{},
                ""
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> hooverService.cleanTheRoom(hooverInputDTO));
    }

    @Test
    public void shouldFailBecauseCoordsYNegative() {
        HooverInputDTO hooverInputDTO = new HooverInputDTO(
                new int[]{5,5},
                new int[]{1,-1},
                new int[][]{},
                ""
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> hooverService.cleanTheRoom(hooverInputDTO));
    }

    @Test
    public void shouldFailBecausePatchXNegative() {
        HooverInputDTO hooverInputDTO = new HooverInputDTO(
                new int[]{5,5},
                new int[]{1,-1},
                new int[][]{new int[]{-1,1}},
                ""
        );

        Assertions.assertThrows(IllegalArgumentException.class, () -> hooverService.cleanTheRoom(hooverInputDTO));
    }

    @Test
    public void shouldProperlyCleanTheRoomWithDrivingIntoTheWall() {
        HooverInputDTO hooverInputDTO = new HooverInputDTO(
                new int[]{5,5},
                new int[]{1,2},
                new int[][]{new int[]{1,0}, new int[]{2,2}, new int[]{2,3}},
                "NNNNNSESEESWNWW"
        );

        HooverOutputDTO hooverOutputDTO = hooverService.cleanTheRoom(hooverInputDTO);
        Assertions.assertEquals(new Point(1, 3), hooverOutputDTO.coords());
        Assertions.assertEquals(1, hooverOutputDTO.patches());
    }
}
