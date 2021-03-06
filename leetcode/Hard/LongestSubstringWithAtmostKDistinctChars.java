import java.util.*;

//340 https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
public class LongestSubstringWithAtmostKDistinctChars {
    public static void main(String[] args) {
        LongestSubstringWithAtmostKDistinctChars obj = new LongestSubstringWithAtmostKDistinctChars();
        System.out.println(obj.lengthOfLongestSubstringKDistinct("WORLD", 4));
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();

        int left = 0;
        int maxLen = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            // keep increasing the window to the right
            map.put(c, map.getOrDefault(c, 0) + 1);

            // if we have more than k keys in our map, meaning we have more than k distinct chars,
            // hence start shrinking from the left end
            while (map.size() > k) {
                char leftChar = s.charAt(left++);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
            }


            // since we need ATMOST k distinct chars so for all values less than or equal to K, we will
            // consider the length and update our variable accordingly
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
