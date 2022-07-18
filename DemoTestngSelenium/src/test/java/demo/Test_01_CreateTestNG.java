package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

//C1: @Listeners(ManageListener.class)
//C2: khai báo trong file runTest.xml
public class Test_01_CreateTestNG {
	
	@Test 
	public void testLogin() {
		System.out.println("Test Login");
		Assert.assertTrue(false);
	}
	
	@Test 
	public void testuserDisplay() {
		System.out.println("Test User Display");
	}
	
	
	@Test
	public void testLogout() {
		System.out.println("Log out");
	}
}
