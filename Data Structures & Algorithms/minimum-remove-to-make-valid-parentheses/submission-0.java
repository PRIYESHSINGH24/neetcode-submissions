class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {

            if (Character.isLetter(c)) {

                sb.append(c);

            } else if (c == '(') {

                sb.append(c);
                stack.push(sb.length() - 1);

            } else {

                if (!stack.isEmpty()) {

                    sb.append(c);
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }

        return sb.toString();
    }
}