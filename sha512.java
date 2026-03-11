import java.security.MessageDigest;
import java.util.Scanner;

public class SHA512 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the message: ");
            String message = sc.nextLine();

            // Create SHA-512 instance
            MessageDigest md = MessageDigest.getInstance("SHA-512");

            // Generate hash
            byte[] hash = md.digest(message.getBytes());

            // Convert to hexadecimal
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }

            System.out.println("SHA-512 Hash: " + hex.toString());

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}