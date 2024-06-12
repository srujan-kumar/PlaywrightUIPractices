package com.ui.playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NthElementSelectorImp_12 {

    static Page page;
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        page = browser.newPage();
        page.navigate("https://www.bigbasket.com/");

        Locator first_ele = page.locator("footer div.flex li a >> nth=0"); // first element from list
        String firstEle = first_ele.textContent();
        System.out.println(firstEle);
        first_ele.click();

        // last element from the list
 		Locator last_ele = page.locator("footer div.flex li a >> nth=-1");
		String lastEle = last_ele.textContent();
		System.out.println(lastEle);
        browser.close();
        playwright.close();



    }

}