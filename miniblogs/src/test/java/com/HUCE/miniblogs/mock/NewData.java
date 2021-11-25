package com.HUCE.miniblogs.mock;

import com.HUCE.miniblogs.entity.NewEntity;
import com.HUCE.miniblogs.model.ModelNew;
import com.HUCE.miniblogs.model.NewReq;
import com.HUCE.miniblogs.model.News;

public class NewData {
    public static final String ID = "c73095df-a31d-45a0-8d57-8c43108830c7";
    public static final String TITLE = "Old Farm";
    public static final String SUMMARY = "trải nghiệm đi chơi";
    public static final String CONTENT = "Beautyful Old Farm";
    public static final String IMAGE = "anh.jpg";
    public static final String CREATEDATE = "5 25, 2020";
    public static final String CETOGORY = "ART";

    public static ModelNew mockNew() {
        ModelNew modelNew = new ModelNew();

        modelNew.setId(ID);
        modelNew.setTitle(TITLE);
        modelNew.setSummary(SUMMARY);
        modelNew.setContent(CONTENT);
        modelNew.setImage(IMAGE);
        modelNew.setCreatedate(CREATEDATE);
        modelNew.setCetogory(CETOGORY);

        return modelNew;
    }

    public static NewReq mockNewreq() {
        NewReq newReq = new NewReq();
        newReq.setTitle(TITLE);
        newReq.setSummary(SUMMARY);
        newReq.setContent(CONTENT);
        newReq.setImage(IMAGE);
        newReq.setCetogory(CETOGORY);
        return newReq;
    }
    public static NewEntity mockNewEntity(){

        NewEntity newEntity = new NewEntity();
        newEntity.setId(ID);
        newEntity.setTitle(TITLE);
        newEntity.setContent(CONTENT);
        newEntity.setSummary(SUMMARY);
        newEntity.setImage(IMAGE);
        newEntity.setCreatedate(CREATEDATE);
        newEntity.setCetogory(CETOGORY);
        return newEntity;
    }

    public static News mockNews(){
        News news = new News();

        news.add(mockNew());
        return news;
    }


}
