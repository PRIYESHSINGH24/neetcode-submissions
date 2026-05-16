class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        unordered_set<string> st;

        for (string email : emails) {
            string local = "";
            string domain = "";

            int i = 0;

            // local part process karo
            while (email[i] != '@') {
                if (email[i] == '+') {
                    // skip until '@'
                    while (email[i] != '@') {
                        i++;
                    }
                    break;
                }

                if (email[i] != '.') {
                    local += email[i];
                }

                i++;
            }

            // domain add karo
            while (i < email.size()) {
                domain += email[i];
                i++;
            }

            st.insert(local + domain);
        }

        return st.size();
    }
};