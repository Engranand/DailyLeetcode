class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
       int left = 0;
       int right = n-1;
         
      int[] result = new int[n];
      int index=n-1;


        while(left<=right){
            int leftsqr= nums[left]*nums[left];
            int rightsqr= nums[right]*nums[right];
            if(leftsqr>rightsqr){
                result[index]=leftsqr;
                left ++;
            }
            else{
                result[index]=rightsqr;
                right--;
            }
            index--;
            }
         
            return result;
        }
        
}