using EnterpriseAutomationFramework.Core.Enums;
using EnterpriseAutomationFramework.Core.Models;
using EnterpriseAutomationFramework.Infrastructure.Web.Elements;

namespace EnterpriseAutomationFramework.Tests.Infrastructure.Web;

public class SeleniumLocatorMapperTests
{
    [Test]
    public void ToBy_ShouldMapIdLocator()
    {
        var locator = new ElementLocator(LocatorType.Id, "username");

        var by = SeleniumLocatorMapper.ToBy(locator);

        Assert.That(by.ToString(), Does.Contain("username"));
    }

    [Test]
    public void ToBy_ShouldMapCssSelectorLocator()
    {
        var locator = new ElementLocator(
            LocatorType.CssSelector, "[data-testid='login']");

        var by = SeleniumLocatorMapper.ToBy(locator);

        Assert.That(by.ToString(), Does.Contain("[data-testid='login']"));
    }

    [Test]
    public void ToBy_ShouldMapXPathLocator()
    {
        var locator = new ElementLocator(
            LocatorType.CssSelector, "//button[@type='submit']");

        var by = SeleniumLocatorMapper.ToBy(locator);

        Assert.That(by.ToString(), Does.Contain("//button[@type='submit']"));
    }
}
