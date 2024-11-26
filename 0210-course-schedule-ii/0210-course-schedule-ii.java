class Solution {
    List<Integer> ans;
    public int[] findOrder(int n, int[][] p) {
        ans=new ArrayList();
        if(canFinish(n,p)){
            int a=ans.size();
            int[] arr=new int[a];
            for(int i=0;i<a;i++){
                arr[i]=ans.get(i);
            }
            return  arr;
        }
        return new int[]{};
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list=new ArrayList();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList());

        }
        int visited[]=new int[numCourses];
        
        for(int i=0;i<prerequisites.length;i++){
            int[] arr=prerequisites[i];
            list.get(arr[0]).add(arr[1]);
            

        }
        for(int i=0;i<list.size();i++){
            if(!dfs(i,list,visited)){
                return false;
            }   
        }
        return true;
    }
    boolean dfs(int i,List<List<Integer>> list,int[] visited){
        if(visited[i]==1){
            return false;
        }
        if(visited[i]==2){
            return true;
        }
        visited[i]=1;
        for(int n:list.get(i)){
            if(!dfs(n,list,visited))
                return false;
        }
        visited[i]=2;
        ans.add(i);
        return true;
    }
}