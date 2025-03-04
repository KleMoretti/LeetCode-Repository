/*给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。*/

#include <algorithm>
#include <vector>
using namespace std;

class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0)return false;
        vector<int> v;
        while(x!=0){
            v.push_back(x%10);
            x /= 10;
        }
        vector<int> v1=v;
        reverse(v1.begin(), v1.end());
        for(int i=0;i<v.size();i++){
            if(v[i]!=v1[i]) {
                return false;
            }
        }
        return true;
    }
};
