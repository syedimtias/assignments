# Project Title

Retail Store Discount

# Project Requirements

On a retail website, the following discounts apply:
1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.
Write a program in a programming language of your choice with test cases such that given a
bill, it finds the net payable amount. Please note the stress is on object oriented approach
and test coverage. User interface is not required.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

JDK1.8, Maven, git, IDE (optional)

```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
cd <work-directory>

git clone https://github.com/syedimtias/assignments.git

cd RetailStoreDiscount

```

It is ready to open in any IDE or editor for review. To build run the below command

```
mvn clean install

```

## Running the tests

```
mvn test

```

## Generate coverage report

Recommended: If using eclipse then right click on the test class and select 'Coverage As -> Junit Test' option. It will show you the report.

from command line, execute below command. Success of the below command is based on POMs dependencies. Below command is not fully tested with this project. Recommend to use eclipse.

```
mvn test site

```

## Built With


* [Maven](https://maven.apache.org/) - Dependency Management


## Authors

* **Imtiaz Basha Syed**

