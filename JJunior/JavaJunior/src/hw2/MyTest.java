package hw2;

class MyTest {
    @BeforeEach
    @AfterEach
    @Test
    void firstTest() {
        System.out.println("firstTest запущен");
    }

    @BeforeEach
    @AfterEach
    @Test(order = -10)
    void secondTest() {
        System.out.println("secondTest запущен");
    }

    @BeforeEach
    @AfterEach
    @Skip
    @Test(order = -20)
    void skippedTest() {
        System.out.println("secondTest запущен");
    }
}
