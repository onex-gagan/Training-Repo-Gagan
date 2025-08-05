import logging

# Setup logging
logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s - %(levelname)s - %(message)s"
)


def parse_transactions(raw_data):
    transactions = []
    for record in raw_data:
        parts = record.split(",")
        if len(parts) < 4:
            logging.warning(f"Skipping invalid record: {record}")
            continue

        try:
            transaction = {
                "date": parts[0].strip(),
                "amount": float(parts[1].strip()),
                "type": parts[2].strip().lower(),
                "description": ",".join(parts[3:]).strip()  # Handles commas in description
            }
            transactions.append(transaction)
        except ValueError as e:
            logging.error(f"Failed to parse record: {record} - Error: {e}")
    logging.info(f"Parsed {len(transactions)} valid transactions.")
    return transactions


def calculate_balance(transactions):
    balance = 0
    for txn in transactions:
        if txn["type"] == "credit":
            balance += txn["amount"]
        elif txn["type"] == "debit":
            balance -= txn["amount"]
        else:
            logging.warning(f"Unknown transaction type: {txn['type']}")
    logging.info(f"Calculated balance: {balance}")
    return round(balance, 2)


def generate_summary(transactions):
    credit_txns = [t for t in transactions if t["type"] == "credit"]
    debit_txns = [t for t in transactions if t["type"] == "debit"]

    average_credit = (
        sum(t["amount"] for t in credit_txns) / len(credit_txns)
        if credit_txns else 0
    )

    summary = {
        "credits": len(credit_txns),
        "debits": len(debit_txns),
        "average_credit": round(average_credit, 2),
        "largest_txn": max(transactions, key=lambda t: t["amount"], default=None)
    }

    logging.info("Generated summary.")
    return summary


def main():
    raw_data = [
        "2025-07-01, 1200, CREDIT, Salary",
        "2025-07-02, 300, debit, Grocery",
        "2025-07-03, 500, debit, Restaurant",
        "2025-07-04, 200, DEBIT, Internet Bills",
        "2025-07-05, 400, credit, Freelance, Bonus"  # Has comma in description
    ]

    logging.info("Starting transaction processing...")
    transactions = parse_transactions(raw_data)

    if not transactions:
        logging.error("No valid transactions to process.")
        return

    balance = calculate_balance(transactions)
    summary = generate_summary(transactions)

    print("\nFinal Balance:", balance)
    print("Summary:")
    print("Credits:", summary["credits"])
    print("Debits:", summary["debits"])
    print("Avg Credit:", summary["average_credit"])

    largest = summary["largest_txn"]
    if largest:
        print("Largest Txn:", largest["description"], "-", largest["amount"])
    else:
        print("No transactions found for largest transaction.")

    logging.info("Transaction processing complete.")


main()