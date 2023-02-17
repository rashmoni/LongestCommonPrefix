package org.example;

import java.util.List;

class PrefixFinder {
        private final TNode root;

        PrefixFinder(List<String> prefixes) {
            this.root = new TNode();
            for (String prefix : prefixes) {
                insert(prefix);
            }
        }

        private void insert(String prefix) {
            TNode node = root;
            for (char c : prefix.toCharArray()) {
                node.children.putIfAbsent(c, new TNode());
                node = node.children.get(c);
            }
            node.isEndOfWord = true;
        }

        public String findLongestMatchingPrefix(String input) {
            TNode node = root;
            StringBuilder sb = new StringBuilder();
            for (char c : input.toCharArray()) {
                if (node.children.containsKey(c)) {
                    sb.append(c);
                    node = node.children.get(c);
                    if (node.isEndOfWord) {
                        continue;
                    }
                } else {
                    break;
                }
            }
            return sb.toString();
        }
    }
