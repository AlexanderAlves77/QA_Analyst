namespace EnterpriseAutomationFramework.Core.Abstractions.Browser;

public interface IWebElementWrapper
{
    string Text { get; }

    bool IsDisplayed { get; }

    bool IsEnabled { get; }

    void Click();

    void Clear();

    void SendKeys(string text);

    string? GetAttribute(string attributeName);
}
