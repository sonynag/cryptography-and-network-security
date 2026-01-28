import java.util.Scanner;

public class VigenereSimple {

    static String encrypt(String text, String key) {
        String result = "";
        text = text.toUpperCase();
        key = key.toUpperCase();

        for (int i = 0; i < text.length(); i++) {
            int t = text.charAt(i) - 'A';
            int k = key.charAt(i % key.length()) - 'A';
            result += (char) ((t + k) % 26 + 'A');
        }
        return result;
    }

    static String decrypt(String text, String key) {
        String result = "";
        text = text.toUpperCase();
        key = key.toUpperCase();

        for (int i = 0; i < text.length(); i++) {
            int t = text.charAt(i) - 'A';
            int k = key.charAt(i % key.length()) - 'A';
            result += (char) ((t - k + 26) % 26 + 'A');
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.next();

        System.out.print("Enter key: ");
        String key = sc.next();

        String cipher = encrypt(text, key);
        System.out.println("Encrypted: " + cipher);

        System.out.println("Decrypted: " + decrypt(cipher, key));
    }
}
