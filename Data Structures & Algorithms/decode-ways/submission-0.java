class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int prevTwo = 1; // Ways to decode empty string
        int prevOne = 1; // Ways to decode first character
        for (int i = 2; i <= s.length(); i++) {
            int current = 0;
            // Decode current digit separately
            if (s.charAt(i - 1) != '0') {
                current += prevOne;
            }
            // Decode previous and current digits together
            int twoDigits = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (twoDigits >= 10 && twoDigits <= 26) {
                current += prevTwo;
            }
            prevTwo = prevOne;
            prevOne = current;
        }
        return prevOne;
    }
}