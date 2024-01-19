/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing
order, and two integers m and n, representing the number of elements in nums1 and
nums2 respectively.
 Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 The final sorted array should not be returned by the function, but instead be
stored inside the array nums1. To accommodate this, nums1 has a length of m + n,
where the first m elements denote the elements that should be merged, and the
last n elements are set to 0 and should be ignored. nums2 has a length of n.


 Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming
from nums1.


 Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]

Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].


 Example 3:
Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]

Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to
ensure the merge result can fit in nums1.


 Constraints:
 nums1.length == m + n
 nums2.length == n
 0 <= m, n <= 200
 1 <= m + n <= 200
 -10⁹ <= nums1[i], nums2[j] <= 10⁹


 Follow up: Can you come up with an algorithm that runs in O(m + n) time?

 Related Topics Array Two Pointers Sorting
*/

package com.alexandrehcr.leetcode.editor.en;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int index = n + m - 1;
            m--;
            n--;
            while (n >= 0) {
                if (m >= 0 && nums1[m] > nums2[n])
                    nums1[index--] = nums1[m--];
                else
                    nums1[index--] = nums2[n--];
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    @Nested
    class Tests {
        Solution solution = new Solution();

        @ParameterizedTest
        @MethodSource("args")
        void tests(int[] nums1, int m, int[] nums2, int n, int[] expected) {
            solution.merge(nums1, m, nums2, n);
            assertEquals(Arrays.toString(expected), Arrays.toString(nums1));
        }

        private static Stream<Arguments> args() {
            int[] nums1;
            int m;
            int[] nums2;
            int n;
            int[] expected;
            return Stream.of(
                    Arguments.of(nums1 = new int[]{1, 2, 3, 0, 0, 0}, m = 3, nums2 = new int[]{2, 5, 6}, n = 3, expected = new int[]{1, 2, 2, 3, 5, 6}),
                    Arguments.of(nums1 = new int[]{1}, m = 1, nums2 = new int[]{}, n = 0, expected = new int[]{1}),
                    Arguments.of(nums1 = new int[]{0}, m = 0, nums2 = new int[]{1}, n = 1, expected = new int[]{1}),
                    Arguments.of(nums1 = new int[]{2, 0}, m = 1, nums2 = new int[]{1}, n = 1, expected = new int[]{1, 2}),
                    Arguments.of(nums1 = new int[]{4, 5, 6, 0, 0, 0}, m = 3, nums2 = new int[]{1, 2, 3}, n = 3, expected = new int[]{1, 2, 3, 4, 5, 6}),
                    Arguments.of(nums1 = new int[]{4, 0, 0, 0, 0, 0}, m = 1, nums2 = new int[]{1, 2, 3, 5, 6}, n = 5, expected = new int[]{1, 2, 3, 4, 5, 6}),
                    Arguments.of(nums1 = new int[]{1, 2, 5, 6, 0, 0}, m = 4, nums2 = new int[]{3, 4}, n = 2, expected = new int[]{1, 2, 3, 4, 5, 6}));
        }
    }
}
