class Solution {
    public int countPrimes(int n) {
        if(n < 2){
        	return 0;
        }
        /*
        boolean[] flag = new boolean[n+1];
        int cnt = 0;
        for(int i = 2; i < n; ++i){
        	if(flag[i]){
        		continue;
        	}
        	cnt++;
        	for(int j = i; j < n;){
        		flag[j] = true;
        		j += i;
        	}
        }
        */
        int cnt = 0;
        int[] arrays = new int[n/32 + 1];
        for (int i = 2; i < n; ++i) {
            if ((arrays[i/32] & (1 << (i & 31))) == 0) {
                ++cnt;
                for (int j = i; j < n;) {
                    arrays[j/32] |= 1 << (j & 31);
                    j += i;
                }
            }
        }
        return cnt;
    }
}


// 204. Count Primes
/*
public int CountPrimes(int n) 
{
    int count = 0;
    //一个 int 变量占用 32 字节
    //在C#中，提供了点阵列（BitArray）数组，用这玩意可读性一定会好于我写的代码。
    int[] signs = new int[n / 32 + 1];
    for (int i = 2; i < n; i++)
    {
        //将元素和需确定得数字经行按位或运算，如果值改变，说明不存在该数字（未登记该数字），则其为质数。
        //(当某个数为 2 的 n 次方时（n为自然数），其 & (n - 1) 所得值将等价于取余运算所得值)
        //*如果 x = 2^n ，则 x & (n - 1) == x % n
        //下面判断可以写成
        //if ((signs[i / size] & (1 << (i % 32))) == 0)
        if ((signs[i / 32] & (1 << (i & 31))) == 0)
        {
            count++;
            for (int j = i + i; j < n; j += i)
            {
                //登记该数字
                signs[j / 32] |= 1 << (j & 31);
            }
        }
    }
    return count;
}

*/
