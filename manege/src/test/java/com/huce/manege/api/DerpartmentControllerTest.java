package com.huce.manege.api;

import com.huce.manege.mock.DepartmentData;
import com.huce.manege.model.Department;
import com.huce.manege.model.DepartmentReq;
import com.huce.manege.model.Departments;
import com.huce.manege.service.DepartmentService;
import com.huce.manege.validator.DepartmentValidator;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class DerpartmentControllerTest extends TestCase {

    private final String API_KEY = "MOCK_API_KEY";

    @InjectMocks
    DerpartmentController controller;

    @Mock
    DepartmentService service;

    @Mock
    DepartmentValidator validator;

    @Test
    public void addDepartment() {
        when(service.createDepartment(any(DepartmentReq.class)))
                .thenReturn(DepartmentData.mockDepartment());
        ResponseEntity<Department> responseEntity =
                controller.addDepartment(API_KEY,DepartmentData.mockDepartmentReq());

        assertStatus200(responseEntity.getStatusCode());
        assertDepartment(responseEntity.getBody());
    }

    @Test
    public void editDepartment() {
        when(service.updateDepartment(anyString(),any(DepartmentReq.class)))
                .thenReturn(DepartmentData.mockDepartment());
        ResponseEntity<Department> responseEntity =
                controller.editDepartment(API_KEY,DepartmentData.PROPERTY_ID,DepartmentData.mockDepartmentReq());
        assertStatus200(responseEntity.getStatusCode());
        assertDepartment(responseEntity.getBody());
    }


    @Test
    public void getDepartmentID() {
        when(service.getDepartmentID(anyString()))
                .thenReturn(DepartmentData.mockDepartment());
        ResponseEntity<Department> responseEntity =
                controller.getDepartmentID(API_KEY,DepartmentData.PROPERTY_ID);
        assertStatus200(responseEntity.getStatusCode());
        assertDepartment(responseEntity.getBody());
    }

    @Test
    public void getdepartment() {
        when(service.getAllDepartment())
                .thenReturn(DepartmentData.mockDepartments());
        ResponseEntity<Departments> responseEntity =
                controller.getdepartment(API_KEY);
        assertStatus200(responseEntity.getStatusCode());
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