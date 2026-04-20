class Solution {
    public String decodeString(String s) {
        // deal with corner cases
        if (s == null || s.isEmpty())
            return s;
        // convert input string to a char array
        char[] chs = s.toCharArray();
        // stack for the count
        Stack<Integer> countStack = new Stack<>();
        // stack for substrings
        Stack<String> strStack = new Stack<>();
        String currStr = "";
        int count = 0;
        for (int i = 0; i < chs.length; i++) {
            char curr = chs[i];
            // in case curr is a digit
            if (Character.isDigit(curr)) {
                count = count * 10 + curr - '0';
            }
            // in case curr is '['
            else if (curr == '[') {
                // push current count onto the stack and reset the count
                countStack.push(count);
                count = 0;
                // push current string onto the stack and reset the current string as well
                strStack.push(currStr);
                currStr = "";
            }
            // in case curr is ']'
            else if (curr == ']') {
                // pop a count off from the stack
                int currCount = countStack.pop();
                // pop off the previous string
                String prevStr = strStack.pop();
                // add current string
                while (currCount-- > 0) {
                    prevStr += currStr;
                }
                currStr = prevStr;
            } else {
                currStr += Character.toString(curr);
            }
        }
        return currStr;
    }
}