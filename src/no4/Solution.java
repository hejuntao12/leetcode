package no4;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0) {
            return findmedian(nums2, 0, nums2.length-1);
        }
        if(nums2.length == 0) {
            return findmedian(nums1, 0, nums1.length-1);
        }
        return compareMedian(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1);
    }

    private double findMedianSortedArrays(int[] nums1, int[] nums2,
                                          int arr1start, int arr1end, int arr2start, int arr2end) {
        int delete = Math.min((arr1end - arr1start + 1) / 2, (arr2end - arr2start + 1) / 2);
        if(delete == 0) {
            if(arr1start == arr1end) {
                return findmedian(nums2, arr2start, arr2end, nums1[arr1start]);
            } else {
                return findmedian(nums1, arr1start, arr1end, nums2[arr2start]);
            }
        }
        return compareMedian(nums1, nums2, arr1start + delete, arr1end, arr2start, arr2end - delete);
    }

    private double compareMedian(int[] nums1, int[] nums2,
                                 int arr1start, int arr1end, int arr2start, int arr2end) {
        double arr1midian = findmedian(nums1, arr1start, arr1end);
        double arr2median = findmedian(nums2, arr2start, arr2end);
        if(arr1midian == arr2median) {
            return arr1midian;
        } else if (arr1midian < arr2median) {
            return findMedianSortedArrays(nums1, nums2, arr1start, arr1end, arr2start, arr2end);
        } else {
            return findMedianSortedArrays(nums2, nums1, arr2start, arr2end, arr1start, arr1end);
        }
    }

    private double findmedian(int[] nums, int start, int end) {
        return (double)(nums[(end + start)/2] + nums[(end + start + 1)/2]) / 2;
    }

    private double findmedian(int[] nums, int start, int end, int other) {
        if(start == end) {
            return (double)(nums[start] + other) / 2;
        } else {
            return findmedian(nums, start, end) > other ? findmedian(nums, start, end-1) : findmedian(nums, start+1, end);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{-1, 3}));
    }
}
