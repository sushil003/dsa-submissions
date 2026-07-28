class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(result,"",0,0,n);
        return result;
    }
    private void backTrack(List<String> result,String curr,int open,int close,int max){
        if(curr.length() == 2*max){
            result.add(curr);
        }
        if(open < max) {   
           backTrack(result,curr+"(",open+1,close,max); 
        }
        if(close < open) {   
           backTrack(result,curr+")",open,close+1,max); 
        }
    }
}
