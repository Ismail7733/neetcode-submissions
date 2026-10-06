class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] charsS = new int[26];
        int[] charsT = new int[26];

        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            charsS[122 - c] = charsS[122 - c] + 1;
        }

        for (int i = 0; i < t.length(); i ++) {
            char c = t.charAt(i);
            charsT[122 - c] = charsT[122 - c] + 1;
        }

        for (int i = 0; i < charsT.length; i++) {
            boolean stEqual = charsT[i] == charsS[i];

            if (!stEqual) {
                return false;
            }
        }

        return true;
    }
}
