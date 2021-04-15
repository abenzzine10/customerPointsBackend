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

**Filtering purchases by first name of customers**

![Screen Shot 2021-04-15 at 1 13 01 AM](https://user-images.githubusercontent.com/54524081/114822966-75a82900-9d88-11eb-98cc-b4da5d791ae1.png)

**Sorting purchases by total points**

![Screen Shot 2021-04-15 at 1 13 51 AM](https://user-images.githubusercontent.com/54524081/114823223-d2a3df00-9d88-11eb-8a6c-11354faf2c57.png)

- [React CSV](https://js.coach/package/react-csv) component to export the tables as ".csv" files.

**Exporting a ".csv" file of the customers and their points**

![Screen Shot 2021-04-15 at 1 15 16 AM](https://user-images.githubusercontent.com/54524081/114823304-f2d39e00-9d88-11eb-9b24-7777e0a73fa7.png)

- [React Router](https://reactrouter.com/) links to the points and purchases tables.

## Things to improve
- Add authentication and tokenization to secure the API
- Add more endpoints to API
- Improve the UI (filtering and sorting)

## Author
Ayoub Benzzine
