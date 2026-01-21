import java.util.Scanner;

public class VernamCipher {

    // Encrypt or Decrypt using XOR
    static String vernamCipher(String text, String key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char t = text.charAt(i);
            char k = key.charAt(i);

            char cipherChar = (char) (t ^ k);
            result.append(cipherChar);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Plain Text: ");
        String plaintext = sc.nextLine();

        System.out.print("Enter Key (same length as text): ");
        String key = sc.nextLine();

        if (plaintext.length() != key.length()) {
            System.out.println("Error: Key length must be equal to text length.");
            return;
        }

        String cipherText = vernamCipher(plaintext, key);
        String decryptedText = vernamCipher(cipherText, key);

        System.out.println("\nEncrypted Text: " + cipherText);
        System.out.println("Decrypted Text: " + decryptedText);

        sc.close();
    }
}