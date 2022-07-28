package String;

public class SortLowerCaseCharsInStrings {


    public static void main(String args[]){

        String s1="Test@123 Google";
        System.out.println(sortLowercaseChars(s1));

        for(int i = 0; i <= 255; i++)
        {
            System.out.println(" The ASCII value of " + (char)i + "  =  " + i);
        }

    }
    private static String sortLowercaseChars(String str) {
        int[] freq = getLowercaseCharsFreq(str);
        StringBuilder res = new StringBuilder();
        int i = 0;
        for (char ch : str.toCharArray()) {
            while (i < 26 && freq[i] == 0) i++;
            if (Character.isLowerCase(ch)) {
                res.append((char) (i + 'a'));
                freq[i]--;
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }

    private static int[] getLowercaseCharsFreq(String str) {
        int[] freq = new int[26];
        for (char ch : str.toCharArray()) {
            // a->97 ,if ch=d & d->100 then d-a=100-97=3
            if (Character.isLowerCase(ch)) freq[ch - 'a']++;
        }
        return freq;
    }
}
