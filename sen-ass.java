import java.util.*;

//Adu Oluwatoyin Stephen
//SEN/22/9261

// ---------------- Factorial ----------------
class Factorial {
    // Recursive
    public static long factorialRecursive(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorialRecursive(n - 1);
    }

    // Iterative
    public static long factorialIterative(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void run(Scanner sc) {
        System.out.print("Enter a positive integer: ");
        int num = sc.nextInt();

        System.out.println("Factorial (Iterative): " + factorialIterative(num));
        System.out.println("Factorial (Recursive): " + factorialRecursive(num));
    }
}

// ---------------- Character Frequency ----------------
class CharFrequency {
    public static void run(Scanner sc) {
        sc.nextLine(); // clear buffer
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : sentence.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        System.out.println("Character Frequency:");
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
        }
    }
}

// ---------------- Palindrome ----------------
class PalindromeCheck {
    public static boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

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

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }

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
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public static void run() {
        Calculator calc = new Calculator();
        System.out.println("Add 2 integers: " + calc.add(5, 10));
        System.out.println("Add 3 integers: " + calc.add(5, 10, 15));
        System.out.println("Add 2 doubles: " + calc.add(5.5, 10.3));
    }
}

// ---------------- Main Menu ----------------
public class CombinedPrograms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Factorial (Iterative & Recursive)");
            System.out.println("2. Character Frequency Counter");
            System.out.println("3. Palindrome Checker");
            System.out.println("4. Book Class");
            System.out.println("5. Calculator (Overloaded Methods)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

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

        sc.close();
    }
}
