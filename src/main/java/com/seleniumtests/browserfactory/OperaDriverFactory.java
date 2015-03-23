package com.seleniumtests.browserfactory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.opera.core.systems.OperaDriver;

import com.seleniumtests.driver.DriverConfig;

public class OperaDriverFactory extends AbstractWebDriverFactory implements IWebDriverFactory {

    public OperaDriverFactory(final DriverConfig cfg) {
        super(cfg);
    }

    @Override
    public WebDriver createWebDriver() throws IOException {
        DriverConfig cfg = this.getWebDriverConfig();

        synchronized (this.getClass()) {
            driver = new OperaDriver(new OperaCapabilitiesFactory().createCapabilities(cfg));
        }

        // Implicit Wait handles dynamic element. The default value is 5 seconds.
        setImplicitWaitTimeout(cfg.getImplicitWaitTimeout());
        this.setWebDriver(driver);
        return driver;
    }

}
