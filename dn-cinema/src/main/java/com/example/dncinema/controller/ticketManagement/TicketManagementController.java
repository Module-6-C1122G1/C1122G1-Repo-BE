package com.example.dncinema.controller.ticketManagement;

import com.example.dncinema.dto.CustomerPointDTO;
import com.example.dncinema.dto.ICustomerPoint;
import com.example.dncinema.dto.ITicketManagement;
import com.example.dncinema.model.Ticket;
import com.example.dncinema.repository.ITicketRepositoryDong;
import com.example.dncinema.service.tickketManagement.ITicketManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class TicketManagementController {

    @Autowired
    private ITicketManagementService iTicketManagementService;

    @Autowired
    private ITicketRepositoryDong iTicketRepositoryDong;

    /**
     * @param pageable
     * @return list customer , status OK
     * @author DongPV
     */
    @GetMapping("")
    public ResponseEntity<?> findAllCustomerTicket(@PageableDefault(size = 3) Pageable pageable) {
        Page<ITicketManagement> ticketManagementDTOS = iTicketManagementService.findAllCustomerTicket(pageable);
        if (ticketManagementDTOS.isEmpty()) {
            return new ResponseEntity<>(ticketManagementDTOS, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketManagementDTOS, HttpStatus.OK);
    }

    /**
     * @param pageable
     * @return list customer point history , status OK
     * @author DongPV
     */
    @GetMapping("/history")
    public ResponseEntity<?> findAllCustomerPointHistory(@PageableDefault(size = 3) Pageable pageable) {
        Page<ICustomerPoint> customerPointDTOS = iTicketManagementService.findAllCustomerPoint(pageable);
        if (customerPointDTOS.isEmpty()) {
            return new ResponseEntity<>(customerPointDTOS, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerPointDTOS, HttpStatus.OK);
    }

    /**
     * @param pageable
     * @param dateStart
     * @param dateEnd
     * @return list plus point , status OK
     * @author DongPV
     */
    @GetMapping("/plus-point")
    public ResponseEntity<?> findAllPlusPoint(@PageableDefault(size = 3) Pageable pageable, LocalDate dateStart, LocalDate dateEnd) {
        Page<CustomerPointDTO> customerPointDTOS = iTicketManagementService.searchPlusPoint(pageable, dateStart, dateEnd);
        if (customerPointDTOS.isEmpty()) {
            return new ResponseEntity<>(customerPointDTOS, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerPointDTOS, HttpStatus.OK);
    }

    /**
     * @param pageable
     * @param dateStart
     * @param dateEnd
     * @return list use point , status OK
     * @author DongPV
     */
    @GetMapping("/use-point")
    public ResponseEntity<?> findAllUsePoint(@PageableDefault(size = 3) Pageable pageable, LocalDate dateStart, LocalDate dateEnd) {
        Page<CustomerPointDTO> customerPointDTOS = iTicketManagementService.searchUsePoint(pageable, dateStart, dateEnd);
        if (customerPointDTOS.isEmpty()) {
            return new ResponseEntity<>(customerPointDTOS, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerPointDTOS, HttpStatus.OK);
    }

    /**
     * @param id
     * @return list ticket of customer , status OK
     * @ author DongPV
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Ticket ticketManagement = iTicketRepositoryDong.findById(id).get();
        if (ticketManagement == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(ticketManagement, HttpStatus.OK);
    }

    /**
     * @param id
     * @return list ticket of customer , Status OK
     * @author DongPV
     */
    @DeleteMapping("/delete-ticket/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable Integer id) {
        iTicketManagementService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
