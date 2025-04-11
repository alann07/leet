package com.mycompany.courseschedule207;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 207. Course Schedule
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses -
 * 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take
 * course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length < 1) return true;
        Arrays.sort(prerequisites, Comparator.comparingInt(a -> a[0]));

        int[] store = new int[numCourses];
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<numCourses; i++) {
            if (!dfs(numCourses, prerequisites, store, visited, i, 0)) return false;
        }
        return true;
    }

    private boolean dfs(int numCourses, int[][] prerequisites, int[] store, boolean[] visited, int courseIndex, int pIndex) {
        if (pIndex == prerequisites.length) return true;
        boolean prereqSatisfied = true; // if the courseIndex does not have any prerequisites, it's no-worry to take.
        int prereq=-1;
        for(int i=pIndex; i<prerequisites.length; i++){
            // need to find courseIndex exists in prerequisites
            if (courseIndex == prerequisites[i][0]) {
                prereq = prerequisites[i][1];
                if (prereq >= numCourses) return false;
                if (prereq<courseIndex) {
//                    if (visited[prereq]) return store[prereq]==1;
                    if (visited[prereq]) continue;
                    else {
                        int pq = findUnvisitedPrerquNode(prerequisites, prereq, i);
                        if (pq == -1) {
                            // at this point prereq is before the current courseIndex, it didnt get visited and not in the prerequisites
                            // so we can safely assume it's not required and hence not blocking anything.
                            visited[prereq] = true;
                            store[prereq] = 1;
                            return true;
                        } else {
                            // found in prerequisites, but not visited yet. let's visit it.
                            dfs(numCourses, prerequisites, store, visited, prereq, pq);
                        }
                    }
                } else if (prereq == courseIndex) return false;
                prereqSatisfied = dfs(numCourses, prerequisites, store, visited, prereq, pIndex+1);
                if (!prereqSatisfied) return false;
            }
            // since prerequisites is already pre-sorted, if current level is higher than courseIndex, no need to proceed.
            // we need to handle the situations that courseIndex may contain multiple prerequisites for the same course.
            if (prerequisites[i][0] > courseIndex) {
                break;
            }
        }
        if (prereqSatisfied) store[courseIndex] = 1;
        visited[courseIndex] = true;
        return prereqSatisfied;
    }

    private int findUnvisitedPrerquNode(int[][] prerequisites, int prereq, int end) {
        for (int i=0; i<end; i++) {
            if (prerequisites[i][0]==end) return i;
        }
        return -1;
    }
}
