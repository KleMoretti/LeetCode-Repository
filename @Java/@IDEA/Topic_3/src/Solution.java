import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*给定一个字符串 s ，请你找出其中不含有重复字符的 最长的长度。
* 输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<String> strList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                strList.add(s.substring(i, j));
            }
        }
        if(strList.size() == 0){
            return s.length();
        }
        int max = 0;
        for (String str : strList) {
            char[] chars = str.toCharArray();
            boolean flag = true;
            for (int i = 0; i < str.length(); i++) {
                if (str.indexOf(chars[i]) != i) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                max = Math.max(max, str.length());
            }
        }
        return max;
    }



    public int lengthOfLongestSubstring_(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();

        while (right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, right - left);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
}

}
