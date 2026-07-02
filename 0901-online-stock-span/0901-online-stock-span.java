import java.util.*;

class StockSpanner {

    private ArrayList<Integer> prices;
    private Stack<Integer> st;

    public StockSpanner() {
        prices = new ArrayList<>();
        st = new Stack<>();
    }

    public int next(int price) {

        int idx = prices.size();
        prices.add(price);

        while (!st.isEmpty() && prices.get(st.peek()) <= price) {
            st.pop();
        }

        int pge;
        if (st.isEmpty()) {
            pge = -1;
        } else {
            pge = st.peek();
        }

        st.push(idx);

        return idx - pge;
    }
}