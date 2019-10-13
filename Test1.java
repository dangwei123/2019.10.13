1.
数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。

你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：

将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
最开始的时候，同一位置上也可能放着两个或者更多的筹码。

返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/play-with-chips
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int minCostToMoveChips(int[] chips) {
        int a=0;
        int b=0;
        for(int i:chips){
            if(i%2==0){
                a++;
            }else{
                b++;
            }
        }
        return a>b?b:a;
    }
}

2.
给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。

形式上，如果我们可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum=0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
        }
        if(sum%3!=0){
            return false;
        }
        int avg=sum/3;
        int sum1=0;
        int sum2=0;
        int left=0;
        int right=A.length-1;
       for(left=0;left<A.length;left++){
            sum1+=A[left];
           if(sum1==avg){
               break;
           }
        }for(right=A.length-1;right>=0;right--){
            sum2+=A[right];
           if(sum2==avg){
               break;
           }
        }
        
        if(left+1<right){
            return true;
        }else{
            return false;
        }
        
    }
}

3.
给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的
最短距离的数组。

示例 1:

输入: S = "loveleetcode", C = 'e'
输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
说明:

字符串 S 的长度范围为 [1, 10000]。
C 是一个单字符，且保证是字符串 S 里的字符。
S 和 C 中的所有字母均为小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] res=new int[S.length()];
        int pre=-10001;
        for(int i=0;i<S.length();i++){
           if(S.charAt(i)==C){
               pre=i;
           }
            res[i]=i-pre;
        }
        pre=10001;
        for(int i=S.length()-1;i>=0;i--){
           if(S.charAt(i)==C){
               pre=i;
           }
            res[i]=Math.min(res[i],pre-i);
        }
        return res;
    }
}