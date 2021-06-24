package com.gdpu.util;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ItemTree {
    private Integer id;

    private Integer pid;

    private String name;

    private List<ItemTree> children;


    public ItemTree() {
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<ItemTree> getChildren() {
        return children;
    }

    public void setChildren(List<ItemTree> children) {
        this.children = children;
    }
}
