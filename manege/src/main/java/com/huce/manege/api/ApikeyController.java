package com.huce.manege.api;

import com.huce.manege.service.ApikeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApikeyController {

    @Autowired
    ApikeyService apikeyService;


}
