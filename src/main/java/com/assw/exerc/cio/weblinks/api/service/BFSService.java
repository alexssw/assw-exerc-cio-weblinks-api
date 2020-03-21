package com.assw.exerc.cio.weblinks.api.service;

import com.assw.exerc.cio.weblinks.api.controller.dto.LinkApi;
import com.assw.exerc.cio.weblinks.api.model.dto.Node;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class BFSService {

    private static final String _CRITERIA = "a[href]";
    private static final String _URL_ERROR = "Error URL is missing!";

    public static <T> Optional<Node<T>> search(T url, Node<T> start) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);

        Node<T> currentNode;
        Set<Node<T>> alreadyVisited = new HashSet<>();

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            if (currentNode.getUrl().equals(url)) {
                return Optional.of(currentNode);
            } else {
                alreadyVisited.add(currentNode);
                queue.addAll(currentNode.getChildren());
                queue.removeAll(alreadyVisited);
            }
        }
        return Optional.empty();
    }

    public Node getLinks(String url) throws IOException {
        Node<String> parentNode = new Node<>(url);
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select(_CRITERIA);
        links.forEach(link -> {
            Node<String> childNode = new Node<>(link.attr("abs:href"));
            parentNode.connect(childNode);
        });
        return parentNode;
    }
}
