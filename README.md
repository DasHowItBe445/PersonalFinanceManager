# PersonalFinanceManager
PersonalFinanceManager

PersonalFinanceManager is a user-friendly desktop application developed in Java using Swing for the front end and PostgreSQL for the backend. This mini project helps individuals easily track, manage, and analyze their income and expenses—empowering users to take control of their personal finances while ensuring data privacy and offline access.
Features

    Intuitive GUI: Simple and interactive interface for adding, viewing, and categorizing transactions.

    Expense & Income Tracking: Record and monitor all your financial transactions, including debit and credit, with detailed descriptions.

    Category Management: Create and assign categories to transactions for powerful organization and insights.

    Database Integration: Robust backend using PostgreSQL ensures reliable and persistent data storage.

    Offline Functionality: All features are available offline, securing user data locally without requiring internet access.

    Validation & Error Handling: Data validation and user-friendly error messages ensure accurate record-keeping and smooth operation.

Technologies Used

    Java (Swing)

    PostgreSQL

Getting Started

    Clone the Repository:
    git clone https://github.com/DasHowItBe445/PersonalFinanceManager.git

    Set Up PostgreSQL:

        Create the finance_manager database and necessary tables (categories, transactions).

        Update database credentials in the DatabaseConnection.java file.

    Run the Application:

        Compile and execute the Java files using your preferred Java IDE or command line.

Database Schema

    categories:

        id (SERIAL PRIMARY KEY)

        name (VARCHAR)

    transactions:

        id (SERIAL PRIMARY KEY)

        amount (NUMERIC)

        type (‘Debit’/‘Credit’)

        category_id (INTEGER, FOREIGN KEY)

        date (DATE)

        description (TEXT)

Highlights

    Real-time entry and management of financial data.

    Direct database connectivity for efficient transaction storage and retrieval.

    Full source code included for both the Java application and sample SQL queries.
