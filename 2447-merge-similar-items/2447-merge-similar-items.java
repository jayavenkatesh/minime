class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] nums1, int[][] nums2) {
        Arrays.sort(nums1,(a,b) -> a[0]-b[0]);
        Arrays.sort(nums2,(a,b) -> a[0]-b[0]);
        List<List<Integer>> list=new ArrayList();
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length){
            list.add(new ArrayList());
            int[] a=nums1[i];
            int[] b=nums2[j];
            if(a[0]==b[0]){
                list.get(list.size()-1).add(a[0]);
                list.get(list.size()-1).add(a[1]+b[1]);
                i++;
                j++;
            }
            else if(a[0]>b[0]){
                list.get(list.size()-1).add(b[0]);
                list.get(list.size()-1).add(b[1]);
                j++;
            }
            else{
                list.get(list.size()-1).add(a[0]);
                list.get(list.size()-1).add(a[1]);
                i++;
            }
        }
        while(i<nums1.length){
            list.add(new ArrayList());
            list.get(list.size()-1).add(nums1[i][0]);
            list.get(list.size()-1).add(nums1[i][1]);
            i++;
        }
        while(j<nums2.length){
            list.add(new ArrayList());
            list.get(list.size()-1).add(nums2[j][0]);
            list.get(list.size()-1).add(nums2[j][1]);
            j++;
        }
        return list;
    }
}