package demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestCase_02_CreateWithPlugin {
  @Test
  public void testcase02() {
	  System.out.println("Run test case 02");
	  Assert.assertTrue(false);
  }
  
  @Test(dependsOnMethods = "testcase02") // testcase02 lỗi nên sẽ ko chạy các testcase tiếp theo
  public void testcase02_1() {
	  System.out.println("Run test case 02_1");
  }

  @Test(dependsOnMethods = "testcase02")
  public void testcase02_2() {
	  System.out.println("Run test case 02_2");
  }
  
  @Test(dependsOnMethods = "testcase02")
  public void testcase02_3() {
	  System.out.println("Run test case 02_3");
  }
}

