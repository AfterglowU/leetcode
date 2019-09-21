class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastpos = new int[256];  // postion of latest occurrence
        for (int i = 0; i < 256; i++) {lastpos[i] = -1;}
        int maxLen = 0;
        int curLen = 0;
        int sLen = s.length();
        
        for (int i = 0; i < sLen; i++) {
            if (lastpos[s.charAt(i)] != -1 && i - lastpos[s.charAt(i)] <= curLen)  {
                maxLen = curLen > maxLen ? curLen : maxLen;
                curLen = i - lastpos[s.charAt(i)];
                lastpos[s.charAt(i)] = i;
            } else {
                lastpos[s.charAt(i)] = i;
                curLen++;
            }
        }
        
        // In case the longest substring is at the end of s.
        maxLen = curLen > maxLen ? curLen : maxLen;
        
        return maxLen;
    }
}