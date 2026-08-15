using System.Drawing;
using EnterpriseAutomationFramework.Core.Configuration;
using EnterpriseAutomationFramework.Core.Enums;
using EnterpriseAutomationFramework.Core.Exceptions;
using EnterpriseAutomationFramework.Infrastructure.Web.Options;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Edge;
using OpenQA.Selenium.Firefox;

namespace EnterpriseAutomationFramework.Infrastructure.Web.Drivers;

public sealed class SeleniumWebDriverFactory : IWebDriverFactory
{
    public IWebDriver Create(BrowserSettings settings)
    {
        IWebDriver driver = settings.Type switch
        {
            BrowserType.Chrome => new ChromeDriver(
                BrowserOptionsFactory.CreateChrome(settings)
            ),

            BrowserType.Edge => new EdgeDriver(
                BrowserOptionsFactory.CreateEdge(settings)
            ),

            BrowserType.Firefox => new FirefoxDriver(
                BrowserOptionsFactory.CreateFirefox(settings)
            ),

            _ => throw new FrameworkException($"Unsupported browser type: {settings.Type}.")
        };

        ConfigureDriver(driver, settings);

        return driver;
    }

    private static void ConfigureDriver(IWebDriver driver, BrowserSettings settings)
    {
        driver.Manage().Window.Size = new Size(
            settings.WindowWidth, settings.WindowHeight
        );

        var timeouts = driver.Manage().Timeouts();

        timeouts.PageLoad = TimeSpan.FromSeconds(settings.PageLoadTimeoutSeconds);

        timeouts.AsynchronousJavaScript = TimeSpan.FromSeconds(
            settings.ScriptTimeoutSeconds
        );

        timeouts.AsynchronousJavaScript = TimeSpan.FromSeconds(
            settings.ImplicitWaitSeconds
        );
    }
}
