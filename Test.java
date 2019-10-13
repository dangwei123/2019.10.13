1.
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 
的数目并将它们作为数组返回。
法一：
class Solution {
    public int[] countBits(int num) {
        int[] arr=new int[num+1];
        for(int i=0;i<=num;i++){
            int tmp=i;
            int count=0;
            while(tmp!=0){
                count++;
                tmp&=(tmp-1);
            }
            arr[i]=count;
        }
        return arr;
    }
}
法二：
class Solution {
    public int[] countBits(int num) {
        int[] arr=new int[num+1];
        for(int i=0;i<=num;i++){
          arr[i]=arr[i>>1]+(i&1);
        }
        return arr;
    }
}
法三：
class Solution {
    public int[] countBits(int num) {
        int[] arr=new int[num+1];
        for(int i=1;i<=num;i++){
          arr[i]=arr[i&(i-1)]+1;
        }
        return arr;
    }
}
2.
给定一个正整数 n，你可以做如下操作：

1. 如果 n 是偶数，则用 n / 2替换 n。
2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
n 变为 1 所需的最小替换次数是多少？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/integer-replacement
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int integerReplacement(int n) {
        int count=0;
        while(n!=1){
            if((n&1)==0){
                n>>>=1;
                count++;
            }else{
                if((n&2)==0){
                    n-=1;
                    count++;
                }else{
                    if(n==3){
                        count+=2;
                        break;
                    }else{
                        n+=1;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}

3.
给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。

找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。

你能在O(n)的时间解决这个问题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxor=0;
        int or=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                or=nums[i]^nums[j];
                if(or>maxor){
                    maxor=or;
                }
            }
        }
        return maxor;
    }
}
4.
两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。

计算一个数组中，任意两个数之间汉明距离的总和
class Solution {
    public int totalHammingDistance(int[] nums) {
        int count=0;
        for(int i=0;i<32;i++){
            int a=0;
                int b=0;
            for(int j=0;j<nums.length;j++){
                
                if(((nums[j]>>>i)&1)==1){
                    a++;
                }else{
                    b++;
                }
                  
            }
            count+=a*b;
        }
        return count;
    }
}