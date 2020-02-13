package com.axa.base;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.log4testng.Logger;

import com.axa.properties.ConfigProperties;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


/**
 * This is a singleton class returns driver object for a given browser
 * 
 * @author 
 */

public class AXAWebDriver extends TestBase {

    private static final Logger log = Logger.getLogger( AXAWebDriver.class );
    private static AXAWebDriver webDriver;
    private WebDriver driver;
    private ConfigProperties appProperties = ConfigProperties.getInstance();

    private AXAWebDriver( String browser ) {
        initializeeWebDriver( browser );
    }

    private AXAWebDriver( String browser, boolean useGrid ) {
        initializeeWebDriver( browser, useGrid );
    }

    public static AXAWebDriver getInstance( String browser ) {
        if ( webDriver == null ) {
            webDriver = new AXAWebDriver( browser );
        }
        return webDriver;
    }

    public static AXAWebDriver getInstance( String browser, boolean useGrid ) {
        if ( webDriver == null ) {
            webDriver = new AXAWebDriver( browser, useGrid );
        }
        return webDriver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void releaseDriver() {
        driver.quit();
        webDriver = null;
    }

    public void initializeeWebDriver( String browser ) {
        String grid = appProperties.getProperty( "useGrid" );
        boolean isGrid = "true".equals( grid );
        initializeeWebDriver( browser, isGrid );
    }

    public void initializeeWebDriver( String browser, boolean useGrid ) {
    	
    	ExtentTest test = extent.startTest("AXA Test", "Initialize Selected  Browser on Selected Platform ");
		test.assignCategory("WebDriver  Module");
		
        log.info( "Test Started for "+browser  );
        String property = "grid";
        test.log(LogStatus.INFO,"Test Started For :"+browser, " "); 
        if("Firefox-Linux".equalsIgnoreCase(browser)) {
        	driver = createFireFoxDriver( useGrid, property, Platform.LINUX );
        } else if ( "Firefox-Vista".equalsIgnoreCase( browser ) ) {
            driver = createFireFoxDriver( useGrid, property, Platform.VISTA );
        } else if ( "Firefox-Win10".equalsIgnoreCase( browser ) ) {
            driver = createFireFoxDriver( useGrid, property, Platform.WINDOWS );
        } else if ( "Firefox-Win8".equalsIgnoreCase( browser ) ) {
            driver = createFireFoxDriver( useGrid, property, Platform.WINDOWS );
        } else if ( "Firefox-Mac".equalsIgnoreCase( browser ) ) {
            driver = createFireFoxDriver( useGrid, property, Platform.MAC );
        }else if ( "Chrome-Mac".equalsIgnoreCase( browser ) ) {
            driver = createChromeDriver( useGrid, property, Platform.MAC );
        } else if ( "Chrome-Linux".equalsIgnoreCase( browser ) ) {
            driver = createChromeDriver( useGrid, property, Platform.LINUX );
        }else if ( "Chrome-Win10".equalsIgnoreCase( browser ) ) {
         driver = createChromeDriver( useGrid, property, Platform.WINDOWS );
        } else if ( "Chrome-Win10".equalsIgnoreCase( browser ) ) {
            driver = createChromeDriver( useGrid, property, Platform.VISTA );
           // ChromeOptions options = new ChromeOptions();
           // options.addArguments("--disable-extensions");
        //    driver = new ChromeDriver(options);
          
        } else if ( "IE-Win10".equalsIgnoreCase( browser ) ) {
            driver = createIEDriver( useGrid, property );
        } else if ( "IE-Win8".equalsIgnoreCase( browser ) ) {
            driver = createIEDriver( useGrid, property );
        } else if ( "Safari-Mac".equalsIgnoreCase( browser ) ) {
            DesiredCapabilities caps = DesiredCapabilities.safari();
            driver = createDriver( "safari", appProperties.getProperty( property ), Platform.MAC, caps );
        } else {
            // If no browser passed throw exception
            log.error( "Browser is incorrect" );
        }
        if ( driver != null ) {
            driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );
            driver.get( appProperties.getProperty( "baseUrl" ) );
            driver.manage().window().maximize();
        }
        extent.endTest(test);
    }

    private WebDriver createIEDriver( boolean isGrid, String urlProperty ) {
        if ( isGrid ) {
            DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            caps.setCapability( InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true );
            caps.setCapability( InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true );
            return createDriver( "internet explorer", appProperties.getProperty( urlProperty ), Platform.WINDOWS, caps );
        } else {
            System.setProperty( "webdriver.ie.driver", appProperties.getProperty( "ieLib" ) );
            DesiredCapabilities dc = getDesiredCapabilities( true );
            return new InternetExplorerDriver( dc );
        }
    }

    private WebDriver createFireFoxDriver( boolean isGrid, String urlProperty, Platform platform ) {
        if ( isGrid ) {
            DesiredCapabilities caps = DesiredCapabilities.firefox();
            return createDriver( "firefox", appProperties.getProperty( urlProperty ), platform, caps );
        } else {
            DesiredCapabilities dc = getDesiredCapabilities( false );
            return new FirefoxDriver( dc );

        }
    }

    private WebDriver createChromeDriver( boolean isGrid, String urlProperty, Platform platform ) {
    
    	if ( isGrid ) {
            DesiredCapabilities caps = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments( "--test-type" );
            caps.setCapability( ChromeOptions.CAPABILITY, options );
            return createDriver( "chrome", appProperties.getProperty( urlProperty ), platform, caps );
        } else {
        	
            
        	ChromeOptions options = new ChromeOptions();
        	
        	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        	System.setProperty( "webdriver.chrome.driver", appProperties.getProperty( "chromeLib" ) );
        	WebDriver driver = new ChromeDriver(options);
        	
          //  DesiredCapabilities dc = getDesiredCapabilities( false );
         // String browserName = null;
		//DesiredCapabilities caps = null;
		 return driver;
        }
    }

    private WebDriver createDriver( String browserName, String driverUrl, Platform platform, DesiredCapabilities caps ) {
        caps.setBrowserName( browserName );
        caps.setPlatform( platform );
        try {
            return new RemoteWebDriver( new URL( driverUrl ), caps );
        } catch ( Exception e ) {
            log.error( "Malformed URL exception for Hub Url " + e.getMessage() );
        }
        return null;
    }

  
    private DesiredCapabilities getDesiredCapabilities( boolean isIe ) {
        DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
        dc.setCapability( "ignoreZoomSetting", true );
        dc.setCapability( "ignoreProtectedModeSettings", true );
        dc.setJavascriptEnabled( true );

        if ( isIe ) {
            dc.setCapability( InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true );
            dc.setCapability( InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true );
            dc.setCapability( InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false );
            dc.setCapability( InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true );
        }

        // open a new clean session with all cookies and cache being cleared
        dc.setCapability( CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true );
        try {
            Runtime.getRuntime().exec( "RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 255" );
        } catch ( IOException e ) {
            log.error( "IOException " + e.getMessage() );
        }
        return dc;
    }
}
