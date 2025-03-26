package com.mycompany.simplifypath71;

import java.util.Stack;

/**
 * You are given an absolute path for a Unix-style file system, which always begins with a slash '/'.
 * Your task is to transform this absolute path into its simplified canonical path.
 *
 * 4ms Beats 86.13%, 43.59MB Beats 47.90%
 */
public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.isEmpty()) return path;
        if(!path.startsWith("/")) return null;

        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i=0; i<paths.length; i++) {
            if (paths[i].isEmpty()) continue;
            if ("..".equals(paths[i])) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!".".equals(paths[i])) {
                stack.push(paths[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) return "/";
        while(!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }
}
