package com.HUCE.miniblogs.mapper;

import com.HUCE.miniblogs.entity.NewEntity;
import com.HUCE.miniblogs.mock.NewData;
import com.HUCE.miniblogs.model.ModelNew;
import com.HUCE.miniblogs.model.NewReq;
import com.HUCE.miniblogs.repository.NewRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class NewMapperTest {
    @InjectMocks
    NewMapper mapper;

    @Mock
    NewRepository newRepository;

    @Test
    public void toEntityFromNew(){
        NewReq newReq = NewData.mockNewreq();

        NewEntity newEntity = mapper.toEntityFromNew(newReq);

        assertThat(newEntity.getId() != null, is(true));
        assertThat(newEntity.getTitle(), is(newReq.getTitle()));
        assertThat(newEntity.getContent(), is(newReq.getContent()));
        assertThat(newEntity.getSummary(), is(newReq.getSummary()));
        assertThat(newEntity.getImage(), is(newReq.getImage()));
        assertThat(newEntity.getCreatedate() != null , is(true));
        assertThat(newEntity.getCetogory(), is(newReq.getCetogory()));
    }

    @Test
    public void tnoNewFromEntity(){
        NewEntity newEntity = NewData.mockNewEntity();

        ModelNew modelNew = new ModelNew();

        modelNew = mapper.tnoNewFromEntity(newEntity);

        assertThat(modelNew.getId(), is(newEntity.getId()));
        assertThat(modelNew.getTitle(), is(newEntity.getTitle()));
        assertThat(modelNew.getContent(), is(newEntity.getContent()));
        assertThat(modelNew.getSummary(), is(newEntity.getSummary()));
        assertThat(modelNew.getImage(), is(newEntity.getImage()));
        assertThat(modelNew.getCreatedate(), is(newEntity.getCreatedate()));
        assertThat(modelNew.getCetogory(), is(newEntity.getCetogory()));
    }


}