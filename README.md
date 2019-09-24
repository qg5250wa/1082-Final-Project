# 1082-Final-Project: Employee Rewards System
## Contributors
Jonathan Villa
Kesler Jensrud
## Project goal
Create a program which ranks retail employees based on a number of factors, including:
* Number of transactions completed/started but left incomplete
* Number of rewards and credit accounts opened
* Random reviews from other employees
* (Tentative idea): Random manager checkups
## Classes to be implemented
* Main class
  * Handles the main functions of the program, calls the rest of the parts
* Ranking Board
  * Handles storing the data for each individual employee.
* Customer
  * Submits reviews that factor into the employees' rankings
* Employee
  * Stores ranking points for each employee
## User input/output
The user will take the role of one or many customers filling out reviews detailing how their transaction went. Each review will be done in a multiple-choice format, providing questions based on some of the factors above in the Project Goal section. After each review, the ranking board will be shown. Randomly, other employees will submit reviews that affect the overall scores. Also randomly, a manager might randomly oversee a transaction and manipulate the rankings a bit.

Another system that may be implemented is the ability to show randomly-generated synopses of a transaction to the user before they fill out their review. These transaction synopses may be tailored to the predetermined personalities of each employee and may omit details that the user doesn't think about until the review asks them about it (for example, if the employee never offered a rewards account, it's possible the customer doesn't know about it until the review). This has the possibility to add human error the ranking system, making it more interesting.
