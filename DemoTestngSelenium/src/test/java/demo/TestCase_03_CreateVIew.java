package demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase_03_CreateVIew {
	@DataProvider(name = "user_account")
	public String[][] UserAccountData(){
		return new String[][] {
			{"user01", "123456"},
			{"user02", "456123"},
			{"user03", "987654"}
		};
	}
	
	@Test(dataProvider = "user_account")
	public void test03(String userName, String password) {
		System.out.println("Run Test case 03");
		System.out.println("Show username: " + userName);
		System.out.println("Show password: " + password);
	}
}
