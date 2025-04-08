package ir.bootcamp.java.banksystem;

import org.junit.jupiter.api.*;


// this model is for test of nested classes
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class OrderNestedTests {

    @Order(1)
    @Nested
    class PrimaryTests {
        @Test
        void test1() {

        }
    }

    @Order(2)
    @Nested
    class SecondaryTests {
        @Test
        void test2() {

        }

    }
}
// @TempDir
//create temporary direction for example on disk
//@ExtendWith on fields and parameters
//@RegisterExtension