import java.util.*;

// Adu Oluwatoyin Stephen
// SEN/22/9261

// ---------------- Factorial ----------------
class Factorial {
    // Recursive method to calculate factorial of n
    public static long factorialRecursive(int n) {
        if (n == 0 || n == 1) return 1; // Base case: factorial of 0 or 1 is 1
        return n * factorialRecursive(n - 1); // Recursive call
    }

    // Iterative method to calculate factorial of n
    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i; // Multiply result by each number up to n
        }
        return result;
    }

    // Runs the factorial demonstration, asks user for input and prints results
    public static void run(Scanner sc) {
        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();

        System.out.println("Factorial (Iterative): " + factorialIterative(num));
        System.out.println("Factorial (Recursive): " + factorialRecursive(num));
    }
}

// ---------------- Character Frequency ----------------
class CharFrequency {
    // Reads a sentence from user and prints the frequency of each character
    public static void run(Scanner sc) {
        sc.nextLine(); // clear buffer after previous nextInt()
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        Map<Character, Integer> freq = new HashMap<>();
        // Count frequency of each character in the sentence
        for (char c : sentence.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        System.out.println("Character Frequency:");
        // Display each character and its frequency
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
        }
    }
}

// ---------------- Palindrome ----------------
class PalindromeCheck {
    // Checks if a given string is a palindrome (ignores non-alphanumeric and case)
    public static boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // Clean string
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false; // Mismatch found
            left++;
            right--;
        }
        return true; // All characters matched
    }

    // Runs the palindrome checker, asks user for input and prints result
    public static void run(Scanner sc) {
        sc.nextLine(); // clear buffer
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (isPalindrome(input)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }
    }
}

// ---------------- Book ----------------
class Book {
    private String title;
    private String author;
    private double price;

    // Constructor to initialize book details
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Displays the details of the book
    public void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }

    // Runs the book demo, asks user for book details and displays them
    public static void run(Scanner sc) {
        sc.nextLine(); // clear buffer
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter author name: ");
        String author = sc.nextLine();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        Book b = new Book(title, author, price);
        b.displayDetails();
    }
}

// ---------------- Calculator ----------------
class Calculator {
    // Adds two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Adds three integers (method overloading)
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Adds two doubles (method overloading)
    public double add(double a, double b) {
        return a + b;
    }

    // Demonstrates the overloaded add methods
    public static void run() {
        Calculator calc = new Calculator();
        System.out.println("Add 2 integers: " + calc.add(5, 10));
        System.out.println("Add 3 integers: " + calc.add(5, 10, 15));
        System.out.println("Add 2 doubles: " + calc.add(5.5, 10.3));
    }
}

// ---------------- Main Menu ----------------
public class CombinedPrograms {
    // Main method: displays menu and runs selected program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            // Display menu options
            System.out.println("\n===== MENU =====");
            System.out.println("1. Factorial (Iterative & Recursive)");
            System.out.println("2. Character Frequency Counter");
            System.out.println("3. Palindrome Checker");
            System.out.println("4. Book Class");
            System.out.println("5. Calculator (Overloaded Methods)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            // Run the selected program based on user choice
            switch (choice) {
                case 1: Factorial.run(sc); break;
                case 2: CharFrequency.run(sc); break;
                case 3: PalindromeCheck.run(sc); break;
                case 4: Book.run(sc); break;
                case 5: Calculator.run(); break;
                case 0: System.out.println("Exiting... Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        sc.close(); // Close scanner resource
    }
}
