class Solution:
    def fn(self, s: str, c: str) -> str:
        s1 = ""
        s2 = ""
        mp = [0] * 26
        for i in range(len(s)):
            if c == s[i] and mp[ord(s[i]) - ord('a')] == 0:
                s1 = s[:i + 1]
                s2 = s[i + 1:]
                mp[ord(s[i]) - ord('a')] = 1
        s1 = s1[::-1]
        return s1 + s2
            
    def reversePrefix(self, word: str, ch: str) -> str:
        if ch in word:
            return self.fn(word, ch)
        return word
