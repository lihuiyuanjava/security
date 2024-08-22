package com.security.service.userdetails;

import com.security.controller.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @title： NodeService
 * @Description： TODO
 * @Author： liang.he
 * @CreateTime： 2024/8/16 10:49
 * @Version： 1.0.0
 * @department： 房联电⼦科技有限公司
 */
public class NodeService {

    // 递归查找模糊匹配的节点
    public List<Node> findNodes(Node node, String searchTerm) {
        List<Node> result = new ArrayList<>();
        if (node.name.contains(searchTerm)) {
            result.add(node);
        }
        for (Node child : node.children) {
            result.addAll(findNodes(child, searchTerm));
        }
        return result;
    }

    // 打印节点的完整上下级结构
    public void printHierarchy(Node node, int level) {
        String indent = " ".repeat(level * 2);
        System.out.println(indent + "Node: " + node);
        if (node.parent != null) {
            System.out.println(indent + "Parent: " + node.parent);
        }
        if (!node.children.isEmpty()) {
            System.out.println(indent + "Children: " + node.children.stream().map(Node::toString).collect(Collectors.joining(", ")));
        }
        for (Node child : node.children) {
            printHierarchy(child, level + 1);
        }
    }

    // 打印包含模糊匹配的节点及其上下级
    public void printMatchingHierarchies(List<Node> matchingNodes) {
        for (Node node : matchingNodes) {
            System.out.println("Matching Node: " + node);
            printHierarchy(node, 0);
            System.out.println();
        }
    }


    public static void main(String[] args) {
        // 创建节点
        Node root = new Node("父节点");
        Node child1 = new Node("子节点1");
        Node child2 = new Node("子节点2");
        Node subChild1 = new Node("下级子节点11561565615615");
        Node subChild2 = new Node("下级子节点211111");
        Node subChild3 = new Node("子节点3");

        // 构建树形结构
        child1.addChild(subChild1);
        child2.addChild(subChild2);
        child2.addChild(subChild3);
        root.addChild(child1);
        root.addChild(child2);

        // 创建服务实例
        NodeService nodeService = new NodeService();

        // 模糊搜索节点
        String searchTerm = "子节";
        List<Node> matchingNodes = nodeService.findNodes(root, searchTerm);

        // 打印匹配节点及其上下级
        nodeService.printMatchingHierarchies(matchingNodes);
    }
}
