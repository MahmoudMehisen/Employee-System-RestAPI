package com.mehisen.employee.services;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.mehisen.employee.entity.EmployeeEntity;
import com.mehisen.employee.model.Employee;
import com.mehisen.employee.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp  implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        BeanUtils.copyProperties(employee,employeeEntity);

        employeeRepository.save(employeeEntity);
        return employee;
    }
}
