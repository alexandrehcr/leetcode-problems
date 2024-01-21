/**
Given an array arr of integers, check if there exist two indices i and j such 
that :
 i != j 
 0 <= i, j < arr.length 
 arr[i] == 2 * arr[j]

 
 Example 1:
Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
 

 Example 2:
Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.

 
 Constraints:
 2 <= arr.length <= 500 
 -10³ <= arr[i] <= 10³

 Related Topics Array Hash Table Two Pointers Binary Search Sorting
*/

package com.alexandrehcr.leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkIfExist(int[] arr) {
            Set<Integer> set = new HashSet<>();
            for (int n : arr) {
                if (set.contains(2 * n) || (n & 1) == 0 && set.contains(n >> 1))
                    return true;
                set.add(n);
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // Time Complexity: O(n)
    // Space Complexity: O(n)
}
