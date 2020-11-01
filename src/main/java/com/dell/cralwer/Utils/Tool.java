package com.dell.cralwer.Utils;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tool {
    public static List<String> getAllFileTail(String fatherUrl){
        List<String> result = new ArrayList<>();
        for (File file : Objects.requireNonNull(new File(fatherUrl).listFiles())) {
            String fileName = file.toString().substring(file.toString().lastIndexOf("\\") + 1);
            result.add(fileName);
        }
        result.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                String re1 = null;
                String re2 = null;
                Matcher m = Pattern.compile(".*?(\\d+)").matcher(s);
                while (m.find()) {
                    re1 = m.group(1);
                }
                Matcher m2 = Pattern.compile(".*?(\\d+)").matcher(t1);
                while (m2.find()) {
                    re2 = m2.group(1);
                }
                assert re1 != null;
                assert re2 != null;
                return Integer.compare(Integer.parseInt(re1),Integer.parseInt(re2));
            }
        });
        return result;
    }
}
