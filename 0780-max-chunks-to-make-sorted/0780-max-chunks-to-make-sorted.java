class Solution {
    public int maxChunksToSorted(int[] arr) {
        boolean[] visited=new boolean[arr.length];
        int step=0;
        int ans=0;
        for(int i=0;i<arr.length;i++){
            // if(arr[i]==i){
            //     ans++;
            //     step=i+1;
            //     continue;
            // }
            if(step==arr[i]){
                visited[step]=true;
                visited[arr[i]]=true;
                ans++;
                while(step<=i){
                    if(!visited[step]){
                        ans--;
                        break;
                    }
                    step++;
                }
            }
            visited[arr[i]]=true;
        }
        return ans;
    }
}