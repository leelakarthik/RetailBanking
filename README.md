# RetailBanking

A simple RetailBanking Web Application developed using JavaServerPages along side CSS and JavaScript, with Login and Logout features.
Role based access is provided for the operations present in the page. All banking features like create customer and create Account for existing customer are provided along side 
Deposit, Withdraw, Transfer and view Statements of the account. The Account Statements can be exported to either Excel Sheet or PDF on user choice.

Roles ::

Executive ==> 
  Executive can create, update, delete a customer and can create multiple accounts for the existing customer and delete them as well.
  Executive can also view the status of accounts and customers.
  
Teller ==>
  Teller can't be able to perform Executive operations.
  Teller can perform Deposit, Withdraw, Transfer Money and Can also print Account Statement for particular Account.
  Teller can also export the Account_Transactions to Excellsheet or PDF.

Note: Executive can't perform Teller Operations and viceversa!

If you love to checkout👀 how this application looks❤
https://retailbanking-java.herokuapp.com/

Executive Id : 1234        Teller Id : 123
Password     : 123         Password  : 123
