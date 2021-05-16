package com.webappsecurity.zero.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.wepappsecurity.zero.Pages.AccountSummary;
import com.wepappsecurity.zero.Pages.Login;
import com.wepappsecurity.zero.Pages.TransferFunds;
import com.wepappsecurity.zero.Pages.TransferFundsConfirmation;
import com.wepappsecurity.zero.Pages.TrasferFundsVerify;

import utils.GenericMethods;

public class VerifyFundTransferTest extends Base {
	
	@Test
	public void verifyFundTransfer() throws IOException {
		Login lp = new Login(driver);
		AccountSummary acc = new AccountSummary(driver);
		TransferFunds tf = new TransferFunds(driver);
		TransferFundsConfirmation tfc = new TransferFundsConfirmation(driver);
		TrasferFundsVerify tfv = new TrasferFundsVerify(driver);
		
		String[][] data = GenericMethods.getData("D:\\SelApr17\\TestData.xlsx", "Sheet1");
		
		for(int i = 1;i<data.length;i++) {
			lp.applicationLogin(data[i][0], data[i][1]);
			acc.clickTransferFunds();
			tf.fundTransfer(data[i][2], data[i][3]);
			tfv.clickSubmit();
			String actualMsg = tfc.getConfText();
			String expectedMsg = data[i][4];
			Assert.assertEquals(actualMsg, expectedMsg);
			tfc.appLogout();
			driver.get("http://zero.webappsecurity.com/login.html");
		}
	}

}
