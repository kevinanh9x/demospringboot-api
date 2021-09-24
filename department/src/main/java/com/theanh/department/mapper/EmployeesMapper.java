package com.theanh.department.mapper;

import com.theanh.department.entity.EmployeeEntity;
import com.theanh.department.model.EmployeeList;
import com.theanh.department.model.EmployeeReq;
import com.theanh.department.model.EmployeeRes;
import com.theanh.department.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeesMapper {
    private final EmployeeRepository repo;

    @Autowired
    public EmployeesMapper(EmployeeRepository repo) {
        this.repo = repo;
    }

    public EmployeeRes mapEmployeeResFromEmployeeEntity(EmployeeEntity from){
        EmployeeRes res =new EmployeeRes();
        res.setId(from.getId());
        res.setFullName(from.getFullName());
        res.setAge(from.getAge());
        res.setAddress(from.getAddress());
        res.setEmail(from.getEmail());
        res.setSalary(from.getSalary());
        return res;
    }

    public EmployeeList mapEmployeeListFromEmployeeEntity(List<EmployeeEntity> from){
        EmployeeList employeeList =new EmployeeList();
        from.stream().forEach(employeeEntity -> {
            employeeList.add(mapEmployeeResFromEmployeeEntity(employeeEntity));
        });
        return  employeeList;
    }

    public EmployeeEntity mapEmployeeEntityFromEmployeeReq(EmployeeReq from){
        EmployeeEntity employeeEntity =new EmployeeEntity();
        employeeEntity.setId(Integer.parseInt(UUID.randomUUID().toString()));
        employeeEntity.setFullName(from.getFullName());
        employeeEntity.setAge(from.getAge());
        employeeEntity.setAddress(from.getAddress());
        employeeEntity.setEmail(from.getEmail());
        employeeEntity.setSalary(from.getSalary());
        return employeeEntity;
    }

    public EmployeeEntity mapEmployeeEntityFromEmployeeReq(Long id, EmployeeReq from){
        EmployeeEntity employeeEntity =repo.getOne(Math.toIntExact(id));
        employeeEntity.setFullName(from.getFullName());
        return employeeEntity;
    }

}
