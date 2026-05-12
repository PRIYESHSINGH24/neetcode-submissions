class StockSpanner {
public:
    
    stack<pair<int,int>> st;
    int idx;

    StockSpanner() {
        idx = -1;
    }
    
    int next(int price) {
        
        idx++;

        while(!st.empty() && st.top().first <= price)
        {
            st.pop();
        }

        int span;

        if(st.empty())
        {
            span = idx + 1;
        }
        else
        {
            span = idx - st.top().second;
        }

        st.push({price, idx});

        return span;
    }
};