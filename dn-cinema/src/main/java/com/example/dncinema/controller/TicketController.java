package com.example.dncinema.controller;

import com.example.dncinema.dto.TicketDetailDTO;
import com.example.dncinema.model.Ticket;
import com.example.dncinema.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/ticket")
@CrossOrigin("*")
public class TicketController {
    @Autowired
    ITicketService iTicketService;

    /**
     * @return new ResponseEntity
     * @Author QuynhHTN
     * Date create: 24/05/2023
     * @Usage_method use method findAll ticket
     */
    @GetMapping("")
    public ResponseEntity<?> findAll() {
        List<TicketDetailDTO> ticketDetailDTOS = iTicketService.findAll();
        return new ResponseEntity<>(ticketDetailDTOS, HttpStatus.OK);
    }

    /**
     * @Author QuynhHTN
     * Date create: 24/05/2023
     * @Param id
     * @Return new ResponseEntity<>
     * @Usage_method findById to show detail ticket
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> findTicketById(@PathVariable Integer id) {

        Ticket ticket = iTicketService.findTicketById(id);
        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }


    // array id seat mong muon tra lai ve | array id ticket | customer_id

    /**
     * @Author QuynhHTN
     * Date create: 24/05/2023
     * @Param ticketDetailDTO
     * @Param bindingResult
     * @Param id
     * @Return new ResponseEntity
     * @Usage_method use method update ticket when customers change ticket
     */
    @PatchMapping("update/{id}")
    public ResponseEntity<?> updateTicket(@Validated @RequestBody TicketDetailDTO ticketDetailDTO, BindingResult bindingResult, @PathVariable Integer id) {
        if (!bindingResult.hasErrors()) {
            ticketDetailDTO.setIdTicket(id);
            iTicketService.update(ticketDetailDTO);
        } else {
            Map<String, String> map = new LinkedHashMap<>();
            List<FieldError> err = bindingResult.getFieldErrors();
            for (FieldError error : err) {
                if (!map.containsKey(error.getField())) {
                    map.put(error.getField(), error.getDefaultMessage());
                }
            }
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
