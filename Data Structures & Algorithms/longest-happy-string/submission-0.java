class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int[] remaining = {a, b, c};
        StringBuilder result = new StringBuilder();
        while (true) {
            int best = -1;
            for (int i = 0; i < 3; i++) {
                char current = (char) ('a' + i);
                int length = result.length();
                boolean createsTriple =
                        length >= 2 &&
                        result.charAt(length - 1) == current &&
                        result.charAt(length - 2) == current;
                if (remaining[i] > 0 &&
                    !createsTriple &&
                    (best == -1 || remaining[i] > remaining[best])) {
                    best = i;
                }
            }
            if (best == -1) break;
            result.append((char) ('a' + best));
            remaining[best]--;
        }
        return result.toString();
    }
}