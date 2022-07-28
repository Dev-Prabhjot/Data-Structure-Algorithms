package String;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GoogleStringQuestion {

    public static void main(String args[]) {

        String AXA = "/leetcode/config";
        String BYB = "/%AXA%/interview/corner/file";
        String LCLS = "/tmp/file/usr/shared/%BYB%";


        HashMap<String, String> map = new HashMap<>();
        map.put("AXA", AXA);
        map.put("BYB", BYB);
        map.put("LCLS", LCLS);

        String Input0 = "AXA";
        System.out.println(Input0);
        System.out.println(DecodeString(Input0,map));


        String Input1 = "BYB";
        System.out.println(Input1);
        System.out.println(DecodeString(Input1,map));


        // Output: "/leetcode/config/interview/corner/file"

        String Input2 = "LCLS";
        System.out.println(Input2);
        System.out.println(DecodeString(Input2, map));
        //Output: "/tmp/file/usr/shared/leetcode/config/interview/corner/file"


    }

    public static String DecodeString(String str, HashMap<String, String> map) {
        String[] strArray =null;
        if (map.get(str)==null && str.contains("%")) {
            strArray = str.split("/");
        } else if(map.get(str)!=null){
            String keyValue = map.get(str);
          strArray = keyValue.split("/");
        }else{
            return str;
        }

        String[] strResult = new String[strArray.length];
        int i = 0;
        for (String s : strArray) {
            if (s.startsWith("%") && s.endsWith("%")) {
                String key = s.substring(1, s.length() - 1);
                if (!Objects.isNull(key) || !key.isEmpty()) {
                    strResult[i] = "" + DecodeString(map.get(key).substring(1), map);
                }
            } else {
                strResult[i] = s;
            }
            i++;
        }

        return String.join("/", strResult);
    }
}
