# Customer Points

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Given a record of every transaction during a three-month period, calculate the reward points earned for each customer per month and total.

Check out this demo UI [here](https://customer-points-frontend.herokuapp.com/).

## Backend

Github repository: [https://github.com/abenzzine10/customerPointsBackend](https://github.com/abenzzine10/customerPointsBackend)

Used **Spring Boot**.

A dataset of 20 customers and 100 purchases of random amounts was created as a demo in an H2 database. The purchases are recorded in the three-month period from 01/01/2021 to 03/31/2021.

There are two API endpoints:
- customers endpoint: [https://customer-points-backend.herokuapp.com/customers](https://customer-points-backend.herokuapp.com/customers)
- purchases endpoint: [https://customer-points-backend.herokuapp.com/purchases](https://customer-points-backend.herokuapp.com/purchases)

## Frontend

Github repository: [https://github.com/abenzzine10/customerPointsFrontend](https://github.com/abenzzine10/customerPointsFrontend)

Used **ReactJS**.

Demo UI: [https://customer-points-frontend.herokuapp.com/](https://customer-points-frontend.herokuapp.com/)

Use the package manager [npm](https://www.npmjs.com/get-npm/) to install the app.

```bash
npm install
```

### Dependencies
- [React Table](https://js.coach/package/react-table) component to create the table of customers and purchases with sorting, filtering, and pagination.
- [React CSV](https://js.coach/package/react-csv) component to export the tables as ".csv" files.

## Author
Ayoub Benzzine
