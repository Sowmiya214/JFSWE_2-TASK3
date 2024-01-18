package com.java.JFSWE_2.Task3;

import java.util.Scanner;

public interface Taxable {
	double SALES_TAX_RATE = 0.07;
	double INCOME_TAX_RATE = 0.105;

	double calcTax();

	class Employee implements Taxable {
		private int empId;
		private String name;
		private double salary;

		// Parameterized constructor for Employee class
		public Employee(int empId, String name, double salary) {
			this.empId = empId;
			this.name = name;
			this.salary = salary;
		}

		// Implementing the calcTax method for income tax calculation
		@Override
		public double calcTax() {
			return salary * INCOME_TAX_RATE;
		}
	}

	class Product implements Taxable {
		private int pid;
		private double price;
		private int quantity;

		// Parameterized constructor for Product class
		public Product(int pid, double price, int quantity) {
			this.pid = pid;
			this.price = price;
			this.quantity = quantity;
		}

		// Implementing the calcTax method for sales tax calculation
		@Override
		public double calcTax() {
			return price * SALES_TAX_RATE * quantity;
		}
	}

	static class XYZ {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);

			// Accept employee information
			System.out.println("Enter Employee Information:");
			System.out.print("Employee ID: ");
			int empId = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character
			System.out.print("Employee Name: ");
			String empName = scanner.nextLine();
			System.out.print("Salary: ");
			double empSalary = scanner.nextDouble();

			// Create Employee object
			Employee employee = new Employee(empId, empName, empSalary);

			// Calculate and print income tax for the employee
			System.out.println("\nIncome Tax Calculation:");
			System.out.println("Income Tax: $" + employee.calcTax());

			// Accept product information
			System.out.println("\nEnter Product Information:");
			System.out.print("Product ID: ");
			int productId = scanner.nextInt();
			System.out.print("Unit Price: ");
			double unitPrice = scanner.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = scanner.nextInt();

			// Create Product object
			Product product = new Product(productId, unitPrice, productQuantity);

			// Calculate and print sales tax for the product
			System.out.println("\nSales Tax Calculation:");
			System.out.println("Sales Tax: $" + product.calcTax());

			scanner.close();
		}
	}
}
