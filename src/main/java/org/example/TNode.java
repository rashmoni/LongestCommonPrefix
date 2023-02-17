package org.example;
import java.util.*;


    class TNode {
        Map<Character, TNode> children;
        boolean isEndOfWord;

        TNode() {
            this.children = new HashMap<>();
            this.isEndOfWord = false;
        }
    }

