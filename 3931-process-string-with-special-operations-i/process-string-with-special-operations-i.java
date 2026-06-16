class Solution {
    public String processStr(String s) {
        StringBuilder str = new StringBuilder();

        for(char ch : s.toCharArray()) {
            if(ch >= 'a' && ch <= 'z') {
                str.append(ch);
            }
            if (ch == '*') {
               if(!str.isEmpty()) {
                    str.deleteCharAt(str.length() - 1);
               }
            }
            if(ch == '#') {
                str.append(str);
            }
            if(ch == '%') {
                str = str.reverse();
            }
        }
        return str.toString();
    }
}