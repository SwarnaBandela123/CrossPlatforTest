package practice;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
	
public class CrossPlatformTest {
	    private static AppiumDriver driver;

	    public static void main(String[] args) {
	        try {
	            // Detect the operating system
	            String os = System.getProperty("os.name");

	            // Set desired capabilities based on the detected OS
	            DesiredCapabilities capabilities = new DesiredCapabilities();
	            if (os.contains("Mac")) {
	                // iOS desired capabilities
	                capabilities.setCapability("platformName", "iOS");
	                capabilities.setCapability("platformVersion", "14.5");
	                capabilities.setCapability("deviceName", "iPhone 12");
	                capabilities.setCapability("appium:appPackage", "com.miui.calculator");
	            	capabilities.setCapability("appium:appActivity", "com.miui.calculator.cal.CalculatorActivity");
	                URL url=new URL("http://127.0.0.1:4723/wd/hub");
	                driver = new IOSDriver(url, capabilities);
	                System.out.println("Calculator launched successfully");
	            } else {
	                // Android desired capabilities
	            	capabilities.setCapability("deviceName", "a6fuugukwcwseekv");
	            	capabilities.setCapability("platformName", "Android");
	            	capabilities.setCapability("appium:appPackage", "com.miui.calculator");
	            	capabilities.setCapability("appium:appActivity", "com.miui.calculator.cal.CalculatorActivity");
	                URL url=new URL("http://127.0.0.1:4723/wd/hub");
	                driver = new AndroidDriver(url, capabilities);
	                System.out.println("Calculator launched successfully");

	            }

	            // Addition of two numbers
	            System.out.println("Addition two numbers");
	            driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_1")).click();
	            driver.findElement(AppiumBy.id("com.miui.calculator:id/op_add")).click();
	            driver.findElement(AppiumBy.id("com.miui.calculator:id/digit_2")).click();
	            driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_equal_s")).click();
	            System.out.println("Successfully added two numbers");


	            // Close the app
	            driver.quit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}

