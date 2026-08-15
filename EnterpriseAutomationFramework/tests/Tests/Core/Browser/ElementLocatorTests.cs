using EnterpriseAutomationFramework.Core.Enums;
using EnterpriseAutomationFramework.Core.Models;

namespace EnterpriseAutomationFramework.Tests.Core.Browser;

public class ElementLocatorTests
{
    [Test]
    public void Constructor_ShouldCreateElementLocator()
    {
        var locator = new ElementLocator(
            LocatorType.Id,
            "username"
        );

        Assert.Multiple(() =>
        {
            Assert.That(
                locator.Type,
                Is.EqualTo(LocatorType.Id)
            );

            Assert.That(
                locator.Value,
                Is.EqualTo("username")
            );
        });
    }
}
