class Solution {
public:
    bool isValid(string s) {
        stack<char> st;

        for (char ch : s) {

            // opening brackets push karo
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            else {

                // agar closing bracket aaya aur stack empty hai
                if (st.empty()) {
                    return false;
                }

                // matching check
                if ((ch == ')' && st.top() == '(') ||
                    (ch == '}' && st.top() == '{') ||
                    (ch == ']' && st.top() == '[')) {

                    st.pop();
                }
                else {
                    return false;
                }
            }
        }

        // agar stack empty hai toh valid
        return st.empty();
    }
};