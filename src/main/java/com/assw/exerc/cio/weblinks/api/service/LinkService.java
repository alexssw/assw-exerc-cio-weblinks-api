package com.assw.exerc.cio.weblinks.api.service;

import com.assw.exerc.cio.weblinks.api.controller.dto.LinkApi;
import com.assw.exerc.cio.weblinks.api.model.dto.TreeLink;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.*;

@Service
public class LinkService {

    private static final String _CRITERIA = "a[href]";
    private static final String _URL_ERROR = "Error URL is missing!";
    private final List<LinkApi> lk = new ArrayList<>();

    public static <T> Optional<TreeLink<T>> search(T value, TreeLink<T> root) {

        Queue<TreeLink<T>> queue = new ArrayDeque<>();
        queue.add(root);

        TreeLink<T> currentNode;
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            if (currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            } else {
                queue.addAll(currentNode.getChildren());
            }
        }
        return Optional.empty();
    }

    public LinkApi getLinks(@NotNull final String url) throws Exception {
        if (StringUtils.isEmpty(url))
            throw new Exception(_URL_ERROR);
        lk.add(getDeepLinks(url));
        lk.forEach(item -> {
            item.getLinks().forEach(i -> {
                try {
                    if (item.getUrl() != null || item.getUrl().length() > 0) {
                        i.getLinks().add(getDeepLinks(item.getUrl()));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        });
        return lk.get(0);
    }

    private LinkApi getDeepLinks(@NotNull final String url) throws IOException {
        LinkApi linkApi = new LinkApi(url, new ArrayList<>());
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select(_CRITERIA);
        links.forEach(link -> {
            linkApi.getLinks().add(new LinkApi(link.attr("abs:href"), new ArrayList<>()));
        });
        return linkApi;
    }
}
