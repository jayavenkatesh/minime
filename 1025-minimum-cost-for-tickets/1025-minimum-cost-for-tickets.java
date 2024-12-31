class Solution {
    HashMap<Integer,Integer> hm=new HashMap();
    public int mincostTickets(int[] days, int[] costs) {
        int[] d={1,7,30};
        int ans=rec(0,days,costs,d);
        return ans;
    }
    int rec(int i,int[] days,int[] costs,int[] d){
        if(i>=days.length){
            return 0;
        }
        if(hm.containsKey(days[i])){
            return hm.get(days[i]);
        }
        hm.put(days[i],Integer.MAX_VALUE);

        for(int k=0;k<costs.length;k++){
            int a=costs[k];
            int b=d[k];
            int j=i;
            while(j<days.length && days[j]<days[i]+b){
                j++;
            }
            int z=Math.min(hm.get(days[i]),a+rec(j,days,costs,d));
            hm.put(days[i],z);
        }
        return hm.get(days[i]);
    }
}