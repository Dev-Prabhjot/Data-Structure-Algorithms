package String;

import java.util.ArrayList;
import java.util.List;

public class TextJustificationHardGoogle {

    public static void main(String[] args) {

        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        fullJustify(words, 16).forEach(x -> System.out.println("\"" + x + "\""));

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {

        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int wc = words[i].length();

            int j = i + 1;
            //no of words in one line - 1 = candidates for spaces in between word
            int candidates = 0;

            while (j < words.length && wc + candidates + words[j].length() + 1 <= maxWidth) {
                //sum of all words character count in one line
                wc = wc + words[j].length();
                candidates++;
                j++;
            }


            int vacant = maxWidth - wc; //vacant spaces in one line

            //calculate spaces  per candidate

            int atleastSpaces = candidates == 0 ? 0 : vacant / candidates;
            int extraSpaces = candidates == 0 ? 0 : vacant % candidates;

            //Form formatted string per line
            StringBuilder sb = new StringBuilder();

            for (int k = i; k < j; k++) {
                //Add word
                sb.append(words[k]);
                if (k == j - 1) break;

                if (j != words.length) {
                    //if line  is not last line
                    //Add atleast spaces
                    for (int x = 0; x < atleastSpaces; x++)
                        sb.append(" ");

                    //Add extra space per candidate
                    if (extraSpaces > 0) {
                        sb.append(" ");
                        extraSpaces--;
                    }
                } else {
                    // In last line just add one space
                    sb.append(" ");
                }

            }

            // for last line= if word length is lesser than maxWidth then add spaces to right of word till maxWidth
            while (sb.length() < maxWidth) sb.append(" ");

            res.add(sb.toString());
            i = j;
        }

        return res;

    }

}
