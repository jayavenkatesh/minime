class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> list=new ArrayList();
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            int[] a=nums1[i];
            int[] b=nums2[j];
            if(a[0]==b[0]){
                list.add(new int[]{a[0],a[1]+b[1]});
                i++;
                j++;
            }
            else if(a[0]>b[0]){
                list.add(new int[]{b[0],b[1]});
                j++;
            }
            else{
                list.add(new int[]{a[0],a[1]});
                i++;
            }
        }
        while(i<nums1.length){
            list.add(new int[]{nums1[i][0],nums1[i][1]});
            i++;
        }
        while(j<nums2.length){
            list.add(new int[]{nums2[j][0],nums2[j][1]});
            j++;
        }
        int n=list.size();
        int[][] ans=new int[n][2];
        for(int z=0;z<n;z++){
            ans[z]=list.get(z);
        }
        return ans;
    }
}