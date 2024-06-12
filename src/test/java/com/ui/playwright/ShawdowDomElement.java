package com.ui.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
public class ShawdowDomElement {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //Page -- DOM --> Shadow DOM --> elements
        //Page -- DOM --> iFrame --> Shadow DOM --> elements

        Page page = browser.newPage();

            //page.navigate("https://selectorshub.com/xpath-practice-page/");
            // Example1
            page.navigate("https://selectorshub.com/shadow-dom-in-iframe/");
            page.frameLocator("#pact").locator("div#snacktime #tea").fill("Ginger Masala Tea");


        // Example2
		page.navigate("https://books-pwakit.appspot.com/");
		page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing Books");
        // ***** capture the div element text content
		String text = page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
		System.out.println(text);

        browser.close();
        playwright.close();

    }

}


