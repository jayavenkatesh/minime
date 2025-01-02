class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] arr=new int[words.length];
        Arrays.fill(arr,0);
        HashSet<Character> hs=new HashSet();
        hs.add('a');
        hs.add('e');
        hs.add('i');
        hs.add('o');
        hs.add('u');
        for(int i=0;i<words.length;i++){
            String s=words[i];
            if(hs.contains(s.charAt(0)) && hs.contains(s.charAt(s.length()-1))){
                arr[i]=i>0?arr[i-1]+1:1;
            }
            else{
                arr[i]=i>0?arr[i-1]:0;
            }
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
        int[] ans=new int[queries.length];
        int i=0;
        for(int[] q:queries){
            int l=q[0];
            int u=q[1];
            int z=arr[u];
            z=l==0?z:z-arr[l-1];
            ans[i++]=z;
        }
        return ans;
    }
}