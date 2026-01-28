import java.util.Scanner;

public class vignerecipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Text: ");
        String text = sc.next().toUpperCase();

        System.out.print("Key: ");
        String key = sc.next().toUpperCase();

        String cipher = "", plain = "";

        for (int i = 0; i < text.length(); i++) {
            int t = text.charAt(i) - 'A';
            int k = key.charAt(i % key.length()) - 'A';
            cipher += (char) ((t + k) % 26 + 'A');          
            plain += (char) ((t - k + 26) % 26 + 'A');     
        }

        System.out.println("Encrypted: " + cipher);
        System.out.println("Decrypted: " + plain);

        sc.close();
    }
}
