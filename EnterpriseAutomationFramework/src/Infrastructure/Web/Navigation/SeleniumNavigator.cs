using EnterpriseAutomationFramework.Core.Abstractions.Browser;
using OpenQA.Selenium;

namespace EnterpriseAutomationFramework.Infrastructure.Web.Navigation;

public sealed class SeleniumNavigator : INavigator
{
    private readonly IWebDriver _driver;

    public SeleniumNavigator(IWebDriver driver)
    {
        _driver = driver ?? throw new ArgumentNullException(nameof(driver));
    }

    public void GoTo(string url)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(url);

        _driver.Navigate().GoToUrl(url);
    }

    public void Back()
    {
        _driver.Navigate().Back();
    }

    public void Forward()
    {
        _driver.Navigate().Forward();
    }

    public void Refresh()
    {
        _driver.Navigate().Refresh();
    }
}
