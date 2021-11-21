package com.huce.manege.api;

import com.huce.manege.mock.DepartmentData;
import com.huce.manege.model.Department;
import com.huce.manege.model.DepartmentReq;
import com.huce.manege.service.DepartmentService;
import com.huce.manege.validator.DepartmentValidator;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
class DerpartmentControllerTest {

    @InjectMocks
    DerpartmentController controller;

    @Mock
    DepartmentService service;

    @Mock
    DepartmentValidator validator;


    @Test
    void addDepartment() {
        when(service.createDepartment(any(DepartmentReq.class)))
                .thenReturn(DepartmentData.mockDepartment());
        ResponseEntity<Department> responseEntity =
                controller.addDepartment(DepartmentData.mockDepartmentReq());

        assertStatus200(responseEntity.getStatusCode());
        assertDepartment(responseEntity.getBody());
    }

    @Test
    void editDepartment() {
    }

    @Test
    void hello() {

    }

    @Test
    void delete() {
    }

    @Test
    void getDepartmentID() {
    }

    @Test
    void getdepartment() {
    }

    private void assertDepartment(Department actual) {
        assertThat(actual.getId(), is(DepartmentData.PROPERTY_ID));
        assertThat(actual.getName(), is(DepartmentData.NAME));
        assertThat(actual.getAddress(), is(DepartmentData.ADDRESS));
        assertThat(actual.getPhone(), is(DepartmentData.PHONE));
        assertThat(actual.getStatus().name(), is(Department.StatusEnum.PENDING.name()));
    }

    private void assertStatus200(HttpStatus actual) {
        assertThat(actual, is(HttpStatus.OK));
    }
}