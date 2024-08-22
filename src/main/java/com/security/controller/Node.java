package com.security.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @title： x
 * @Description： TODO
 * @Author： liang.he
 * @CreateTime： 2024/6/3 11:48
 * @Version： 1.0.0
 * @department： 房联电⼦科技有限公司
 */
public class Node {
    public String name;
    public List<Node> children;
    public Node parent;

    public Node(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addChild(Node child) {
        child.parent = this;
        this.children.add(child);
    }

    @Override
    public String toString() {
        return name;
    }
}
