package com.example.dncinema.controller.show_room;

import com.example.dncinema.dto.ShowRoomDTO;
import com.example.dncinema.service.show_room.IShowRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/showroom")
@CrossOrigin("*")
public class ShowRoomController {

    @Autowired
    private IShowRoomService iShowRoomService;

    @GetMapping("")
    public Page<ShowRoomDTO> list(@PageableDefault(size = 3) Pageable pageable, @RequestParam(required = false, defaultValue = "") String name) {
        return iShowRoomService.findShowRoomByName(pageable, name);
    }

    @PostMapping("")
    public ResponseEntity<?> saveShowRoom(@Validated @RequestBody ShowRoomDTO showRoomDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            iShowRoomService.addShowRoom(showRoomDTO);
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteShowRoom(@PathVariable Integer id) {
        iShowRoomService.deleteShowRoom(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShowRoomDTO getShowRoom(@PathVariable Integer id) {
        return iShowRoomService.findShowRoomById(id);
    }

    @PutMapping("")
    public ResponseEntity<?> updateShowRoom(@Validated @RequestBody ShowRoomDTO showRoomDTO, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            iShowRoomService.updateShowRoom(showRoomDTO);
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

