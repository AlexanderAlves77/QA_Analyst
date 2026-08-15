using EnterpriseAutomationFramework.Core.Abstractions.Browser;
using EnterpriseAutomationFramework.Core.Models;
using OpenQA.Selenium;

namespace EnterpriseAutomationFramework.Infrastructure.Web.Elements;

public sealed class SeleniumElementFinder : IElementFinder
{
    private readonly IWebDriver _driver;

    public SeleniumElementFinder(IWebDriver driver)
    {
        _driver = driver
            ?? throw new ArgumentNullException(nameof(driver));
    }

    public IWebElementWrapper Find(ElementLocator locator)
    {
        var by = SeleniumLocatorMapper.ToBy(locator);

        var element = _driver.FindElement(by);

        return new SeleniumWebElementWrapper(element);
    }

    public IReadOnlyCollection<IWebElementWrapper> FindAll(ElementLocator locator)
    {
        var by = SeleniumLocatorMapper.ToBy(locator);

        return _driver.FindElements(by)
            .Select(element => (IWebElementWrapper)
                new SeleniumWebElementWrapper(element)).ToArray();
    }
}
