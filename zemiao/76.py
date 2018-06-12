class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """        
        counter = len(t)
        m = {}
        for c in t:
            m[c] = m[c]+1 if c in m else 1
        
        head, i, ans = 0, 0, ""
        while(i < len(s)):
            if s[i] in m:
                if m[s[i]] > 0:
                    counter -= 1
                m[s[i]] -= 1
            i += 1

            while counter == 0 and head < i:
                # found a qualified substring, now trim head
                if s[head] in m:
                    m[s[head]] += 1
                    if m[s[head]] > 0:
                        counter = 1
                
                if ans == "" or len(ans)>i-head:
                    ans = s[head:i]

                head += 1
                
        return ans
            