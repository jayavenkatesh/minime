class Solution {  
    public int maxScore(String s) {  
        int leftscore=0;  
        int rightscore=0;  
        int ans=0;  

        for(int i = 0; i < s.length(); i++) {  
            if(s.charAt(i)=='1') rightscore++;  
        }  

        for(int i=0;i<s.length()-1;i++) {  
            if(s.charAt(i)=='0') leftscore++;  
            if(s.charAt(i)=='1') rightscore--;  

            ans = Math.max(ans,leftscore+rightscore);  
        }  
        ans=Math.max(ans,leftscore+rightscore);  
        return ans;  
    }  
}