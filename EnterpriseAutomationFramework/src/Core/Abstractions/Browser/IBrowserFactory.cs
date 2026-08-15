using EnterpriseAutomationFramework.Core.Enums;

namespace EnterpriseAutomationFramework.Core.Abstractions.Browser;

public interface IBrowserFactory
{
    IBrowser Create(BrowserType browserType);
}
