using EnterpriseAutomationFramework.Core.Configuration;
using EnterpriseAutomationFramework.Core.Enums;
using EnterpriseAutomationFramework.Core.Exceptions;
using EnterpriseAutomationFramework.Core.Validation;

namespace EnterpriseAutomationFramework.Tests.Core.Browser;

public class BrowserSettingsValidatorTests
{
    [Test]
    public void Validate_ShouldNotThrow_WhenSettingsAreValid()
    {
        var settings = new BrowserSettings
        {
            Type = BrowserType.Chrome,
            WindowWidth = 1920,
            WindowHeight = 1080,
            PageLoadTimeoutSeconds = 60,
            ScriptTimeoutSeconds = 30,
            ImplicitWaitSeconds = 0
        };

        Assert.DoesNotThrow(() => BrowserSettingsValidator.Validate(settings));
    }

    [Test]
    public void Validate_ShouldThrow_WhenWindowWidthIsInvalid()
    {
        var settings = new BrowserSettings
        {
            WindowWidth = 0
        };

        Assert.Throws<FrameworkException>(() => 
            BrowserSettingsValidator.Validate(settings));
    }

    [Test]
    public void Validate_ShouldThrow_WhenWindowHeightIsInvalid()
    {
        var settings = new BrowserSettings
        {
            WindowHeight = 0
        };

        Assert.Throws<FrameworkException>(() =>
            BrowserSettingsValidator.Validate(settings));
    }

    [Test]
    public void Validate_ShouldThrow_WhenPageLoadTimeoutIsInvalid()
    {
        var settings = new BrowserSettings
        {
            PageLoadTimeoutSeconds = 0
        };

        Assert.Throws<FrameworkException>(() =>
            BrowserSettingsValidator.Validate(settings));
    }

    [Test]
    public void Validate_ShouldThrow_WhenImplicitWaitIsNegative()
    {
        var settings = new BrowserSettings
        {
            ImplicitWaitSeconds = -1
        };

        Assert.Throws<FrameworkException>(() =>
            BrowserSettingsValidator.Validate(settings));
    }
}
