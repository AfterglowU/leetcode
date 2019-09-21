class Solution {
    public boolean isSubsequence(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen < 1) return true;
        else if (slen > tlen) return false;
        
        int j = 0;
        char tmp = s.charAt(j);
        for (int i = 0; i < tlen; i++) {
            if (tmp == t.charAt(i) && j < slen) {
                if (++j < slen) tmp = s.charAt(j);
                else break;
            }
        }
        
        return j == slen;
    }
}