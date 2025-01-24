class Solution {
    List<Integer> ans = new ArrayList();
    HashMap<Integer,Boolean> hm=new HashMap();
    public List<Integer> eventualSafeNodes(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            if(!hm.containsKey(i)) {
                dfs(i,graph);
            }
        }
        for(Map.Entry<Integer,Boolean> m:hm.entrySet()){
            if(m.getValue()) ans.add(m.getKey());
        }
        Collections.sort(ans);
        return ans;
    }
    boolean dfs(int val,int[][] graph) {
        if(hm.containsKey(val)) return hm.get(val);
        hm.put(val,false);
        for (int v : graph[val]) {
            if(!dfs(v,graph)) return hm.get(v);
        }
        hm.put(val,true);
        return true;
    }
}