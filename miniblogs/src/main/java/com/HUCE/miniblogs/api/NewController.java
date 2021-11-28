package com.HUCE.miniblogs.api;


import com.HUCE.miniblogs.mapper.NewMapper;
import com.HUCE.miniblogs.model.ModelNew;
import com.HUCE.miniblogs.model.NewReq;
import com.HUCE.miniblogs.model.News;
import com.HUCE.miniblogs.search.HibernateSearchUtil;
import com.HUCE.miniblogs.service.NewService;
import com.HUCE.miniblogs.validator.NewSearchValidator;
import com.HUCE.miniblogs.validator.NewValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class NewController implements NewApi,NewsApi {

    @Autowired
    NewService newService;
    @Autowired
    NewValidator newValidator;
    @Autowired
    NewSearchValidator newSearchValidator;

    @Override
    public ResponseEntity<ModelNew> addnew(String apikey, NewReq request) {
        newValidator.validateAddNew(request);
        ModelNew modelNew = newService.addnew(request);
        return new ResponseEntity<>(modelNew, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<News> getallnew(String apikey) {
        News news = newService.getallnew();
        return new ResponseEntity<>(news,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ModelNew> getnewID( String apikey, String id) {
        newValidator.validateNewExist(id);
        ModelNew modelNew = newService.getnewid(id);
        return new ResponseEntity<>(modelNew,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<News> search(String apikey, String searchNew) {

        searchNew = HibernateSearchUtil.decodeUrl(searchNew);
//        newSearchValidator.validateTermSearch(searchNew);
        News news = newService.search(searchNew);
        return new ResponseEntity<>(news,HttpStatus.OK);
//        return null;
    }


}
