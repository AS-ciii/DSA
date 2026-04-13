class Solution {
    static int[] nextPalindrome(int[] num) {
        int n = num.length;
        int flag = 0;

        for(int i = 0;i <= n / 2;i++){
            if(num[i] > num[n - i - 1]) //okay
                flag = 1;
            else if(num[i] < num[n - i - 1]) //number getting smaller!
                flag = 0;
            num[n - i - 1] = num[i];
        }

        if(flag == 1) //everything okay!
            return num;

        //Now, if number got smaller
        //try increasing mid ele or eles

        //even number of digits
        if(n % 2 == 0){ 
            int i = n / 2 - 1;
            while(i > 0 && num[i] + 1 == 10 && num[n - i - 1] + 1 == 10){
                num[i] = 0;
                num[n - i - 1] = 0;
                i--;
            }
            num[i]++;
            num[n - i - 1]++;
        }
        //odd number of digits
        else{
            int i = n / 2;
            while(i > 0 && num[i] + 1 == 10 && num[n - i - 1] + 1 == 10){
                num[i] = 0;
                num[n - i - 1] = 0;
                i--;
            }
            if(i != n - i - 1){
                num[i]++;
                num[n - i - 1]++;
            }
            else
                num[i]++;
        }
        
        if(num[0] == 10){ //there were all 9s!!!
            int res[] = new int[n + 1];
            Arrays.fill(res, 0);
            res[0] = 1;
            res[n] = 1;
            return res;
        } 
        
        return num;
    }
}
