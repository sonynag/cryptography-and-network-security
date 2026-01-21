import java.util.*;

class PlayfairCipher {
    static char[][] m = new char[5][5];

    static void keyMatrix(String key) {
        key = key.toUpperCase().replace("J","I");
        boolean[] used = new boolean[26];
        int k = 0;

        for (char c : key.toCharArray())
            if (!used[c-'A'] && c!='J') {
                m[k/5][k%5] = c;
                used[c-'A'] = true;
                k++;
            }

        for (char c = 'A'; c <= 'Z'; c++)
            if (!used[c-'A'] && c!='J') {
                m[k/5][k%5] = c;
                k++;
            }
    }

    static String encrypt(String text) {
        text = text.toUpperCase().replace("J","I");
        if (text.length() % 2 != 0) text += "X";
        String c = "";

        for (int i = 0; i < text.length(); i += 2) {
            int r1=0,c1=0,r2=0,c2=0;
            for (int r=0;r<5;r++)
                for (int col=0;col<5;col++) {
                    if (m[r][col]==text.charAt(i)) {r1=r;c1=col;}
                    if (m[r][col]==text.charAt(i+1)) {r2=r;c2=col;}
                }

            if (r1==r2) {
                c += m[r1][(c1+1)%5];
                c += m[r2][(c2+1)%5];
            } else if (c1==c2) {
                c += m[(r1+1)%5][c1];
                c += m[(r2+1)%5][c2];
            } else {
                c += m[r1][c2];
                c += m[r2][c1];
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Key: ");
        keyMatrix(sc.next());
        System.out.print("Text: ");
        System.out.println("Cipher: " + encrypt(sc.next()));