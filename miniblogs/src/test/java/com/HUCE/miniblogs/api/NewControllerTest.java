package com.HUCE.miniblogs.api;

import com.HUCE.miniblogs.mock.NewData;
import com.HUCE.miniblogs.model.ModelNew;
import com.HUCE.miniblogs.model.NewReq;
import com.HUCE.miniblogs.model.News;
import com.HUCE.miniblogs.service.ContactService;
import com.HUCE.miniblogs.service.NewService;
import com.HUCE.miniblogs.validator.ContactValidator;
import com.HUCE.miniblogs.validator.NewValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class NewControllerTest {

    private final String API_KEY = "MOCK_API_KEY";

    @InjectMocks
    NewController newController;

    @Mock
    NewService service;

    @Mock
    NewValidator validator;

    @Test
    public void addnew(){
        when(service.addnew(any(NewReq.class)))
                .thenReturn(NewData.mockNew());

        ResponseEntity<ModelNew> responseEntity =
                newController.addnew(API_KEY, NewData.mockNewreq());

        assertStatus200(responseEntity.getStatusCode());
        assertProperty(responseEntity.getBody());
    }

    @Test
    public void getnewID(){
        when(service.getnewid(anyString()))
                .thenReturn(NewData.mockNew());

        ResponseEntity<ModelNew> responseEntity =
                newController.getnewID(API_KEY, NewData.ID);

        assertStatus200(responseEntity.getStatusCode());
        assertProperty(responseEntity.getBody());
    }

    @Test
    public void getallnew(){
        when(service.getallnew())
                .thenReturn(NewData.mockNews());

        ResponseEntity<News> responseEntity =
                newController.getallnew(API_KEY);

        assertStatus200(responseEntity.getStatusCode());
        assertProperties(responseEntity.getBody());
    }

    private void assertProperty(ModelNew actual) {
        assertThat(actual.getId(), is(NewData.ID));
        assertThat(actual.getTitle(), is(NewData.TITLE));
        assertThat(actual.getContent(), is(NewData.CONTENT));
        assertThat(actual.getSummary(), is(NewData.SUMMARY));
        assertThat(actual.getImage(), is(NewData.IMAGE));
        assertThat(actual.getCreatedate(), is(NewData.CREATEDATE));
        assertThat(actual.getCetogory(), is(NewData.CETOGORY));
    }

    private void assertProperties(News actual) {
        for(int i = 0 ; i < actual.size() ; i++){
            assertProperty(actual.get(i));
        }
    }

    private void assertStatus200(HttpStatus actual) {
        assertThat(actual, is(HttpStatus.OK));
    }


}