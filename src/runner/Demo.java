
package runner;

import annotations.AfterMethod;
import annotations.BeforeMethod;
import annotations.Test;
import mytests.Suite;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Suite suite = new Suite();
        Method beforeMethod = null;
        Method afterMethod = null;
        List<Method> tests = new ArrayList<>();

        for(Method m : suite.getClass().getDeclaredMethods()){
            if(m.isAnnotationPresent(BeforeMethod.class))
                beforeMethod = m;
            else if(m.isAnnotationPresent(AfterMethod.class))
                afterMethod = m;
            else if(m.isAnnotationPresent(Test.class))
                if(m.getAnnotation(Test.class).enabled())
                tests.add(m);
        }

        for(Method m: tests){
            if(beforeMethod != null)
                beforeMethod.invoke(suite);
            m.invoke(suite);

            if(afterMethod!=null)
                afterMethod.invoke(suite);

        }

    }
}
