package com.lucaslamounier.java15;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PatternMatchingTypeChecksTest {

    public abstract sealed class Person permits Employee, Manager {
    }

    @Getter
    @AllArgsConstructor
    public final class Employee extends Person {
        private int yearsOfService;
    }

    @Getter
    @AllArgsConstructor
    public non-sealed class Manager extends Person {
        private int yearsOfLeadership;
    }

    @Test
    void test() {
        // employee
        Person person = new Employee(9);
        boolean employeeShouldBePromoted = personShouldBePromoted(person);
        assertTrue(employeeShouldBePromoted);

        // manager
        person = new Manager(9);
        boolean managerShouldBePromoted = personShouldBePromoted(person);
        assertTrue(managerShouldBePromoted);
    }

    private boolean personShouldBePromoted(Person person) {
        if (person instanceof Employee employee && employee.getYearsOfService() > 5) {
            return true;
        } else return person instanceof Manager manager && manager.getYearsOfLeadership() > 5;
    }
}
