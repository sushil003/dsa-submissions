class Solution {
    public int calPoints(String[] operations) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(String s : operations){
           if(s.equals("C")){
                stack.pop();
            }else if(s.equals("D")){
                stack.push(2*stack.peek());
            }else if(s.equals("+")){
                int first = stack.pop();
                int newVal = first + stack.peek();
                stack.push(first);
                stack.push(newVal);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        for(int i : stack){
            res +=i;
        }
        return res;
    }
}