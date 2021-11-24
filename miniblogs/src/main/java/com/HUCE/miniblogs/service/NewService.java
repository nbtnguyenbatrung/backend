package com.HUCE.miniblogs.service;

import com.HUCE.miniblogs.entity.NewEntity;
import com.HUCE.miniblogs.mapper.NewMapper;
import com.HUCE.miniblogs.model.ModelNew;
import com.HUCE.miniblogs.model.NewReq;
import com.HUCE.miniblogs.model.News;
import com.HUCE.miniblogs.repository.NewRepository;
import com.HUCE.miniblogs.serviceimpl.NewServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewService implements NewServiceimpl {

    @Autowired
    NewRepository newRepository;
    @Autowired
    NewMapper mapper;

    @Override
    public ModelNew addnew(NewReq req) {
        NewEntity newEntity = mapper.toEntityFromNew(req);
        newEntity = newRepository.save(newEntity);
        ModelNew modelNew = mapper.tnoNewFromEntity(newEntity);
        return modelNew;
    }

    @Override
    public News getallnew() {
        List<NewEntity> newEntityList = newRepository.findAll();
        News news = new News();
        for(NewEntity newEntity : newEntityList){
            ModelNew modelNew = mapper.tnoNewFromEntity(newEntity);
            news.add(modelNew);
        }
        return news;
    }

    @Override
    public ModelNew getnewid(String id) {
        NewEntity newEntity = newRepository.getById(id);
        ModelNew modelNew = mapper.tnoNewFromEntity(newEntity);
        return modelNew;
    }
}
