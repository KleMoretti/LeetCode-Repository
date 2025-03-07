import java.util.Stack;

/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。*/
class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0){
            return false;
        }else{
            Stack<Character> stack = new Stack<>();
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(c=='('||c=='{'||c=='['){
                    stack.push(c);
                }else{
                    if(stack.isEmpty()){
                        return false;
                    }
                    char left = stack.pop();
                    if(left=='('&&c!=')'){
                        return false;
                    }
                    if(left=='{'&&c!='}'){
                        return false;
                    }
                    if(left=='['&&c!=']'){
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}