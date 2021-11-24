package com.HUCE.miniblogs.api;

import com.HUCE.miniblogs.model.ModelNew;
import com.HUCE.miniblogs.model.NewReq;
import com.HUCE.miniblogs.model.News;
import org.springframework.http.ResponseEntity;

public class NewController implements NewApi{

    @Override
    public ResponseEntity<ModelNew> addnew(String apikey, NewReq request) {
        return null;
    }

    @Override
    public ResponseEntity<News> getallnew(String apikey) {
        return null;
    }

    @Override
    public ResponseEntity<ModelNew> getnewID(String apikey, String id) {
        return null;
    }
}
