package com.assw.exerc.cio.weblinks.api.service;

import com.assw.exerc.cio.weblinks.api.controller.dto.LinkApi;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.HashSet;

@Service
public class LinkService {

    private static final String _CRITERIA = "a[href]";
    private static final String _URL_ERROR = "Error URL is missing!";
    private final HashSet<String> links = new HashSet<>();
    private final LinkApi linkApi = new LinkApi();

    public LinkApi getLinks(@NotNull final String url) throws Exception {
        if (StringUtils.isEmpty(url))
            throw new Exception(_URL_ERROR);
        linkApi.setUrl(url);
        getLinks(url);
        return linkApi;
    }

    private void getDeepLinks(String url) throws IOException {
        if (!links.contains(url))
            links.add(url);
        Document doc = Jsoup.connect(url).get();
        Elements pagesLinks = doc.select(_CRITERIA);
        pagesLinks.forEach(link -> {
            try {
                linkApi.getLinks().add(new LinkApi(url, null));
                getDeepLinks(link.attr("abs:href"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
