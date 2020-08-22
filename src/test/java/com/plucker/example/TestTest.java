package com.plucker.example;


import org.junit.Test;

public class TestTest extends junit.framework.TestCase {

  public TestTest() {
  }

  @Test
  public void testGetListOfStuff() {
    assertTrue(TestCacheService.getInstance().getListOfStuff("key") != null);
    assertTrue(TestCacheService.getInstance().getListOfStuff("x") != null);
    System.out.println("one = " + TestCacheService.getInstance().methodThatTakesTooMuchTime("one"));
    System.out.println("one = " + TestCacheService.getInstance().methodThatTakesTooMuchTime("one"));
  }
}