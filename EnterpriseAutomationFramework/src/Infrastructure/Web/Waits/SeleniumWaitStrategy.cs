using EnterpriseAutomationFramework.Core.Abstractions.Browser;
using EnterpriseAutomationFramework.Core.Configuration;
using EnterpriseAutomationFramework.Core.Models;
using EnterpriseAutomationFramework.Infrastructure.Web.Elements;
using OpenQA.Selenium;
using OpenQA.Selenium.Support.UI;

namespace EnterpriseAutomationFramework.Infrastructure.Web.Waits;

public sealed class SeleniumWaitStrategy : IWaitStrategy
{
    private readonly IWebDriver _driver;
    private readonly WaitSettings _settings;

    public SeleniumWaitStrategy(IWebDriver driver, WaitSettings settings)
    {
        _driver = driver ?? throw new ArgumentNullException(nameof(driver));

        _settings = settings ?? throw new ArgumentNullException(nameof(_settings));
    }

    public IWebElementWrapper UntilPresent(ElementLocator locator)
    {
        var by = SeleniumLocatorMapper.ToBy(locator);

        var element = CreateWait().Until(driver =>
        {
            try
            {
                return driver.FindElement(by);
            }
            catch (NoSuchElementException)
            {
                return null;
            }
        });

        return new SeleniumWebElementWrapper(element);
    }

    public IWebElementWrapper UntilVisible(ElementLocator locator)
    {
        var by = SeleniumLocatorMapper.ToBy(locator);

        var element = CreateWait().Until(driver =>
        {
            try
            {
                var candidate = driver.FindElement(by);

                return candidate.Displayed ? candidate : null;
            }
            catch (NoSuchElementException)
            {
                return null;
            }
            catch (StaleElementReferenceException)
            {
                return null;
            }
        });

        return new SeleniumWebElementWrapper(element);
    }

    public IWebElementWrapper UntilClickable(ElementLocator locator)
    {
        var by = SeleniumLocatorMapper.ToBy(locator);

        var element = CreateWait().Until(driver =>
        {
            try
            {
                var candidate = driver.FindElement(by);

                return candidate.Displayed && candidate.Enabled ? candidate : null;
            }
            catch (NoSuchElementException)
            {
                return null;
            }
            catch (StaleElementReferenceException)
            {
                return null;
            }
        });

        return new SeleniumWebElementWrapper(element);
    }

    public bool UntilInvisible(ElementLocator locator)
    {
        var by = SeleniumLocatorMapper.ToBy(locator);

        return CreateWait().Until(driver =>
        {
            try
            {
                var element = driver.FindElement(by);

                return !element.Displayed;
            }
            catch (NoSuchElementException)
            {
                return true;
            }
            catch (StaleElementReferenceException)
            {
                return true;
            }
        });
    }

    private WebDriverWait CreateWait()
    {
        var wait = new WebDriverWait(_driver,
            TimeSpan.FromSeconds(_settings.DefaultTimeoutSeconds))
        {
            PollingInterval = TimeSpan.FromMilliseconds(
                _settings.PollingIntervalMilliseconds)
        };

        wait.IgnoreExceptionTypes(
            typeof(NoSuchElementException),
            typeof(StaleElementReferenceException)
        );

        return wait;
    }
}
