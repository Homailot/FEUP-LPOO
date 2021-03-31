import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

import org.junit.*;

public class TestCases {

    /**
     * Tests if all class field are private, protected
     * or package-protected. You don't have to understand
     * this code.
     * @param classes classes to be tested.
     */
    private void fieldsArentPublic(Class<?> ... classes) {
        for (Class<?> c: classes)
            for (Field f : c.getDeclaredFields())
                assertFalse(Modifier.isPublic(f.getModifiers()));
    }

    /**
     * Tests if a class is abstract. You don't have to 
     * understand this code.
     * @param c class to be tested.
     */
    private void isAbstract(Class<?> c) {
        assertTrue(Modifier.isAbstract(c.getModifiers()));
    }

    /**
     * Tests if a class does not declare a method.
     * You don't have to understand this code.
     * @param c class to be tested.
     */
    private void classNotDeclaresMethod(Class<?> c, String method) {
        try {
            assertTrue(c.getMethod(method).getDeclaringClass() != c);
        } catch (NoSuchMethodException e) { }
    }

    @Test
    public void testThings() {
        Thing thing = new Thing(10);
        assertEquals(10, thing.getId());
    }

}