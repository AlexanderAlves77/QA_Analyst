using EnterpriseAutomationFramework.Core.Configuration;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Edge;
using OpenQA.Selenium.Firefox;

namespace EnterpriseAutomationFramework.Infrastructure.Web.Options;

public static class BrowserOptionsFactory
{
    public static ChromeOptions CreateChrome(BrowserSettings settings)
    {
        var options = new ChromeOptions();

        if (settings.Headless)
        {
            options.AddArgument("--headless");
        }

        if (!string.IsNullOrWhiteSpace(settings.BinaryPath))
        {
            options.BinaryLocation = settings.BinaryPath;
        }

        foreach (var argument in settings.AdditionalArguments)
        {
            options.AddArgument(argument);
        }

        return options;
    }

    public static EdgeOptions CreateEdge(BrowserSettings settings)
    {
        var options = new EdgeOptions();

        if (settings.Headless)
        {
            options.AddArgument("--headless");
        }

        if (!string.IsNullOrWhiteSpace(settings.BinaryPath))
        {
            options.BinaryLocation = settings.BinaryPath;
        }

        foreach (var argument in settings.AdditionalArguments)
        {
            options.AddArgument(argument);
        }

        return options;
    }

    public static FirefoxOptions CreateFirefox(BrowserSettings settings)
    {
        var options = new FirefoxOptions();

        if (settings.Headless)
        {
            options.AddArgument("--headless");
        }

        if (!string.IsNullOrWhiteSpace(settings.BinaryPath))
        {
            options.BinaryLocation = settings.BinaryPath;
        }

        foreach (var argument in settings.AdditionalArguments)
        {
            options.AddArgument(argument);
        }

        return options;
    }
}
