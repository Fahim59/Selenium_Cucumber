package Real_Scenario.hooks;

import io.cucumber.java.*;

public class hooks {
    @BeforeAll
    public static void beforeAll(){
        System.out.println("\nI'm BEFORE ALL\n");
    }

    @Before(order = 0)
    public static void before(Scenario scenario){
        System.out.println("\nI'm BEFORE 0\n");

        System.out.println("Scenario Name: " +scenario.getName());
        System.out.println("Scenario Line: " +scenario.getLine());
        System.out.println("Scenario Tags: " +scenario.getSourceTagNames());
        System.out.println("Scenario Status: " +scenario.getStatus());
        System.out.println("Scenario Uri: " +scenario.getUri());
        System.out.println("Scenario isFailed: " +scenario.isFailed());
    }

    @Before(order = 1)
    public static void before(){
        System.out.println("\nI'm BEFORE 1\n");
    }

    @After(order = 0)
    public static void after(Scenario scenario){
        System.out.println("\nI'm AFTER 0\n");

        System.out.println("Scenario Name: " +scenario.getName());
        System.out.println("Scenario Line: " +scenario.getLine());
        System.out.println("Scenario Tags: " +scenario.getSourceTagNames());
        System.out.println("Scenario Status: " +scenario.getStatus());
        System.out.println("Scenario Uri: " +scenario.getUri());
        System.out.println("Scenario isFailed: " +scenario.isFailed());
    }

    @After(order = 1)
    public static void after(){
        System.out.println("\nI'm AFTER 1\n");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("\nI'm AFTER ALL\n");
    }
}
