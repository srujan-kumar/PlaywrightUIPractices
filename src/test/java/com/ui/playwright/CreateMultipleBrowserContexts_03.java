package com.ui.playwright;

import com.microsoft.playwright.*;

public class CreateMultipleBrowserContexts_03 {
    public static void main(String args[]) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions op = new BrowserType.LaunchOptions();
        op.setChannel("chrome");
        op.setHeadless(false);
        Browser browser = playwright.chromium().launch(op);

        BrowserContext brcx1 = browser.newContext();
        Page p1 = brcx1.newPage();


        p1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial");
        p1.fill("#Form_getForm_Name", "Naveen");
        System.out.println(p1.title());

        BrowserContext brcx2 = browser.newContext();
        Page p2 = brcx2.newPage();
        p2.navigate("https://automationpractice.com/");

        p1.close();
        brcx1.close();
        p2.close();
        brcx2.close();
        playwright.close();
    }
}
