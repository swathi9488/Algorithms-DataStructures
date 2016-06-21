public class Main {

    public static void main(String[] args) {
        String str1 = "paks";
        String str2 = "peaks";
        int len1 = str1.length();
        int len2 = str2.length();
        int edit = 0;

        // Case: Add/ Delete
        if (Math.abs(len1 - len2) == 1) {
            boolean incStr1 = false;
            boolean incStr2 = false;
            int count;
            if (len1 > len2) {
                incStr1 = true;
                count = len1;
            } else {
                incStr2 = true;
                count = len2;
            }
            int p1 = 0, p2 = 0;
            for (int i = 0; i < count; i++) {
                // if string 1 is the bigger one and you have gone past the last index in the smaller one
                if (incStr1 && p2 == len2) {
                    edit++;
                    break;
                }

                // if string 2 is the bigger one and you have gone past the last index in the smaller one
                if (incStr2 && p1 == len1) {
                    edit++;
                    break;
                }

                if (str1.charAt(p1) != str2.charAt(p2)) {
                    if (incStr1) {
                        p1++;
                    } else {
                        p2++;
                    }

                    edit++;
                    if (edit > 1) {
                       break;
                    }
                } else {
                    p1++;
                    p2++;
                }
            }

        } else if (len1 == len2) { // Case update
            for (int i = 0; i < len1; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    edit++;
                    if (edit > 1) {
                        break;
                    }
                }
            }
        }

        if (edit != 1) {
            System.out.print("Not at one edit distance");
        } else {
            System.out.print("At one edit distance");
        }
    }
}
