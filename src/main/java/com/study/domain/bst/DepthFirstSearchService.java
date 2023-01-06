package com.study.domain.bst;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearchService {

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);

            for (var child : children) {
                child.depthFirstSearch(array);
            }

            return array;
        }

        public Node addChild(String name) {
            var child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
