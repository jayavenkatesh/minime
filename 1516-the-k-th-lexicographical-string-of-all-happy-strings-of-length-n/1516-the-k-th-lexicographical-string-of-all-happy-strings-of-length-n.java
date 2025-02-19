class Solution {
    List<String> list = new ArrayList<>();
    public String getHappyString(int n, int k) {
        
        rec(n, "", "");
        if(k > list.size()) return "";
        return list.get(k-1);
    }
    private void rec(int n, String prev, String sb){
        if(sb.length() == n){
            list.add(sb.toString());
            return;
        }
        switch(prev){
            case "":  rec(n, "a", sb+"a");
                rec(n, "b", sb+"b");
                rec(n, "c", sb+"c");
                break;
            case "a": rec(n, "b", sb+"b");
                rec(n, "c", sb+"c");
                break;
            case "b": rec(n, "a", sb+"a");
                rec(n, "c", sb+"c");
                break;
            case "c": rec(n, "a", sb+"a");
                rec(n, "b", sb+"b");
                break;
        }
    }
}