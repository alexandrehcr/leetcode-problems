/*
A school is trying to take an annual photo of all the students. The students 
are asked to stand in a single file line in non-decreasing order by height. Let 
this ordering be represented by the integer array expected where expected[i] is 
the expected height of the iᵗʰ student in line.
 You are given an integer array heights representing the current order that the 
students are standing in. Each heights[i] is the height of the iᵗʰ student in 
line (0-indexed).
Return the number of indices where heights[i] != expected[i].

 
 Example 1: 
Input: heights = [1,1,4,2,1,3]
Output: 3

Explanation:
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
Indices 2, 4, and 5 do not match.
 

 Example 2: 
Input: heights = [5,1,2,3,4]
Output: 5

Explanation:
heights:  [5,1,2,3,4]
expected: [1,2,3,4,5]
All indices do not match.
 

 Example 3: 
Input: heights = [1,2,3,4,5]
Output: 0

Explanation:
heights:  [1,2,3,4,5]
expected: [1,2,3,4,5]
All indices match.


 Constraints: 
 1 <= heights.length <= 100
 1 <= heights[i] <= 100 

 Related Topics Array Sorting Counting Sort
*/

package com.alexandrehcr.leetcode.editor.en;

public class HeightChecker {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int heightChecker(int[] heights) {
            int[] heightsFreq = new int[101]; // 1 <= heights[i] <= 100 is a constraint
            for (int height : heights)
                heightsFreq[height]++;
            int misses = 0;
            int height = 0;
            for (int i = 0; i < heights.length; i++) {
                while (heightsFreq[height] == 0) height++;
                if (heights[i] != height) misses++;
                heightsFreq[height]--;
            }
            return misses;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // Time Complexity: O(n). Input array is traversed twice.
    // Space Complexity: O(1). No extra space is allocated as the input grows.
}
