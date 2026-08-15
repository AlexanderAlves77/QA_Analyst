using EnterpriseAutomationFramework.Core.Enums;
using EnterpriseAutomationFramework.Core.Exceptions;
using EnterpriseAutomationFramework.Core.Models;
using OpenQA.Selenium;

namespace EnterpriseAutomationFramework.Infrastructure.Web.Elements;

public static class SeleniumLocatorMapper
{
    public static By ToBy(ElementLocator locator)
    {
        ArgumentNullException.ThrowIfNull(locator); 

        if (string.IsNullOrWhiteSpace(locator.Value))
        {
            throw new FrameworkException("Element locator value cannot be empty.");
        }

        return locator.Type switch
        {
            LocatorType.Id => By.Id(locator.Value),

            LocatorType.Name => By.Name(locator.Value),

            LocatorType.CssSelector => By.CssSelector(locator.Value),

            LocatorType.XPath => By.XPath(locator.Value),

            LocatorType.ClassName => By.ClassName(locator.Value),

            LocatorType.TagName => By.TagName(locator.Value),

            LocatorType.LinkText => By.LinkText(locator.Value),

            LocatorType.PartialLinkText => By.PartialLinkText(locator.Value),

            _ => throw new FrameworkException($"Unsupported locator type: {locator.Type}.")
        };
    }
}
