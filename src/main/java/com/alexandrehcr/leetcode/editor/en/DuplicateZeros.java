/**
Given a fixed-length integer array arr, duplicate each occurrence of zero, 
shifting the remaining elements to the right. 

 Note that elements beyond the length of the original array are not written. Do
the above modifications to the input array in place and do not return anything. 

 
 Example 1:
Input: arr = [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]

Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 

 Example 2:
Input: arr = [1,2,3]
Output: [1,2,3]

Explanation: After calling your function, the input array is modified to: [1,2,3]


 Constraints:
 1 <= arr.length <= 10⁴ 
 0 <= arr[i] <= 9

 Related Topics Array Two Pointers
*/

package com.alexandrehcr.leetcode.editor.en;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

// I couldn't get to a solution where the array is changed in place and the time complexity is O(n).
public class DuplicateZeros {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void duplicateZeros(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) { // condition: if 0 is at last index, cannot duplicate it.
                if (arr[i] == 0)
                    insertZeroAt(++i, arr); // increments i twice when i == 0, so the loop doesn't read the duplicated 0.
            }
        }
        private void insertZeroAt(int index, int[] arr) {
            for (int i = arr.length - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    @Nested
    class Tests {
        Solution solution = new Solution();

        @ParameterizedTest
        @MethodSource("args")
        public void tests(int[] input, int[] expected) {
            solution.duplicateZeros(input);
            assertEquals(Arrays.toString(expected), Arrays.toString(input));
        }

        private static Stream<Arguments> args() {
            return Stream.of(
                    Arguments.of(
                            new int[]{1, 0, 2, 3, 0, 4, 5, 0},
                            new int[]{1, 0, 0, 2, 3, 0, 0, 4}),
                    Arguments.of(
                            new int[]{1, 2, 3},
                            new int[]{1, 2, 3}),
                    Arguments.of(
                            new int[]{0, 1, 7, 6, 0, 2, 0, 7},
                            new int[]{0, 0, 1, 7, 6, 0, 0, 2}),
                    Arguments.of(
                            new int[]{0, 0, 0, 0, 0, 0, 0},
                            new int[]{0, 0, 0, 0, 0, 0, 0}),
                    Arguments.of(
                            new int[]{8, 4, 5, 0, 0, 0, 0, 7},
                            new int[]{8, 4, 5, 0, 0, 0, 0, 0}));
        }
    }
}
