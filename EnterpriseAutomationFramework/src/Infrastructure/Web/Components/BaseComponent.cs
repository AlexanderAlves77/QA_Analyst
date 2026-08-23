using EnterpriseAutomationFramework.Core.Abstractions.Browser;

namespace EnterpriseAutomationFramework.Infrastructure.Web.Components;

public abstract class BaseComponent
{
    protected IBrowser Browser { get; }

    protected BaseComponent(IBrowser browser)
    {
        Browser = browser ?? throw new ArgumentNullException(nameof(browser));
    }
}
