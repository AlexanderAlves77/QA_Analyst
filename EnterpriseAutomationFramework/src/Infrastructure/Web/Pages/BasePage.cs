using EnterpriseAutomationFramework.Core.Abstractions.Browser;

namespace EnterpriseAutomationFramework.Infrastructure.Web.Pages;

public abstract class BasePage
{
    protected IBrowser Browser { get; }

    protected BasePage(IBrowser browser)
    {
        Browser = browser ?? throw new ArgumentNullException(nameof(browser));
    }
}
