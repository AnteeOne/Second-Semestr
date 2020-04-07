package IT.HW12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public static void run(){
        String regex1 = "^(http|https)://[a-z0-9.-]{4,64}$";
        Pattern pattern = Pattern.compile(regex1);
        System.out.println(pattern.matcher("https://ruby.com").matches());
        System.out.println(pattern.matcher("https://r.u.b.y.com").matches());
        String regex2 = "([a-z0-9-]+).([a-z0-9-]+$)";
        Matcher matcher1 = Pattern.compile(regex2).matcher("d.ddddds@sfsdfs.sdfsd.mii.com");
        Matcher matcher2 = Pattern.compile(regex2).matcher("azat@mymail.anime");
        matcher1.find();
        matcher2.find();
        System.out.println(matcher1.group());
        System.out.println(matcher2.group());


    }
}
