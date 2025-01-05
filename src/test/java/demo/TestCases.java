package demo;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */

    @Test
     public void testCase01() throws InterruptedException{
        //opening the URL
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
        Thread.sleep(3000);

        //Name element
        WebElement Name=driver.findElement(By.className("zHQkBf"));
        Name.sendKeys("Crio Learner");
        //Thread.sleep(3000);

        //whyPractice element
        WebElement whyPractice=driver.findElement(By.className("tL9Q4c"));
        //Thread.sleep(3000);
        System.out.println(Instant.now().getEpochSecond());
        whyPractice.sendKeys("I want to be the best QA Engineer! "+Instant.now().getEpochSecond());
        //Thread.sleep(3000);

        //experience element
        WebElement experience=driver.findElement(By.id("i16"));
        //Thread.sleep(3000);
        experience.click();

        //skills element
        List<WebElement> skills=driver.findElements(By.className("eBFwI"));
        List<String> skillsAnswer= Arrays.asList("Java","Selenium","TestNG");
        for(WebElement w: skills){
            if(skillsAnswer.contains(w.getText())){
                w.click();
            }
        }

        //Choose element
        WebElement beCalled=driver.findElement(By.xpath("//span[text()='Choose']"));
        beCalled.click();
        Thread.sleep(1000);
        WebElement prefix=driver.findElement(By.xpath("//div[contains(@class,'QXL7Te')]//span[text()='Ms']"));
        prefix.click(); 
        Thread.sleep(3000);

        //date element
        WebElement dateElement=driver.findElement(By.xpath("//input[@type='date']"));
        String date7daysago=LocalDate.now().minusDays(7).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(LocalDate.now().minusDays(7).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        dateElement.sendKeys(date7daysago); 

        //currentTime element
        // String currentTime=LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm a"));
        // String[] currentTimeArray=currentTime.split(" ");
        // String[] hourTime=currentTimeArray[0].split(":");
        // String hour=hourTime[0];
        // String minute=hourTime[1];
        // String ampm=currentTimeArray[1];
        WebElement hourElement=driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        WebElement minuteElement=driver.findElement(By.xpath("//input[@aria-label='Minute']"));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        //WebElement ampmElement=wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'KKjvXb')]/span[text()='AM']"))));
        hourElement.sendKeys("07");
        minuteElement.sendKeys("30");
        //ampmElement.click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//span[text()='"+ ampm +"']")).click();
        Thread.sleep(1000);

        //submit element
        WebElement submit=driver.findElement(By.xpath("//span[text()='Submit']"));
        submit.click();
        Thread.sleep(3000);

        //Thanks element
        WebElement thanks=driver.findElement(By.xpath("//div[contains(text(),'Thanks')]"));
        if(thanks.getText().contains("Thanks")){
            System.out.println("Form is submitted successfully!!");
        }
        else
            System.out.println("Form is not submitted");
        //Assert.isTrue(thanks.getText().isDisplayed(), "Form is not submitted");

        Thread.sleep(3000);
     }
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);
        // Window window =this.driver.manage().window(); 
        // org.openqa.selenium.Point position = window.getPosition(); 
        // window.minimize(); 
        // window.setPosition(position);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
}