package com.ui.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class LoginPageWithTraceViewer_02 {

    public static void main(String args[]) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();

            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));
            Page page = context.newPage();
            page.navigate("https://academy.naveenautomationlabs.com/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
            page.frameLocator("#microfe-popup-login").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Continue with email")).click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("testautomation@gmail.com");
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").click();
            page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").fill("test123");
            page.frameLocator("#microfe-popup-login").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Next")).click();

            //Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));

            browser.close();
            playwright.close();
        }

    }
}
