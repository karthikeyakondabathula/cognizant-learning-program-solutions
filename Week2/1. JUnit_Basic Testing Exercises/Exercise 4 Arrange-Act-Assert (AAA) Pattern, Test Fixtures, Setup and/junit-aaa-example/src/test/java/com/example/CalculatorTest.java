package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

Calculator calc;

@Before
public void setUp(){
System.out.println("Setting up Calculator");
calc=new Calculator();
}

@After
public void tearDown(){
System.out.println("Tearing down Calculator");
calc=null;
}

@Test
public void testAdd(){
// Arrange
int a=5;
int b=3;
// Act
int result=calc.add(a,b);
// Assert
assertEquals(8,result);
System.out.println("Add test passed");
}

@Test
public void testSubtract(){
// Arrange
int a=10;
int b=4;
// Act
int result=calc.subtract(a,b);
// Assert
assertEquals(6,result);
System.out.println("Subtract test passed");
}

@Test
public void testMultiply(){
// Arrange
int a=6;
int b=7;
// Act
int result=calc.multiply(a,b);
// Assert
assertEquals(42,result);
System.out.println("Multiply test passed");
}

@Test
public void testDivide(){
// Arrange
int a=20;
int b=4;
// Act
int result=calc.divide(a,b);
// Assert
assertEquals(5,result);
System.out.println("Divide test passed");
}

@Test(expected = IllegalArgumentException.class)
public void testDivideByZero(){
// Arrange
int a=10;
int b=0;
// Act
calc.divide(a,b);
// Assert -> Exception expected
}

}
