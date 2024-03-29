package String;

import java.util.HashMap;

public class ValidAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
    }

        public static boolean isAnagram(String s, String t) {
            HashMap<Character,Integer> smap=new HashMap<>();
            int sl=s.length();
            int tl=t.length();
            if(sl!=tl){return false;}
            for(int i=0;i<sl;i++){
                smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
                smap.put(t.charAt(i),smap.getOrDefault(t.charAt(i),0)-1);
            }
            for(char c:smap.keySet()){
                if(smap.get(c)!=0){return false;}
            }

            return true;
        }

}
