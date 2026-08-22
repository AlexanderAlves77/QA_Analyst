using EnterpriseAutomationFramework.Core.Models;

namespace EnterpriseAutomationFramework.Core.Abstractions.Browser;

public interface IElementActions
{
    void Click(ElementLocator locator);

    void Type(ElementLocator locator, string text, bool clearFirst = true);

    void Clear(ElementLocator locator);

    string GetText(ElementLocator locator);

    bool IsVisible(ElementLocator locator);
}
