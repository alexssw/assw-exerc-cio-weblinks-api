package com.assw.exerc.cio.weblinks.api.controller;

import com.assw.exerc.cio.weblinks.api.controller.dto.WeblinksApi;
import com.assw.exerc.cio.weblinks.api.service.WeblinksService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "'Weblinks CIO Exerc", tags = {"Weblinks CIO"})
public class WeblinksController {

    @Autowired
    WeblinksService weblinksService;

    @ApiOperation(value = "Web links by url")
    @RequestMapping(value = "/weblinks", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public WeblinksApi getJsonWebLinks(
            @ApiParam(name = "url", example = "www.google.com", required = true, value = "Enter with web link")
            @RequestParam(name = "weblink") String url) {
        return weblinksService.getWeblinks();
    }
}
