package com.theanh.department.service;

import com.theanh.department.entity.EmployeeEntity;
import com.theanh.department.mapper.EmployeesMapper;
import com.theanh.department.model.EmployeeList;
import com.theanh.department.model.EmployeeReq;
import com.theanh.department.model.EmployeeRes;
import com.theanh.department.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeesMapper mapper;
    private final EmployeeRepository repo;

    @Autowired
    public EmployeeService(EmployeesMapper mapper, EmployeeRepository repo) {
        this.mapper = mapper;
        this.repo = repo;
    }

    public EmployeeRes addEmployee(EmployeeReq employeeReq){
        EmployeeEntity entity = mapper.mapEmployeeEntityFromEmployeeReq(employeeReq);
        EmployeeEntity saved = repo.save(entity);
        return mapper.mapEmployeeResFromEmployeeEntity(saved);
    }

    public EmployeeRes updateEmployee(Long id, EmployeeReq employeeReq){
        EmployeeEntity entity = mapper.mapEmployeeEntityFromEmployeeReq(id, employeeReq);
        EmployeeEntity saved = repo.save(entity);
        return mapper.mapEmployeeResFromEmployeeEntity(saved);
    }

    public EmployeeList getAllEmployee(){
        EmployeeList el = mapper.mapEmployeeListFromEmployeeEntity(repo.findAll());
        return el;
    }

    public void removeEmployee(Long employeeId){
        EmployeeEntity entity =repo.getOne(employeeId);
        repo.delete(entity);
    }
}
