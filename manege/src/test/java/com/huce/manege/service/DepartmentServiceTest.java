package com.huce.manege.service;

import com.huce.manege.mapper.DerpartmentMapper;
import com.huce.manege.mock.DepartmentData;
import com.huce.manege.repository.DerpartmentJPA;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceTest  {
    @InjectMocks
    DepartmentService service;

    @Mock
    DerpartmentJPA repository;

    @Mock
    DerpartmentMapper mapper;

    @Test
    public void createDepartment(){
        service.createDepartment(DepartmentData.mockDepartmentReq());
    }

    @Test
    public void updateDepartment(){
        service.updateDepartment(DepartmentData.PROPERTY_ID,DepartmentData.mockDepartmentReq());
    }


    @Test
    public void getAllDepartment(){
        service.getAllDepartment();
    }

    @Test
    public void getDepartmentID(){
        service.getDepartmentID(DepartmentData.PROPERTY_ID);
    }
}