class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        int maxChar = 0;
        // Count each character and track the most frequent one
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            count[index]++;
            if (count[index] > count[maxChar]) {
                maxChar = index;
            }
        }
        // Reorganization is impossible if one character occupies
        // more than half of the available positions
        if (count[maxChar] > (s.length() + 1) / 2) {
            return "";
        }
        char[] result = new char[s.length()];
        int index = 0;
        // Place the most frequent character at even positions:
        // 0, 2, 4, ... to keep its occurrences separated
        while (count[maxChar] > 0) {
            result[index] = (char) ('a' + maxChar);
            index += 2;
            count[maxChar]--;
        }
        // Place all remaining characters in the available positions
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                // After even positions are filled, continue at odd positions
                if (index >= result.length) {
                    index = 1;
                }
                result[index] = (char) ('a' + i);
                index += 2;
                count[i]--;
            }
        }
        return new String(result);
    }
}