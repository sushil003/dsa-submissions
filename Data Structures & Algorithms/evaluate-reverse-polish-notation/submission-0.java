class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!"+-*/".contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }
            int num2 = stack.pop();
            int num1 = stack.pop();
            int result = 0;
            switch (token) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2; 
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            stack.push(result);
        }
        return stack.pop();
    }
}