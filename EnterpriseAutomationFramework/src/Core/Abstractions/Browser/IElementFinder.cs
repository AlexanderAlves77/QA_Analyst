using EnterpriseAutomationFramework.Core.Models;

namespace EnterpriseAutomationFramework.Core.Abstractions.Browser;

public interface IElementFinder
{
    IWebElementWrapper Find(ElementLocator locator);

    IReadOnlyCollection<IWebElementWrapper> FindAll(ElementLocator locator);
}
