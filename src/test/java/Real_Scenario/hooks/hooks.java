package Real_Scenario.hooks;

import io.cucumber.java.*;

public class hooks {
    @BeforeAll
    public static void beforeAll(){
        System.out.println("\nI'm BEFORE ALL\n");
    }

    @BeforeStep
    public static void beforeStep(){
        System.out.println("\nI'm BEFORE STEP\n");
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
    public static void before1(){
        System.out.println("\nI'm BEFORE 1\n");
    }

    @Before("@scenario1")
    public static void before2(){
        System.out.println("\nI'm BEFORE 2\n");
    }

    @AfterStep
    public static void afterStep(){
        System.out.println("\nI'm AFTER STEP\n");
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
    public static void after1(){
        System.out.println("\nI'm AFTER 1\n");
    }

    @After("@scenario2")
    public static void after2(){
        System.out.println("\nI'm AFTER 2\n");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("\nI'm AFTER ALL\n");
    }
}
