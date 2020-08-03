package mytests;

import annotations.AfterMethod;
import annotations.BeforeMethod;
import annotations.Test;

public class Suite {

    @BeforeMethod
    public void beforeMethod(){

        System.out.println("Executing before method");
    }
    @AfterMethod
    public void afterMethod(){

        System.out.println("Executing after method");
    }

    @Test
    public void test1(){

        System.out.println("Executing test 1");
    }

    @Test(enabled = true)
    public void test2(){

        System.out.println("Executing test 2");
    }
    @Test(enabled = true)
    public void test3(){

        System.out.println("Executing test 3");
    }
}
