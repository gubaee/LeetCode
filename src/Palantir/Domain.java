package Palantir;
import java.util.*;

public class Domain {

    // this doesn't work yet. a lot to fix
    public static void main(String args[]) {
        List<String> result = new ArrayList<>();
        List<String> companyDomains = new ArrayList<>();
        List<String> newDomains = new ArrayList<>();
        companyDomains.add("palantir.com");
        companyDomains.add("nic.cl");
        newDomains.add("paiantir.com");
        newDomains.add("nic.ci");
        newDomains.add("palantirtechnologies.com");
        newDomains.add("nlc.biz");
//        newDomains.add("apple.host");

        result = typosquats(companyDomains, newDomains);
    }
    public static List<String> typosquats(List<String> companyDomains, List<String> newDomains) {
        Map<String, Set<String>> domains = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for(String dom : companyDomains) {
            dom = convertToFirstLetter(dom);
            String[] split = dom.split("\\.", 2);
            if(domains.containsKey(split[0])) {
                domains.get(split[0]).add(split[1]);
            } else {
                Set<String> s = new HashSet<>();
                s.add(split[1]);
                domains.put(split[0], s);
            }
        }
        for(String dom : newDomains) {
            dom = convertToFirstLetter(dom);
            String[] split = dom.split("\\.", 2);
            if(domains.containsKey(split[0])) {
                Set<String> set = domains.get(split[0]);
                if(!set.contains(split[1])) {
                    ans.add(dom);
                }
            }
        }
        return ans;
    }
    public static String convertToFirstLetter(String dom) {
        // I <- i l ! |
        // s <- 5 $
        // o <- 0
        // a <- @
        // e <- 3
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dom.length(); i++) {
            char ch = dom.charAt(i);
            if (ch == 'i' || ch == 'l' || ch == '!' || ch == '|') {
                ch = 'I';
            }
            if (ch == '5' || ch == '$') {
                ch = 's';
            }
            if (ch == '0') {
                ch = 'o';
            }
            if (ch == '@') {
                ch = 'a';
            }
            if (ch == '3') {
                ch = 'e';
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}

