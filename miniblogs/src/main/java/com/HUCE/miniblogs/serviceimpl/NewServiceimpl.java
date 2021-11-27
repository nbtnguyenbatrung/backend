package com.HUCE.miniblogs.serviceimpl;

import com.HUCE.miniblogs.model.ModelNew;
import com.HUCE.miniblogs.model.NewReq;
import com.HUCE.miniblogs.model.News;

public interface NewServiceimpl {

    ModelNew addnew(NewReq req);
    News getallnew();
    ModelNew getnewid(String id);
    News search(String title);
}
