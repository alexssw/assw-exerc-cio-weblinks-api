package com.assw.exerc.cio.weblinks.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkApi {

    private String url;
    private List<LinkApi> links = new ArrayList<>();

}
