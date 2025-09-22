import java.util.*;

class Factorial {
    static long rec(int n) { return (n < 2) ? 1 : n * rec(n - 1); }
    static long iter(int n) { long r = 1; for (int i = 2; i <= n; i++) r *= i; return r; }
    static void run(Scanner sc) {
        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();
        System.out.println("Factorial (Iterative): " + iter(n));
        System.out.println("Factorial (Recursive): " + rec(n));
    }
}

class CharFrequency {
    static void run(Scanner sc) {
        sc.nextLine();
        System.out.print("Enter a sentence: ");
        String s = sc.nextLine();
        Map<Character, Integer> f = new HashMap<>();
        for (char c : s.toCharArray()) f.put(c, f.getOrDefault(c, 0) + 1);
        f.forEach((k, v) -> System.out.println("'" + k + "' : " + v));
    }
}

class PalindromeCheck {
    static boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return new StringBuilder(s).reverse().toString().equals(s);
    }
    static void run(Scanner sc) {
        sc.nextLine();
        System.out.print("Enter a string: ");
        String in = sc.nextLine();
        System.out.println(isPalindrome(in) ? "The string is a palindrome." : "The string is NOT a palindrome.");
    }
}

class Book {
    String title, author; double price;
    Book(String t, String a, double p) { title = t; author = a; price = p; }
    void display() {
        System.out.println("Book Title: " + title + "\nAuthor: " + author + "\nPrice: $" + price);
    }
    static void run(Scanner sc) {
        sc.nextLine();
        System.out.print("Enter book title: "); String t = sc.nextLine();
        System.out.print("Enter author name: "); String a = sc.nextLine();
        System.out.print("Enter price: "); double p = sc.nextDouble();
        new Book(t, a, p).display();
    }
}

class Calculator {
    int add(int a, int b) { return a + b; }
    int add(int a, int b, int c) { return a + b + c; }
    double add(double a, double b) { return a + b; }
    static void run() {
        Calculator c = new Calculator();
        System.out.println("Add 2 integers: " + c.add(5, 10));
        System.out.println("Add 3 integers: " + c.add(5, 10, 15));
        System.out.println("Add 2 doubles: " + c.add(5.5, 10.3));
    }
}

public class CombinedPrograms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println("\n===== MENU =====\n1. Factorial\n2. Char Frequency\n3. Palindrome\n4. Book\n5. Calculator\n0. Exit");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1: Factorial.run(sc); break;
                case 2: CharFrequency.run(sc); break;
                case 3: PalindromeCheck.run(sc); break;
                case 4: Book.run(sc); break;
                case 5: Calculator.run(); break;
                case 0: System.out.println("Exiting... Goodbye!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (ch != 0);
        sc.close();
    }
}
