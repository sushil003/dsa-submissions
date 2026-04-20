class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] component = path.split("/");
        for (String s : component) {
            if (".".equals(s) || s.isEmpty()) {
                continue;
            } else if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}