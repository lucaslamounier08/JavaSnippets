package com.lucaslamounier.java15;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SealedClassesTest {

    // goal of sealed classes is to allow individual classes to declare which types may be used as subtypes.
    // This also applies to interfaces and determining which types can implement them.
    public abstract sealed class Person permits Employee, Manager {
    }

    @Getter
    @AllArgsConstructor
    public final class Employee extends Person {
        private Long employeeId;
    }

    @Getter
    @AllArgsConstructor
    public non-sealed class Manager extends Person {
        private Long supervisorId;
    }

    @Test
    void givenPerson_ShouldBeAbleToCastCorrectly() {
        // Employee
        Person person = new Employee(1L);

        Long id = getEmplyeeOrManagerID(person);

        assertThat(id).isEqualTo(1L);

        // Manager
        person = new Manager(3L);

        id = getEmplyeeOrManagerID(person);

        assertThat(id).isEqualTo(3L);
    }

    private Long getEmplyeeOrManagerID(Person person) {
        Long id = 0L;

        if (person instanceof Employee) {
            id = ((Employee) person).getEmployeeId();
        } else if (person instanceof Manager) {
            id = ((Manager) person).getSupervisorId();
        }
        return id;
    }
}
