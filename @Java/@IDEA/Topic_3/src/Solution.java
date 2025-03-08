import java.util.ArrayList;

/*给定一个字符串 s ，请你找出其中不含有重复字符的 最长  的长度。*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<String> strList = new ArrayList<>();
        for(int i = 0; i<s.length(); i++){
            for(int j=i+1;j<s.length();j++){
                strList.add(s.substring(i, j));
            }
        }
        int max = 0;
        for(String str : strList){
            if(isUnique(str)){
                if(str.length() > max){
                    max = str.length();
                }
            }
        }
        return max;
    }

    private boolean isUnique(String str) {

    }
}
