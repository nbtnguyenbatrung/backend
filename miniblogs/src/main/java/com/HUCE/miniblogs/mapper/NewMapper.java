package com.HUCE.miniblogs.mapper;

import com.HUCE.miniblogs.entity.NewEntity;
import com.HUCE.miniblogs.model.ModelNew;
import com.HUCE.miniblogs.model.NewReq;
import com.HUCE.miniblogs.repository.NewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Component
public class NewMapper {

    @Autowired
    NewRepository newRepository;

    public NewEntity toEntityFromNew(NewReq req){
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH)+1;
        int year = cal.get(Calendar.YEAR);
        NewEntity newEntity = new NewEntity();
        newEntity.setId(UUID.randomUUID().toString());
        newEntity.setTitle(req.getTitle());
        newEntity.setContent(req.getContent());
        newEntity.setSummary(req.getSummary());
        newEntity.setImage(req.getImage());
        newEntity.setCreatedate(month + " " + day + ", " +year);
        newEntity.setCetogory(req.getCetogory());
        return newEntity;
    }

    public ModelNew tnoNewFromEntity(NewEntity newEntity){
        ModelNew modelNew = new ModelNew();
        modelNew.setId(newEntity.getId());
        modelNew.setTitle(newEntity.getTitle());
        modelNew.setContent(newEntity.getContent());
        modelNew.setSummary(newEntity.getSummary());
        modelNew.setImage(newEntity.getImage());
        modelNew.setCreatedate(newEntity.getCreatedate());
        modelNew.setCetogory(newEntity.getCetogory());
        return modelNew;
    }

}
