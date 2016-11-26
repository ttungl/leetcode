// https://leetcode.com/problems/median-of-two-sorted-arrays/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 1.merge two arrays to one array
        // 2.sort this merged array
        // 3.get the median of this array
        //// Note: 1st array starts at zero.
        // 1. merging
        double median = 0; 
        int len = nums1.length + nums2.length;
        int[] lst = new int[len]; // new length
        
        for (int i=0; i<nums1.length; i++){
            lst[i] = nums1[i];
        }
        // extend
        int inc = 0;
        for (int j=nums1.length; j<len; j++){
            lst[j] = nums2[inc];
            inc++;
        }
        // 2. Bubble sorting: Time execution exceeded when using this algorithm.
        //// time,space [best O(n); worst+average 0(n^2)]
        // for(int k=0; k<len; k++){
        //     for(int h=0; h<(len-1); h++){
        //         if(lst[h] > lst[h+1]){ // inc_swap
        //             int temp = lst[h];
        //             lst[h] = lst[h+1];
        //             lst[h+1] = temp;
        //         }
        //     }
        // }
        ////
        // 2. Quicksort 
        // time,space 
        // [average O(n log n)]
        // [worst O(n^2)]
        quicksort(lst, 0, len-1);
        
        // 3. Median
        if (len%2==1){ // odd
            int index = (len+1)/2;
            median = lst[index-1];
        } else { // even
            int index1 = (len/2);
            int index2 = index1 + 1;
            int sum = (lst[index1-1] + lst[index2-1]);
            median = (double) sum/2;
        }
        return median;
    }
    
    public static void quicksort(int [] arr, int low, int high){
        if(arr==null || arr.length==0){
            return;
        }
        if (low>high){
            return;
        }
        
        //pivot
        int middle = low+(high-low)/2;
        int pivot = arr[middle];
        
        // divide to left < pivot and right > pivot
        int i = low, j = high;
        while (i<=j){
            while(arr[i] < pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }
            // swap
            if(i<=j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++; j--;
            }
        }
        // recursively sort two subs
        if (low <j){
            quicksort(arr, low, j);
        }
        if (high >i){
            quicksort(arr, i, high);
        }   
    }   
}