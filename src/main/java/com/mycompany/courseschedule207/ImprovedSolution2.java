package com.mycompany.courseschedule207;

import java.util.*;

/**
 * 207. Course Schedule
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses -
 * 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take
 * course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * https://yuminlee2.medium.com/detect-cycle-in-a-graph-4461b6000845
 * 7ms Beats 51.21%, 44.83MB Beats 93.85%
 * 6ms Beats 76.19%, 44.88MB Beats 93.85%
 */
public class ImprovedSolution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length < 1) return true;

        // Init graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<prerequisites.length; i++) {
            int key = prerequisites[i][0];
            List<Integer> val = graph.get(key);
            if (val == null) {
                val = new ArrayList<>();
                graph.put(key, val);
            }
            val.add(prerequisites[i][1]);
        }

        int[] visited = new int[numCourses];
        Stack<Integer> dfsNodeStack = new Stack<>();
        for(int i=0; i<numCourses; i++) {
            if (visited[i] == 2) continue;
            else if (visited[i] == 3 || visited[i] == 1) return false;
            dfsNodeStack.push(i);
            if (dfsCycleDetected(visited, dfsNodeStack, graph)) return false;
        }
        return true;
    }

    private boolean dfsCycleDetected(int[] visited, Stack<Integer> dfsNodeStack, Map<Integer, List<Integer>> graph) {
        while(!dfsNodeStack.isEmpty()) {
            int course = dfsNodeStack.pop();
            List<Integer> descendants = graph.get(course);
            // if no descendants, mark course as '2', i.e., safe. '1' means 'visiting'. '0' means unvisited. '3' means cycle found.
            if (descendants == null) {
                visited[course] = 2;
                return false;
            }
            if (visited[course] == 1) {
                // found cycle
                visited[course] = 3;
                return true;
            } else if (visited[course] == 2) {
                return false;
            }
            visited[course] = 1;

            for(Integer descendant: descendants) {
                if (visited[descendant] == 2) continue;
                dfsNodeStack.push(descendant);
                if (dfsCycleDetected(visited, dfsNodeStack, graph)) {
                    visited[descendant] = 3;
                    return true;
                } else {
                    visited[descendant] = 2;
                }
            }
            visited[course] = 2;
        }
        return false;
    }
}
