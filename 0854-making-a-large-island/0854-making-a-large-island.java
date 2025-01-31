class Solution {
    public int largestIsland(int[][] grid){
       int n= grid.length;//grid dimmension 
       int index= 2;//indexing to store the Unique island area into the HashMap 
        
       HashMap<Integer, Integer> map= new HashMap<>();//index -- area
        
       map.put(0, 0);//putting the 0 because when we are provided with only 0 matrix 
       //like component finding in a disconnected undirected graph 
       for(int i= 0; i< n; i++)
       {
           for(int j= 0; j< n; j++)
           {
               if(grid[i][j] == 1)
               {
                   int area= calcIslandArea(grid, n, i, j, index);//calculating the area of the island and storing into the area into the HashMap with a unique index 
                   map.put(index, area);
                   index+= 1;//increasing the index for the next island or the component 
               }
           }
       }
        
       int[][] trav= {{0,1},{0,-1},{1,0},{-1,0}};//traversing in 4 Direction 
       int max0ConnectedArea= map.getOrDefault(2, 0);//putting the area of the first component if present in the map, else putting 0 
       for(int i= 0; i< n; i++)
       {
           for(int j= 0; j< n; j++)
           {
               if(grid[i][j] == 0)
               {
                   Set<Integer> set= new HashSet<>();//set stores only unique values 
                   
                   //Searching(island) in 4 Direction of 0
                   for(int []dirc: trav)
                   {
                       //Current Updated co-ordinate
                       int i_= i+ dirc[0];
                       int j_= j+ dirc[1];
                       
                       if(i_< 0 || i_ >= n || j_< 0 || j_>= n)
                           continue;//index out of bound case 
                       
                       set.add(grid[i_][j_]);//adding the island index into the set
                   }
                   
                   int surroundedArea= 1;//initializing with 1 because we are including 0 as the part of connected island area
                   for(int idx: set)
                       surroundedArea+= map.get(idx);//calculating the area
                   
                   max0ConnectedArea= Math.max(max0ConnectedArea, surroundedArea);//updating the current maximum connected island area, due to 0 swapping to 1
               }
           }
       }
       //0 is acting as a unit length bridge between two component or island 
       return max0ConnectedArea;//returning the maximum connected island area, due to swapping of one 0 to 1 
    }
    
    private int calcIslandArea(int[][] grid, int n, int i, int j, int index)
    {//Preorder DFS Approach 
        if(i< 0 || i >= n || j< 0 || j>= n || grid[i][j] != 1)
            return 0;
        
        grid[i][j]= index;//marking it as visited 
        
        //Recursing down in 4 Direction 
        int top= calcIslandArea(grid, n, i-1, j, index);
        int right= calcIslandArea(grid, n, i, j+1, index);
        int bottom= calcIslandArea(grid, n, i+1, j, index);
        int left= calcIslandArea(grid, n,i, j-1, index);
        
        return 1+ top+ right+ bottom+ left;//including me and moving in depth 
    }
}// Please do Upvote, it helps a lot