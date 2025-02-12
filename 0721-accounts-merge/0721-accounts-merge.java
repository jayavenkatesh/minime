class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DisjointSet ds=new DisjointSet(n);
        HashMap<String,Integer> hm=new HashMap();
        for(int i=0;i<n;i++){
            List<String> li=accounts.get(i);
            for(int j=1;j<li.size();j++){
                String s=li.get(j);
                if(hm.containsKey(s)){
                    ds.unionBySize(hm.get(s),i);
                }
                hm.put(s,i);
            }
        }
        List<List<String>> ans=new ArrayList();
        List<String>[] merg=new List[n];
        for(int i=0;i<n;i++) merg[i]=new ArrayList();
        for(Map.Entry<String,Integer> m:hm.entrySet()){
            String str=m.getKey();
            int node=ds.findUPar(m.getValue());
            merg[node].add(str);
        }
        for(int i=0;i<n;i++){
            if(merg[i].size()==0) continue;
            Collections.sort(merg[i]);
            List<String> temp=new ArrayList();
            temp.add(accounts.get(i).get(0));
            for(String st:merg[i]){
                temp.add(st);
            }
            ans.add(temp);
        }
        return ans;
    }
}