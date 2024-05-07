package ru.skypro.employeewebapp.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.skypro.employeewebapp.exception.InvalidEmployeeDataException;
import ru.skypro.employeewebapp.service.EmoloyeeValidationService;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeValidationServiceIml implements EmoloyeeValidationService {
    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);
    }

    private void validateName(String name) {
        if (isAlpha(name)) {
            throw new InvalidEmployeeDataException("Некоррктное имя сотрудника");
        }
    }
}
