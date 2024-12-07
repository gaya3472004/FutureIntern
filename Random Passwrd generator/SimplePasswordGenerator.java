import java.security.SecureRandom;

import java.util.Scanner;

public class SimplePasswordGenerator {

    // Define character sets for password
    private static final String lowcase = "abcdefghijklmnopqrstuvwxyz";
    private static final String upcase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String nums = "0123456789";
    private static final String symbols = "!@#$%^&*()-_=+[]{}|;:,.<>?/~`";

    // Method to generate a random password based on selected character types
    public static String generatePassword(int length, boolean useLowercase, boolean useUppercase, boolean useNumbers, boolean useSymbols) {
        StringBuilder allCharacters = new StringBuilder();

        // Add selected character sets to the allCharacters string
        if (useLowercase) allCharacters.append(lowcase);
        if (useUppercase) allCharacters.append(upcase);
        if (useNumbers) allCharacters.append(nums);
        if (useSymbols) allCharacters.append(symbols);

        // If no character types are selected, return an error message
        if (allCharacters.length() == 0) {
            return "Error: No character types selected!";
        }

        // Secure random number generator
        SecureRandom random = new SecureRandom();

        // StringBuilder to build the password
        StringBuilder password = new StringBuilder(length);

        // Generate the password
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allCharacters.length());
            password.append(allCharacters.charAt(index));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired password length: ");
        int passwordLength = scanner.nextInt();

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean useLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean useUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include numbers? (yes/no): ");
        boolean useNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special symbols? (yes/no): ");
        boolean useSymbols = scanner.next().equalsIgnoreCase("yes");
    
        String password = generatePassword(passwordLength, useLowercase, useUppercase, useNumbers, useSymbols);
        System.out.println("Generated Password: " + password);
    }
}
