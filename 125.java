class Solution {

    public boolean Judge (char t) {
        if ((t >= '0' && t <= '9') || (t >= 'a' && t <= 'z')) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == ' ' || Judge(s.charAt(start))) {
                ++start;
            } else if (s.charAt(end) == ' ' || Judge(s.charAt(end))) {
                --end;
            } else {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                ++start;
                --end;
            }
        }
        return true;
    }
}