package ru.geekbrains.spring_demo_core_lib.exceptions;

import lombok.Data;

import java.util.Map;

public class ProjectFormError extends ProjectError {
    private Map<String, String> errors;

    public ProjectFormError(int status, String message, Map<String, String> errors) {
        super(status, message);
        this.errors = errors;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
