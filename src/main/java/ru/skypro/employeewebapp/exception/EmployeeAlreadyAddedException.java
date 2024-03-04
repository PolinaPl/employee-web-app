package ru.skypro.employeewebapp.exception;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException() {
        super("Cотрудник уже существует");
    }
}
