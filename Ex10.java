package СТР194;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex10 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "a b (c) d e";
        char a = '*';
        String [] str = s.split(" ");
        StringBuffer sb = new StringBuffer();



        Pattern p = Pattern.compile("^[(].*[)]$");
        for (String string : str) {
            Matcher m = p.matcher(string);
            if(!m.matches()){
                sb.append(string);
                sb.append(" ");
            }

        }
        System.out.println(sb.toString());
    }
}