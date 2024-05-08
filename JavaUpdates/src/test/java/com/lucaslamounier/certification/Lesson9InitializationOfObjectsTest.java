package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class Lesson9InitializationOfObjectsTest {

    @Test
    void lesson9InitializationOfObjectsTest() {
        // 9.2
    }

    class TryIt {
        public void main(String[] args) { new TryIt().go(); }
        public void go() {
            System.out.println(x + ", " + y + ", " + z);
        }
        int x;
        {System.out.println(x + ", " + this.y);}
        int y;
        {System.out.println(x + ", " + this.y);}
        {x = y + 10;}
        int z = -1;
    }
}
