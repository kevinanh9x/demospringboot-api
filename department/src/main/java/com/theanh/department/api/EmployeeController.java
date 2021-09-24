package com.theanh.department.api;

import com.theanh.department.model.EmployeeList;
import com.theanh.department.model.EmployeeReq;
import com.theanh.department.model.EmployeeRes;
import com.theanh.department.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/training/backend/v1")
public class EmployeeController {
    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @RequestMapping(value = "/employees",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public ResponseEntity<EmployeeList> getAllEmployee(){
        EmployeeList response = service.getAllEmployee();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/{id}", produces = { "application/json" }, method = RequestMethod.DELETE)
    public ResponseEntity<EmployeeRes> delEmployee(@PathVariable("id") Long id ){
        service.removeEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/employees/{id}", produces = { "application/json" }, method = RequestMethod.PATCH)
    public ResponseEntity<EmployeeRes> pathEmployee(@PathVariable("id") Long id, @RequestBody EmployeeReq employeeReq){
        service.updateEmployee(id, employeeReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
