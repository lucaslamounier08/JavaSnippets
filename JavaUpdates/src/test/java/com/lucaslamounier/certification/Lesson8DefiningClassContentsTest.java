package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
class Lesson8DefiningClassContentsTest {

    // NOT VALID BECAUSE FINAL MUST BE ALWAYS INITIALIZED
    // OR INITIALIZED WITH STATIC METHOD
    //final static public @Deprecated List<String> le;
    final static public @Deprecated List<String> le = new ArrayList<>();
    final static public @Deprecated List<String> le2;

    static {
        le2 = new ArrayList<>();
    }

    @Test
    void lesson8DefiningClassContentsTest() {
        // 8.1
        // <modifiers> <type> [initialization]
        // modifiers: public/protected/private; static, final, transient, volatile

        // arrays have two declarations
        int[] ia;
        int iaa[];
        int[] ia2[] = {{1, 2}, {3}};

        // 8.2
        // Unqualified identifiers:
        // qualified: myObj.theField
        // unqualified: myObj

        // 8.3
        // method declaration syntax: <modifiers> <header> <body:
        // modifiers: public, annotations, protected, private, abstracit, static, final, synchorinzed, nativ, strictfp
        // headers: generic-declarations, return type, name, formal parameter list, array, throws

        // Method Header Syntax:
        //static <E, F> void doStuff(String st, E e) throws Exception;

        // 8.4
        // passar valores por parâmetro:
        // se for primitivo, o próprio valor é copiado pra dentro da função, sem referência. Se for modificado dentro da função, não há modificação no original.
        // se for passado por referência (um objeto), é passado a referência para a memória do objeto. O objeto original é modificado quando o objeto é modificado dentro da função

        // 8.5
        // varargs -> private void doStuff(int x, String... v) { }

        // 8.6 - overloaded and overriden methods
        // -> method overload

        // 8.7 - overriding
        // -> method override -> @Override

        // 8.8 - records
        // record Customer(String name, int creditLimit) { }
        // immutable (implicit final)
        // no extends, but implements are permitted

        // 8.9 - more records


    }
}
