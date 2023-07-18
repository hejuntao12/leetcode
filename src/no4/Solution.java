package no4;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int k = length / 2;
        if(length % 2 == 0) {
            return ((double)findKthNum(nums1, nums2, k) + (double)findKthNum(nums1, nums2, k+1)) / 2;
        } else {
            return findKthNum(nums1, nums2, k+1);
        }
    }

    public int findKthNum(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int count = 0;
        while(true) {
            if(length1 == 0) {
                return nums2[index2+k-1];
            }
            if(length2 == 0) {
                return nums1[index1+k-1];
            }
            if(k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = k/2;
            int offset1 = Math.min(length1, half) - 1;
            int offset2 = Math.min(length2, half) - 1;
            if(nums1[index1 + offset1] < nums2[index2 + offset2]) {
                index1 = index1 + offset1 + 1;
                length1 = nums1.length - index1;
                k = k - offset1 - 1;
            } else {
                index2 = index2 + offset2 + 1;
                length2 = nums2.length - index2;
                k = k - offset2 - 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(new int[]{2}, new int[]{1,3,4}));
    }
}