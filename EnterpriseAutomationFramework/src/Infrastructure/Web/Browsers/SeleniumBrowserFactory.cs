using EnterpriseAutomationFramework.Core.Abstractions.Browser;
using EnterpriseAutomationFramework.Core.Configuration;
using EnterpriseAutomationFramework.Core.Enums;
using EnterpriseAutomationFramework.Core.Models;
using EnterpriseAutomationFramework.Infrastructure.Web.Drivers;
using EnterpriseAutomationFramework.Infrastructure.Web.Elements;
using EnterpriseAutomationFramework.Infrastructure.Web.Navigation;

namespace EnterpriseAutomationFramework.Infrastructure.Web.Browsers;

public sealed class SeleniumBrowserFactory : IBrowserFactory
{
    private readonly IWebDriverFactory _driverFactory;
    private readonly BrowserSettings _settings;

    public SeleniumBrowserFactory(IWebDriverFactory driverFactory, 
        BrowserSettings settings)
    {
        _driverFactory = driverFactory;
        _settings = settings;
    }

    public IBrowser Create(BrowserType browserType)
    {
        var settings = CreateSettingsFor(browserType);

        var driver = _driverFactory.Create(settings);   

        var navigator = new SeleniumNavigator(driver);

        var elements = new SeleniumElementFinder(driver);

        var info = new BrowserInfo(browserType, browserType.ToString());

        return new SeleniumBrowser(driver, info, navigator, elements);
    }

    private BrowserSettings CreateSettingsFor(BrowserType browserType)
    {
        return new BrowserSettings
        {
            Type = browserType,
            Headless = _settings.Headless,
            WindowWidth = _settings.WindowWidth,
            WindowHeight = _settings.WindowHeight,
            PageLoadTimeoutSeconds = _settings.PageLoadTimeoutSeconds,
            ScriptTimeoutSeconds = _settings.ScriptTimeoutSeconds,
            ImplicitWaitSeconds = _settings.ImplicitWaitSeconds,
            BinaryPath = _settings.BinaryPath,
            AdditionalArguments = _settings.AdditionalArguments
        };
    }
}
