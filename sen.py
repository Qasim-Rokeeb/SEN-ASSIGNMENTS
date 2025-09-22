import datetime

# Transaction class represents a single income or expense entry
class Transaction:
    def __init__(self, amount, category, t_type, description=""):
        # amount: float, positive for income, negative for expense
        self.amount = amount
        # category: string, e.g., 'Salary', 'Food', etc.
        self.category = category
        # t_type: string, either 'income' or 'expense'
        self.t_type = t_type  # 'income' or 'expense'
        # description: optional string for extra details
        self.description = description
        # date: timestamp when the transaction is created
        self.date = datetime.datetime.now()

    def __str__(self):
        # Returns a formatted string for displaying the transaction
        return f"{self.date.strftime('%Y-%m-%d %H:%M:%S')} | {self.t_type.title():7} | {self.category:12} | {self.amount:8.2f} | {self.description}"

# IncomeExpenditureMonitor manages all transactions and provides summary functions
class IncomeExpenditureMonitor:
    def __init__(self):
        # List to store all Transaction objects
        self.transactions = []

    def add_income(self, amount, category, description=""):
        # Adds an income transaction (amount should be positive)
        self.transactions.append(Transaction(amount, category, 'income', description))

    def add_expense(self, amount, category, description=""):
        # Adds an expense transaction (amount is stored as negative)
        self.transactions.append(Transaction(-amount, category, 'expense', description))

    def get_balance(self):
        # Calculates the current balance by summing all transaction amounts
        return sum(t.amount for t in self.transactions)

    def show_history(self):
        # Prints a formatted table of all transactions and the current balance
        print("\nDate & Time           | Type    | Category     | Amount    | Description")
        print("-" * 70)
        for t in self.transactions:
            print(t)
        print("-" * 70)
        print(f"Current Balance: {self.get_balance():.2f}\n")

# Main function provides a simple command-line interface for the user
def main():
    monitor = IncomeExpenditureMonitor()
    while True:
        print("\nIncome & Expenditure Monitoring System")
        print("1. Add Income")
        print("2. Add Expense")
        print("3. Show Transaction History")
        print("4. Show Balance")
        print("5. Exit")
        choice = input("Select an option: ")

        if choice == '1':
            # Prompt user for income details and add to monitor
            amount = float(input("Enter income amount: "))
            category = input("Enter income category: ")
            desc = input("Description (optional): ")
            monitor.add_income(amount, category, desc)
            print("Income added.")
        elif choice == '2':
            # Prompt user for expense details and add to monitor
            amount = float(input("Enter expense amount: "))
            category = input("Enter expense category: ")
            desc = input("Description (optional): ")
            monitor.add_expense(amount, category, desc)
            print("Expense added.")
        elif choice == '3':
            # Display all transactions and current balance
            monitor.show_history()
        elif choice == '4':
            # Display current balance only
            print(f"Current Balance: {monitor.get_balance():.2f}")
        elif choice == '5':
            # Exit the program
            print("Exiting. Goodbye!")
            break
        else:
            # Handle invalid menu option
            print("Invalid option. Try again.")