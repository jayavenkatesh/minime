class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        List<List<List<Integer>>> storeQueries = new ArrayList<>( heights.length);
 for (int i = 0; i < heights.length; i++){
storeQueries.add(
            new ArrayList<>()
        );
 }
 PriorityQueue<List<Integer>> pq=new PriorityQueue<>(  (a, b) -> a.get(0) - b.get(0)   );

 int[] res= new int[queries.length];
        Arrays.fill(res, -1);

        for(int i=0;i<queries.length;i++){
            int aIndex=queries[i][0];
            int bIndex=queries[i][1];
            if(aIndex==bIndex){
                res[i]=aIndex;
            }else if(bIndex>aIndex && heights[bIndex]>heights[aIndex]){
         res[i]=bIndex;
            }else if(bIndex<aIndex && heights[bIndex]<heights[aIndex]){
          res[i]=aIndex;
            }else{
    storeQueries.get(Math.max(aIndex,bIndex))
    .add(
        Arrays.asList(
            Math.max(heights[bIndex],heights[aIndex])
            ,i));
            }
        }
        for(int i=0;i<heights.length;i++){

            while(!pq.isEmpty() && pq.peek().get(0)<heights[i]){
                res[pq.peek().get(1)]=i;
                pq.poll();
            }
            for (List<Integer> element : storeQueries.get(i)) {
               pq.offer(element);
            }

        }
        return res;
}
}