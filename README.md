SauceDemo Selenium Java Test Suite

This project is for 'Real Work Challenge' interview round.
It demonstrates end‑to‑end UI automation using Java, Selenium, and TestNG against the public demo app [Sauce Demo](https://www.saucedemo.com).

---

Tech Stack
- Language: Java 17
- Frameworks: Selenium 4, TestNG
- Pattern: Page Object Model (POM)
- Driver Management: WebDriverManager (no manual driver setup)
- Build Tool: Maven

---

Test Design
The suite covers 4 critical user flows:

1. Login
   - Valid login - navigates to Products page
   - Invalid login - shows error message
2. Product Sorting
   - Sort by price (low - high) - verifies ascending order
3. Cart & Checkout
   - Add items to cart - validates cart badge and contents
   - Complete checkout - verifies “Thank you for your order!” message
4. Logout
   - Ends session - redirects to login page

Detailed test cases are documented in 'TestCases.xlsx` doc.

