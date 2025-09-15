import datetime

class Transaction:
    def __init__(self, amount, category, t_type, description=""):
        self.amount = amount
        self.category = category
        self.t_type = t_type  # 'income' or 'expense'
        self.description = description
        self.date = datetime.datetime.now()

    def __str__(self):
        return f"{self.date.strftime('%Y-%m-%d %H:%M:%S')} | {self.t_type.title():7} | {self.category:12} | {self.amount:8.2f} | {self.description}"

class IncomeExpenditureMonitor:
    def __init__(self):
        self.transactions = []

    def add_income(self, amount, category, description=""):
        self.transactions.append(Transaction(amount, category, 'income', description))
    def add_expense(self, amount, category, description=""):
        self.transactions.append(Transaction(-amount, category, 'expense', description))

    def get_balance(self):
        return sum(t.amount for t in self.transactions)

    def show_history(self):
        print("\nDate & Time           | Type    | Category     | Amount    | Description")
        print("-" * 70)
        for t in self.transactions:
            print(t)
        print("-" * 70)
        print(f"Current Balance: {self.get_balance():.2f}\n")

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
            amount = float(input("Enter income amount: "))
            category = input("Enter income category: ")
            desc = input("Description (optional): ")
            monitor.add_income(amount, category, desc)
            print("Income added.")
        elif choice == '2':
            amount = float(input("Enter expense amount: "))
            category = input("Enter expense category: ")
            desc = input("Description (optional): ")
            monitor.add_expense(amount, category, desc)
            print("Expense added.")
        elif choice == '3':
            monitor.show_history()
        elif choice == '4':
            print(f"Current Balance: {monitor.get_balance():.2f}")
        elif choice == '5':
            print("Exiting. Goodbye!")
            break
        else:
            print("Invalid option. Try again.")