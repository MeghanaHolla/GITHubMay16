package com.wepappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrasferFundsVerify {
	
	@FindBy(id="btn_submit")
	private WebElement submitBtn;
	
	public TrasferFundsVerify(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickSubmit() {
		submitBtn.click();
	}

}
