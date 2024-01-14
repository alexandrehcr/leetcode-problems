/**
Given two strings ransomNote and magazine, return true if ransomNote can be 
constructed by using the letters from magazine and false otherwise.
 Each letter in magazine can only be used once in ransomNote. 

 Example 1: 
 Input: ransomNote = "a", magazine = "b"
Output: false
 
 Example 2: 
 Input: ransomNote = "aa", magazine = "ab"
Output: false
 
 Example 3: 
 Input: ransomNote = "aa", magazine = "aab"
Output: true
 
 Constraints:
 1 <= ransomNote.length, magazine.length <= 10⁵ 
 ransomNote and magazine consist of lowercase English letters.

 Related Topics Hash Table String Counting
*/

package com.alexandrehcr.leetcode.editor.en;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RansomNote {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            if (ransomNote.length() > magazine.length())
                return false;
            Map<Character, Integer> magLetters = new HashMap<>();
            for (int i = 0; i < magazine.length(); i++) {
                char c = magazine.charAt(i);
                Integer count = magLetters.getOrDefault(c, 0);
                magLetters.put(c, count + 1);
            }
            for (int i = 0; i < ransomNote.length(); i++) {
                char c = ransomNote.charAt(i);
                Integer count = magLetters.getOrDefault(c, 0);
                if (count == 0)
                    return false;
                magLetters.put(c, count - 1);
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    @Nested
    class SampleTests {
        Solution solution = new Solution();

        @ParameterizedTest
        @MethodSource("args")
        void tests(String ransomNote, String magazine, boolean expected) {
            assertEquals(expected, solution.canConstruct(ransomNote, magazine));
        }

        private static Stream<Arguments> args() {
            return Stream.of(
                    Arguments.of("a", "b", false),
                    Arguments.of("aa", "ab", false),
                    Arguments.of("aa", "aab", true));
        }
    }
}
