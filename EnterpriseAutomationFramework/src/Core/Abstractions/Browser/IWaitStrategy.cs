using EnterpriseAutomationFramework.Core.Models;

namespace EnterpriseAutomationFramework.Core.Abstractions.Browser;

public interface IWaitStrategy
{
    IWebElementWrapper UntilPresent(ElementLocator locator);

    IWebElementWrapper UntilVisible(ElementLocator locator);

    IWebElementWrapper UntilClickable(ElementLocator locator);

    bool UntilInvisible(ElementLocator locator);
}
