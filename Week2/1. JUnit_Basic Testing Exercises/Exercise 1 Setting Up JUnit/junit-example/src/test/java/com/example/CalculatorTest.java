package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

@Test
public void testAddtestSubtract(){
Calculator calc = new Calculator();
int result = calc.add(3,5);
System.out.println("Add result: "+result);
assertEquals(8, result);
result = calc.subtract(10,4);
System.out.println("Subtract result: "+result);
assertEquals(6, result);
}


}
