package com.ui.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandle_06 {
    public static void main(String args[]) {


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //text locators
        Page page = browser.newPage();

        //Frame  Example ***
        page.navigate("https://www.londonfreelance.org/courses/frames/index.html");

        // Approach 1
        String header = page.frameLocator("//frame[@name='main']").locator("h2").textContent();
        System.out.println(header);

        //Approach 2
		String h2 = page.frame("main").locator("h2").textContent();
		System.out.println(h2);

        // IFrame Example ***
        page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

        page.locator("img[title='Vehicle-Registration-Forms-and-Examples']").click();

        page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("#RESULT_TextField-8")
                .fill("Naveen Automation");
        // page.pause();  --> to see the execution uncomment this line

        browser.close();
        playwright.close();

    }
}
