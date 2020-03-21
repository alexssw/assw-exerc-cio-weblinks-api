package com.assw.exerc.cio.weblinks.api.model.dto;

import lombok.Data;

import java.util.*;

public class Node<T> {

    private T url;
    private Set<Node<T>> children;

    public Node(T url) {
        this.url = url;
        this.children = new HashSet<>();
    }

    public T getUrl(){
        return url;
    }

    public Set<Node<T>> getChildren() {
        return Collections.unmodifiableSet(children);
    }

    public void connect(Node<T> node) {
        if (this == node)
            throw new IllegalArgumentException("Error connect node  to itself");
        this.children.add(node);
        node.children.add(this);
    }
}
