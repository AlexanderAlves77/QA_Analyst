using EnterpriseAutomationFramework.Core.Abstractions.Browser;
using EnterpriseAutomationFramework.Core.Enums;
using EnterpriseAutomationFramework.Core.Models;

namespace EnterpriseAutomationFramework.Infrastructure.Web.Components;

public sealed class HeaderComponent : BaseComponent
{
    private readonly ElementLocator _profileButton = new(LocatorType.Id, "profile");

    private readonly ElementLocator _logoutButton = new(LocatorType.Id, "logout");

    public HeaderComponent(IBrowser browser) : base(browser)
    { }

    public void OpenProfile()
    {
        Browser.Actions.Click(_profileButton);
    }

    public void Logout()
    {
        Browser.Actions.Click(_profileButton);
        Browser.Actions.Click(_logoutButton);
    }
}
