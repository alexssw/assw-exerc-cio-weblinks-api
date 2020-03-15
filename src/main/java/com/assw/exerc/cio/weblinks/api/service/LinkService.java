package com.assw.exerc.cio.weblinks.api.service;

import com.assw.exerc.cio.weblinks.api.controller.dto.LinkApi;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LinkService {

    private static final String _CRITERIA = "a[href]";
    private static final String _URL_ERROR = "Error URL is missing!";
    private final List<LinkApi> lk = new ArrayList<>();

    public LinkApi getLinks(@NotNull final String url) throws Exception {
        if (StringUtils.isEmpty(url))
            throw new Exception(_URL_ERROR);
        getDeepLinks(url);
        return lk.get(0);
    }

    private void getDeepLinks(@NotNull final String url) throws IOException {
        LinkApi linkApi = new LinkApi(url, new ArrayList<>());
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select(_CRITERIA);
        links.forEach(link -> {
            linkApi.getLinks().add(new LinkApi(link.attr("abs:href"), new ArrayList<>()));
        });
        lk.add(linkApi);
    }
}
