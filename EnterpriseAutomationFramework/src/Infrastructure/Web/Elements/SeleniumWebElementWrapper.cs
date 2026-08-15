using EnterpriseAutomationFramework.Core.Abstractions.Browser;
using OpenQA.Selenium;

namespace EnterpriseAutomationFramework.Infrastructure.Web.Elements;

public sealed class SeleniumWebElementWrapper : IWebElementWrapper
{
    private readonly IWebElement _element; 

    public SeleniumWebElementWrapper(IWebElement element)
    {
        _element = element
            ?? throw new ArgumentNullException(nameof(element));
    }

    public string Text => _element.Text;

    public bool IsDisplayed => _element.Displayed;

    public bool IsEnabled => _element.Enabled;

    public void Click()
    {
        _element.Click();
    }

    public void Clear()
    {
        _element.Clear();
    }

    public void SendKeys(string text)
    {
        ArgumentNullException.ThrowIfNull(text);

        _element.SendKeys(text);
    }

    public string? GetAttribute(string attributeName)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(attributeName);
        
        return _element.GetAttribute(attributeName);
    }
}
