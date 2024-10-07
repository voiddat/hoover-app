package org.hoover;

import org.hoover.dto.HooverInputDTO;
import org.hoover.dto.HooverOutputDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HooverController {
    private final HooverService hooverService;

    public HooverController(HooverService hooverService) {
        this.hooverService = hooverService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<HooverOutputDTO> cleanTheRoom(@RequestBody HooverInputDTO hooverInputDTO) {
        try {
            return ResponseEntity.ok(this.hooverService.cleanTheRoom(hooverInputDTO));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
