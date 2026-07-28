class Solution { 
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res,new ArrayList<>(),1,n,k);
        return res;
    }
    private void combine(List<List<Integer>> res, List<Integer> l,int start, int n, int k){  
        if(k == 0) {  
            res.add(new ArrayList<>(l));
            return;
        }
        for(int i=start; i<=n; i++) {
            l.add(i);
            combine(res,l,i+1,n, k - 1);
            l.remove(l.size() -  1);
        }
    }
}