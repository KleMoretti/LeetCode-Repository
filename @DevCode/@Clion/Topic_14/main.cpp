/*编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。*/

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int n=strs.size();
        if(n==0) return "";
        string res = strs[0];
        for(int i=1;i<n;i++){
            int j=0;
            for(;j<res.size()&&j<strs[i].size();j++){
                if(res[j]!=strs[i][j]) break;
            }
            res=res.substr(0,j);
            if(res.empty()) return res;
        }
        return res;
    }
};
