using EnterpriseAutomationFramework.Core.Configuration;
using OpenQA.Selenium;

namespace EnterpriseAutomationFramework.Infrastructure.Web.Drivers;

public interface IWebDriverFactory
{
    IWebDriver Create(BrowserSettings settings);
}
