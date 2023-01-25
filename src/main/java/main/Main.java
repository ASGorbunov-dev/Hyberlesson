package main;

import model.Employee;
import service.EmployeeService;

import java.util.Scanner;

public class Main {
    static EmployeeService employeeService = new EmployeeService();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
        }
    }

    public static void showAllEmployee() {
        employeeService.getAllEmployees().stream().forEach(System.out::println);
        System.out.println("");
    }

    public static void showEmployeeById() {
        System.out.println("Введите id сотрудника:");
        String idNumber = scanner.nextLine();
        Employee employee = employeeService.getById(Long.parseLong(idNumber));
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Не найдено сотрудника с таким id!");
        }
    }

    public static void deleteEmployee() {
        System.out.println("Введите id сотрудника:");
        Employee employee = employeeService.getById(scanner.nextLong());
        employeeService.deleteEmployee(employee);
    }

    public static void addEmployee() {
        Employee employee = new Employee();
        System.out.println("Введите Фамилию сотрудника:");
        employee.setSurName(scanner.nextLine());
        System.out.println("Введите Имя сотрудника:");
        employee.setName(scanner.nextLine());
        System.out.println("Введите Отчество сотрудника:");
        employee.setMidleName(scanner.nextLine());
        System.out.println("Введите зар.плату сотрудника:");
        employee.setSalary(scanner.nextInt());
        System.out.println("Введите должность сотрудника");
        employee.setPosition(scanner.nextLine());
        employee.setActive(true);
        employeeService.addEmployee(employee);
    }

    public static void showMenu() {
        System.out.println("Меню работы с БД:Сотрудники" + System.lineSeparator()
                + "1.Вывести список всех сотрудников" + System.lineSeparator()
                + "2.Добавить сотрудника" + System.lineSeparator()
                + "3.Удалить сотрудника" + System.lineSeparator()
                + "4.Вывести сотрудника по id" + System.lineSeparator());
        String number = scanner.nextLine();
        try {
            int chose = Integer.parseInt(number);
            switch (chose) {
                case 1:
                    showAllEmployee();
                    break;
                case 2:
                    addEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    showEmployeeById();
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Не верно введено число!");
        }
    }
// заменить if on switch case.
}
