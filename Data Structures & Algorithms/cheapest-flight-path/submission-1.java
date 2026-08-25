class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        // k stops allow at most k + 1 flights
        for (int i = 0; i <= k; i++) {
            int[] nextPrices = prices.clone();
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                if (prices[from] == Integer.MAX_VALUE) {
                    continue;
                }
                nextPrices[to] = Math.min(nextPrices[to], prices[from] + price);
            }
            prices = nextPrices;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}