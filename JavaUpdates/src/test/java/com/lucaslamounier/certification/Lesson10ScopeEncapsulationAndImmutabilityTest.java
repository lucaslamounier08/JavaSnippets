package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

@Slf4j
class Lesson10ScopeEncapsulationAndImmutabilityTest {

    @Test
    void lesson10ScopeEncapsulationAndImmutabilityTest() {
        // 10.1

        Predicate<String> ps = x -> true;
        Predicate<String> ps2 = x -> true;

        int x = 99;
        //Predicate<String> ps3 = x -> true;

        {
            int x2 = 99;
            {
                int y = 100, x3 = 10;
            }
        }

        {
            int x2 = 99;
            class Y {
                int y = 100, x2 = 10;
            }
        }

        // 10.2 - access control modifiers
        // one of: private, default (accessible anywhere in same package),
        // protected (also in same package PLUS in subclasses), and public -
        // public on module system - accessible anywhere withing the same module

        // 10.3 - encapsulation requirements
        // encapsulação - proteger atributos da classe de acesso externo - private

        // 10.4 - immutability
        // imutabilidade: mudanças no objeto precisam criar outro objeto
    }

}
