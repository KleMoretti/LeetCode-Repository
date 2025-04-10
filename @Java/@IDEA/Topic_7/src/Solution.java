/*给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。
所以，我们到【最大数的1/10】时，就要开始判断了
如果某个数字大于 214748364那后面就不用再判断了，肯定溢出了。
如果某个数字等于 214748364呢，这对应到上图中第三、第四、第五排的数字，
需要要跟最大数的末尾数字比较，如果这个数字比7还大，说明溢出了。*/

class Solution {
    public int reverse(int x) {
        int sum = 0;
        while (x != 0) {
            if(sum > Integer.MAX_VALUE/10 || sum < Integer.MIN_VALUE/10) {
                return 0;
            }
            int j = x % 10;
            x /= 10;
            sum = sum * 10 + j;
        }

        return sum;
    }
    //抛出异常
    public int reverse2(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(Math.abs(x));

        try {
            int result = Integer.parseInt(sb.reverse().toString());
            return x > 0 ? result : -result;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }


}

