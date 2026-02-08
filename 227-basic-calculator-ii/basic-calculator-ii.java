class Solution {
    public int calculate(String s) {
        int num = 0;
        char sign = '+';
        int result = 0;
        int last = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {

                if (sign == '+') {
                    result += last;
                    last = num;
                } else if (sign == '-') {
                    result += last;
                    last = -num;
                } else if (sign == '*') {
                    last = last * num;
                } else if (sign == '/') {
                    last = last / num;
                }

                sign = c;
                num = 0;
            }
        }

        result += last;
        return result;
    }
}
