package com.dsa.arraysandhasing;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public static void main(String[] args) {

    }
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(transformEmail(email));
        }
        return set.size();
    }

    public String transformEmail(String email) {
        int ind = email.indexOf('@');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (c == '@' || c == '+') {
                break;
            }
            if (c != '.') sb.append(c);
        }
        sb.append(email.substring(ind));
        return sb.toString();
    }
    // public int numUniqueEmails(String[] emails) {
    //     HashSet<String> set = new HashSet<>();
    //     for(String email:emails){
    //     String[] sp = email.split("@");
    //     String[] localName = sp[0].split("\\+");
    //     String domainName = sp[1];
    //     set.add(localName[0].replaceAll("\\.","") + "@" + domainName);
    //     }
    //     return set.size();
    // }

}
