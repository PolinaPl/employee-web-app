package ru.skypro.employeewebapp.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException() {
        super("Сотрудник не найден");
    }
}
