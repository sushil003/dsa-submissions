class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToId = new HashMap<>();
        int idx = 0;
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if ("".equals(name)) {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, idx++);
                }
                dsu.union(emailToId.get(account.get(1)), emailToId.get(email));
            }
        }
        Map<Integer, List<String>> res = new HashMap<>();
        for (String email : emailToName.keySet()) {
            int index = dsu.find(emailToId.get(email));
            res.computeIfAbsent(index, x -> new ArrayList<>()).add(email);
        }
        for (List<String> emails : res.values()) {
            Collections.sort(emails);
            emails.add(0, emailToName.get(emails.get(0)));
        }
        return new ArrayList<>(res.values());
    }

    class DSU {
        int[] parent;

        DSU() {
            parent = new int[10001];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int xParent = find(x);
            int yParent = find(y);
            if (xParent != yParent) {
                parent[xParent] = yParent;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}