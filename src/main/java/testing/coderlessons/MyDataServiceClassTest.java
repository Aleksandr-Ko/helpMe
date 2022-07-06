package testing.coderlessons;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class MyDataServiceClassTest {

    @Test
    public void myFirstMethod(){
        String str= "JUnit is working fine";
        assertEquals("JUnit is working fine",str);
    }
}

