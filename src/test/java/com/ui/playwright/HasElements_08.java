package com.ui.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
// to traverse over the inner elements
public class HasElements_08 {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        // Example1
        page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial");
        Locator loc = page.locator("select#Form_getForm_Country:has(option[value='India'])");
         //To print all drop down values of country dropdown
		loc.allInnerTexts().forEach(e -> System.out.println(e));
        page.pause();

        // Example2
        page.navigate("https://www.amazon.com/");
        Locator footerList = page.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");
        footerList.allInnerTexts().forEach(e -> System.out.println(e));

        browser.close();
        playwright.close();
    }
}

