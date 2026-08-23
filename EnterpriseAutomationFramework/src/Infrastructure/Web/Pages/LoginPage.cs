using EnterpriseAutomationFramework.Core.Abstractions.Browser;
using EnterpriseAutomationFramework.Core.Enums;
using EnterpriseAutomationFramework.Core.Models;

namespace EnterpriseAutomationFramework.Infrastructure.Web.Pages;

public sealed class LoginPage : BasePage
{
    private readonly ElementLocator _usernameInput = new(LocatorType.Id, "username");

    private readonly ElementLocator _passwordInput = new(LocatorType.Id, "password");

    private readonly ElementLocator _loginButton = 
        new(LocatorType.CssSelector, "button[type='submit']");

    public LoginPage(IBrowser browser) : base(browser)
    { }

    public void GoTo(string url)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(nameof(url));

        Browser.Navigator.GoTo(url);    
    }

    public void EnterUsername(string username)
    {
        Browser.Actions.Type(_usernameInput, username);
    }

    public void EnterPassword(string password)
    {
        Browser.Actions.Type(_passwordInput, password);
    }

    public void ClickLogin()
    {
        Browser.Actions.Click(_loginButton);
    }

    public void Login(string username, string password)
    {
        EnterUsername(username);
        EnterPassword(password);
        ClickLogin();
    }
}
