package com.mycompany.kthlargest215;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Result below without sorting. Build max heap first and then remove the max element, ie. root, k times.
 * The return is the kth largest number. However, it's slower than the first sorting approach.
 *
 * 27ms Beats 76.60%
 */
public class ImprovedSolution {
    public int findKthLargest(int[] nums, int k) {
        buildHeapSiftdown(nums);
        int result = -1;
        int n = nums.length;
        for (int i=0; i<k; i++) {
            result = deleteRoot(nums, n-i);
        }
        return result;
    }

    // Function to delete the root from Heap
    private int deleteRoot(int arr[], int n)
    {
        // Get the last element
        int lastElement = arr[n - 1];
        int rootElement = arr[0];

        // Replace root with first element
        arr[0] = lastElement;

        // Decrease size of heap by 1
        n = n - 1;

        // heapify the root node
        heapify(arr, n, 0);

        // return new size of Heap
        return rootElement;
    }

    private void buildHeapSiftdown(int[] arr) {
        // iterating right to left in the array
        // we don't need to start strictly at the end, since those nodes have no children
        // Math.floor(arr.length/2) gets the first node with children in a complete binary tree
        for (int i = (int) Math.floor(arr.length/2); i >= 0; i--) {
            siftdown(arr, i);
        }
    }

    private void siftdown(int[] arr, int level) {
        if (arr.length <= 1) {
            return;
        }

        int leftIdx = 2*level + 1;
        int rightIdx = 2*level + 2;
        int largest = level;

        // See if the left child is larger
        if (leftIdx < arr.length && arr[leftIdx] > arr[largest]) {
            largest = leftIdx;
        }

        // See if the right child is larger
        if (rightIdx < arr.length && arr[rightIdx] > arr[largest]) {
            largest = rightIdx;
        }

        if (largest != level) {
            // There's a child that's larger; switch with the largest child, and
            // see if we're smaller than its children
            swap(arr, largest, level);
            siftdown(arr, largest);
        }
    }

    private void swap(int[] arr, int first, int second) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[].Nn is size of heap
    private void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}
