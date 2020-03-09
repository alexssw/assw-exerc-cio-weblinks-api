package com.assw.exerc.cio.weblinks.api.service;

import com.assw.exerc.cio.weblinks.api.controller.dto.WeblinksApi;
import org.springframework.stereotype.Service;

@Service
public class WeblinksService {

    public WeblinksApi getWeblinks() {
        return new WeblinksApi();
    }
}
