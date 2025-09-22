import datetime

class Transaction:
    """Represents a single income or expense entry."""
    def __init__(self, amount, category, t_type, description=""):
        # Store transaction details
        self.amount = amount
        self.category = category
        self.t_type = t_type  # 'income' or 'expense'
        self.description = description
        self.date = datetime.datetime.now()  # Timestamp of transaction

    def __str__(self):
        # Nicely formatted string for displaying transaction info
        return f"{self.date:%Y-%m-%d %H:%M:%S} | {self.t_type.title():7} | {self.category:12} | {self.amount:8.2f} | {self.description}"

class IncomeExpenditureMonitor:
    """Manages all transactions and provides summary functions."""
    def __init__(self):
        self.transactions = []  # List to store all transactions

    def add(self, amount, category, t_type, description=""):
        # Add a new transaction; expenses are stored as negative amounts
        amt = amount if t_type == 'income' else -amount
        self.transactions.append(Transaction(amt, category, t_type, description))

    def get_balance(self):
        # Calculate the current balance by summing all transaction amounts
        return sum(t.amount for t in self.transactions)

    def show_history(self):
        # Print all transactions and the current balance
        print("\nDate & Time           | Type    | Category     | Amount    | Description")
        print("-" * 70)
        for t in self.transactions: print(t)
        print("-" * 70)
        print(f"Current Balance: {self.get_balance():.2f}\n")

def main():
    monitor = IncomeExpenditureMonitor()
    menu = ("\nIncome & Expenditure Monitoring System\n"
            "1. Add Income\n2. Add Expense\n3. Show Transaction History\n4. Show Balance\n5. Exit")
    while True:
        print(menu)
        choice = input("Select an option: ")
        if choice in ('1', '2'):
            # Prompt user for transaction details
            amount = float(input(f"Enter {'income' if choice=='1' else 'expense'} amount: "))
            category = input(f"Enter {'income' if choice=='1' else 'expense'} category: ")
            desc = input("Description (optional): ")
            monitor.add(amount, category, 'income' if choice=='1' else 'expense', desc)
            print(f"{'Income' if choice=='1' else 'Expense'} added.")
        elif choice == '3':
            monitor.show_history()
        elif choice == '4':
            print(f"Current Balance: {monitor.get_balance():.2f}")
        elif choice == '5':
            print("Exiting. Goodbye!")
            break
        else:
            print("Invalid option. Try again.")