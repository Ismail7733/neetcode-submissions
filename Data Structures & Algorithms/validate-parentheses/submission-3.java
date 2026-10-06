class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i ++) {
            char p = s.charAt(i);

            if (p == '(' || p == '{' || p == '[') {
                stack.push(p);
            }
            else  {
                if (stack.empty()) {
                    return false;
                }   

                char last = stack.pop();

                boolean validOrder1 = (p == ')' && last == '(');
                boolean validOrder2 = (p == '}' && last == '{');
                boolean validOrder3 = (p == ']' && last == '[');

                if (!(validOrder1 || validOrder2 || validOrder3)) {
                    return false;
                }
            }
        }

        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
