class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        int max = 0;
        for (int num : nums) {
            if (num == 1) {
                return false;
            }
            max = Math.max(max, num);
        }
        // Smallest prime factor for every number
        int[] smallestFactor = buildSmallestFactors(max);
        int[] factorOwner = new int[max + 1];
        Arrays.fill(factorOwner, -1);
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            int number = nums[i];
            while (number > 1) {
                int factor = smallestFactor[number];
                if (factorOwner[factor] == -1) {
                    factorOwner[factor] = i;
                } else {
                    uf.union(i, factorOwner[factor]);
                }
                // Process each prime factor only once
                while (number % factor == 0) {
                    number /= factor;
                }
            }
        }
        int root = uf.find(0);
        for (int i = 1; i < n; i++) {
            if (uf.find(i) != root) {
                return false;
            }
        }
        return true;
    }

    private int[] buildSmallestFactors(int max) {
        int[] smallestFactor = new int[max + 1];
        for (int factor = 2; factor <= max; factor++) {
            if (smallestFactor[factor] != 0) {
                continue;
            }
            for (int multiple = factor; multiple <= max; multiple += factor) {
                if (smallestFactor[multiple] == 0) {
                    smallestFactor[multiple] = factor;
                }
            }
        }
        return smallestFactor;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] size;

        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        void union(int first, int second) {
            int rootFirst = find(first);
            int rootSecond = find(second);
            if (rootFirst == rootSecond) {
                return;
            }
            if (size[rootFirst] < size[rootSecond]) {
                int temp = rootFirst;
                rootFirst = rootSecond;
                rootSecond = temp;
            }
            parent[rootSecond] = rootFirst;
            size[rootFirst] += size[rootSecond];
        }
    }
}