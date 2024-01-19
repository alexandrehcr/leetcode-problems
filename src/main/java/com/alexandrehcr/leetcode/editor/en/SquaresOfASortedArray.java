/**
Given an integer array nums sorted in non-decreasing order, return an array of 
the squares of each number sorted in non-decreasing order. 

 
 Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
 

 Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

 
 Constraints:
 1 <= nums.length <= 10⁴ 
 -10⁴ <= nums[i] <= 10⁴ 
 nums is sorted in non-decreasing order. 

 
Follow up: Squaring each element and sorting the new array is very trivial, 
could you find an O(n) solution using a different approach?

 Related Topics Array Two Pointers Sorting
*/

package com.alexandrehcr.leetcode.editor.en;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

public class SquaresOfASortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int index;
            int i = 0;
            int j = index = n - 1;
            int[] output = new int[n];

            while (i <= j) {
                if (Math.abs(nums[i]) > Math.abs(nums[j])){
                    output[index--] = nums[i] * nums[i];
                    i++;
                }
                else {
                    output[index--] = nums[j] * nums[j];
                    j--;
                }
            }
            return output;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    @Nested
    class Tests {
        Solution solution = new Solution();

        @ParameterizedTest
        @MethodSource("args")
        void tests(int[] input, int[] expected) {
            int[] sortedSquares = solution.sortedSquares(input);
            Assertions.assertEquals(
                    Arrays.toString(expected),
                    Arrays.toString(sortedSquares));
        }

        private static Stream<Arguments> args() {
            return Stream.of(
                    Arguments.of(new int[]{-4, -1, 0, 3, 10}, new int[]{0, 1, 9, 16, 100}),
                    Arguments.of(new int[]{-7, -3, 2, 3, 11}, new int[]{4, 9, 9, 49, 121}),
                    Arguments.of(new int[]{-5,-3,-2,-1}, new int[]{1,4,9,25}));

        }
    }
}
