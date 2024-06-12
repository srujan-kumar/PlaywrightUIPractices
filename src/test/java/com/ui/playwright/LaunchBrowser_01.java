package com.ui.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowser_01 {

    // by default Playwright runs in headless mode on (line number 13 commented line)
    // i.e.  browser wont get opened. In back end only operation will be done
    public static void main(String args[]) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
        lp.setChannel("chrome");  //--> browser name needs to be passed as a arguement
        lp.setHeadless(false);
        Browser browser = playwright.chromium().launch(lp);
        //Browser browser=playwright.chromium().launch(); --> headless mode on (browser wont be opened )
        Page page = browser.newPage();
        page.navigate("https://www.amazon.in");
        System.out.println("Page title and URL are --> " + page.title() + "-->" + page.url());
        browser.close();
        playwright.close();
    }
}
