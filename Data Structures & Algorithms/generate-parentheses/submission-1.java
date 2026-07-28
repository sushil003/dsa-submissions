class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
       dfs(result,"",0,0,n);
        return result;
    }
    private void   dfs(List<String> result,String curr,int open,int close,int max){
        if(curr.length() == 2*max){
            result.add(curr);
        }
        if(open < max) {   
           dfs(result,curr+"(",open+1,close,max); 
        }
        if(close < open) {   
           dfs(result,curr+")",open,close+1,max); 
        }
    }
}
