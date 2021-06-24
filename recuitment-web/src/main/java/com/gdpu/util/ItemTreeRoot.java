package com.gdpu.util;

import java.util.List;

public class ItemTreeRoot {
    private Integer id;
    private String name;
    private List<ItemTreeRoot> children;

    public ItemTreeRoot() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemTreeRoot> getChildren() {
        return children;
    }

    public void setChildren(List<ItemTreeRoot> children) {
        this.children = children;
    }
}
