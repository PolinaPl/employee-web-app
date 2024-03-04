package ru.skypro.employeewebapp.exception;

public class EmployeeStoragelsFullException extends RuntimeException{
    public EmployeeStoragelsFullException() {
        super("Хранилище сотрудников заполнено");
    }
}
