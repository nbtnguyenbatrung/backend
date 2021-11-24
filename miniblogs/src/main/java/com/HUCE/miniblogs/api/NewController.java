package com.HUCE.miniblogs.api;

import com.HUCE.miniblogs.model.ModelNew;
import com.HUCE.miniblogs.model.NewReq;
import com.HUCE.miniblogs.model.News;
import com.HUCE.miniblogs.service.NewService;
import com.HUCE.miniblogs.validator.NewValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class NewController implements NewApi{

    @Autowired
    NewService newService;
    @Autowired
    NewValidator newValidator;

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

}
