class Solution {
    public String removeKdigits(String num, int k) {
        
        StringBuilder sb = new StringBuilder();
        
        for (char c : num.toCharArray()) {
            
            while (k > 0 && sb.length() > 0 && 
                   sb.charAt(sb.length() - 1) > c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            
            sb.append(c);
        }
        
        while (k > 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        
        int index = 0;
        while (index < sb.length() && sb.charAt(index) == '0') {
            index++;
        }
        
        String result = sb.substring(index);
        
        return result.isEmpty() ? "0" : result;
    }
}
