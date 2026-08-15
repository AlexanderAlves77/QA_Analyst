using EnterpriseAutomationFramework.Core.Enums;
using EnterpriseAutomationFramework.Core.Models;

namespace EnterpriseAutomationFramework.Tests.Core.Browser;

public class BrowserInfoTests
{
    [Test]
    public void Constructor_ShouldCreateBrowserInfo()
    {
        var browserInfo = new BrowserInfo(
            BrowserType.Chrome,
            "Google Chrome",
            "139"
        );

        Assert.Multiple(() => 
        {
            Assert.That(
                browserInfo.Type,
                Is.EqualTo(BrowserType.Chrome)
            );

            Assert.That(
                browserInfo.Name,
                Is.EqualTo("Google Chrome")
            );

            Assert.That(
                browserInfo.Version,
                Is.EqualTo("139")
            );
        });
    }
}
