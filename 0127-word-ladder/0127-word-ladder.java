class pair{
    String s;
    int l;
    pair(String s,int l){
        this.s=s;
        this.l=l;
    }
}
class Solution {
    public int ladderLength(String b, String e, List<String> wl) {
        Queue<pair> queue=new LinkedList();
        queue.offer(new pair(b,1));
        while(!queue.isEmpty()){
            pair p=queue.poll();
            String s=p.s;
            if(s.equals(e)) return p.l;
            int len=0;
            while(len<s.length()){
                StringBuilder sb=new StringBuilder(s);
                for(char ch='a';ch<='z';ch++){
                    sb.setCharAt(len,ch);
                    if(wl.contains(sb.toString())){
                        queue.offer(new pair(sb.toString(),p.l+1));
                        wl.remove(sb.toString());
                    }
                }
                len++;
            }
        }
        return 0;
    }
}