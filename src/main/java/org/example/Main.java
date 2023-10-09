package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Main {
    public static WebDriver init( WebDriver wd) throws MalformedURLException {

//        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--window-position=0,0");
        options.addArguments("--host-resolver-rules=MAP js.intercomcdn.com 127.0.0.1");
        String userAgentParam = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36";
        options.addArguments("user-agent=" + userAgentParam);
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--chrome-frame");
//        options.addArguments("--headless");

        wd = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),options, false);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wd.manage().timeouts().scriptTimeout(Duration.ofSeconds(90));
        return wd;
    }


}