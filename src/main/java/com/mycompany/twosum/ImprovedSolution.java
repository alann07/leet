package com.mycompany.twosum;

/**
 * 60 ms
 */
public class ImprovedSolution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <2 || nums.length > 10000) {
            return new int[0];
        }

        if (target >1000000000 || target < -1000000000) {
            return new int[0];
        }

        int[] copy = clone(nums);

        quickSort(nums, 0, nums.length-1);

        int q = nums.length-1;
        int p = 0;
        while(p != q) {
            if (nums[p] + nums[q] == target) {
                int[] result = findIndexes(copy, nums[p], nums[q]);
                return  result;
            }

            if (nums[p] + nums[q] > target) {
                q--;
            } else if (nums[p] + nums[q] < target) {
                p++;
            }
        }

        return new int[0];
    }

    int[] findIndexes(int[] arr , int p, int q){
        int[] result = new int[2];
        boolean foundp=false;
        boolean foundq=false;
        for (int i=0; i<arr.length; i++) {
            if(arr[i] == p && !foundp) {
                result[0] = i;
                foundp=true;
            } else if (arr[i] == q && !foundq) {
                result[1] = i;
                foundq=true;
            }
            if (foundp && foundq) {
                break;
            }
        }
        return result;
    }

    int[] clone(int[] arr) {
        int[] result = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            result[i] = arr[i];
        }

        return result;
    }

    int partition(int[] arr, int low, int high) {

        // Choose the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = low - 1;

        // Traverse arr[low..high] and move all smaller
        // elements to the left side. Elements from low to
        // i are smaller after every iteration
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // Move pivot after smaller elements and
        // return its position
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Swap function
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // The QuickSort function implementation
    void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is the partition return index of pivot
            int pi = partition(arr, low, high);

            // Recursion calls for smaller elements
            // and greater or equals elements
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}