using EnterpriseAutomationFramework.Core.Abstractions.Browser;
using EnterpriseAutomationFramework.Core.Models;
using OpenQA.Selenium;

namespace EnterpriseAutomationFramework.Infrastructure.Web.Actions;

public sealed class SeleniumElementActions
{
    private readonly IWaitStrategy _waitStrategy;

    public SeleniumElementActions(IWaitStrategy waitStrategy)
    {
        _waitStrategy = waitStrategy 
            ?? throw new ArgumentNullException(nameof(waitStrategy));
    }

    public void Click(ElementLocator locator)
    {
        var element = _waitStrategy.UntilClickable(locator);
        element.Click();
    }

    public void Type(ElementLocator locator, string text, bool clearFirst = true)
    {
        ArgumentNullException.ThrowIfNull(text);

        var element = _waitStrategy.UntilVisible(locator);

        if (clearFirst)
        {
            element.Clear();
        }

        element.SendKeys(text);
    }

    public void Clear(ElementLocator locator)
    {
        var element = _waitStrategy.UntilVisible(locator);
        element.Clear();
    }

    public string GetText(ElementLocator locator)
    {
        var element = _waitStrategy.UntilVisible(locator);
        return element.Text;
    }

    public bool IsVisible(ElementLocator locator)
    {
        try
        {
            _waitStrategy.UntilVisible(locator);
            return true;
        }
        catch (WebDriverTimeoutException)
        {
            return false;
        }
    }
}
