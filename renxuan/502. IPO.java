class Solution {
    class Pair {
        int profit, capital;
        Pair(int p, int c) {
            profit = p;
            capital = c;
        }
    }
    
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int n = Profits.length;
        List<Pair> array = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            array.add(new Pair(Profits[i], Capital[i]));
        }
        Collections.sort(array, (a, b) -> {
            if(a.profit == b.profit)
                return a.capital - b.capital;
            return b.profit - a.profit;
        });
        for(int i = 0; i < k; ++i) {
            int index = 0;
            for(; index < array.size(); ++index) {
                if(array.get(index).capital <= W)
                    break;
            }
            if(index == array.size()) break;
            W += array.get(index).profit;
            array.remove(index);
        }
        return W;
    }
}
