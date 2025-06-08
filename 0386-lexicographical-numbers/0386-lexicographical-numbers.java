class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list=new ArrayList();
        for(int i=1;i<10;i++){
            dfs(i,n,list);
        }
        return list;
    }
    void dfs(int a,int n,List<Integer> list){
        if(a>n){
            return;
        }
        list.add(a);
        for(int i=0;i<10;i++){
            if(a*10+i>n){
                break;
            }
            dfs(a*10+i,n,list);
        }
    }
}