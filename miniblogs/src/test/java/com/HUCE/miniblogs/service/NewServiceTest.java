package com.HUCE.miniblogs.service;

import com.HUCE.miniblogs.mapper.NewMapper;
import com.HUCE.miniblogs.mock.NewData;
import com.HUCE.miniblogs.repository.NewRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class NewServiceTest {
    @InjectMocks
    NewService newService;

    @Mock
    NewRepository newRepository;
    @Mock
    NewMapper mapper;

    @Test
    public void addnew(){
        newService.addnew(NewData.mockNewreq());
    }

    @Test
    public void getallnew(){
        newService.getallnew();
    }

    @Test
    public void getnewid(){
        newService.getnewid(NewData.ID);
    }
}