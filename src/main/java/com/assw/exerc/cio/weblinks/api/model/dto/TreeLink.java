package com.assw.exerc.cio.weblinks.api.model.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TreeLink<T> {

    private T value;
    private List<TreeLink<T>> children;

    private TreeLink(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public static <T> TreeLink<T> of(T value) {
        return new TreeLink<>(value);
    }

    public TreeLink<T> addChild(T value) {
        TreeLink<T> child = new TreeLink<>(value);
        children.add(child);
        return child;
    }

    public T getValue() {
        return value;
    }

    public List<TreeLink<T>> getChildren() {
        return Collections.unmodifiableList(children);
    }
}
