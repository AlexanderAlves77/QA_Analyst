using EnterpriseAutomationFramework.Core.Configuration;
using EnterpriseAutomationFramework.Core.Exceptions;
using EnterpriseAutomationFramework.Core.Validation;

namespace EnterpriseAutomationFramework.Tests.Core.Browser;

public class WaitSettingsValidatorTests
{
    [Test]
    public void Validate_ShouldNotThrow_WhenSettingsAreValid()
    {
        var settings = new WaitSettings
        {
            DefaultTimeoutSeconds = 15,
            PollingIntervalMilliseconds = 500
        };

        Assert.DoesNotThrow(() => WaitSettingsValidator.Validate(settings));
    }

    [Test]
    public void Validate_ShouldThrow_WhenTimeoutIsInValid()
    {
        var settings = new WaitSettings
        {
            DefaultTimeoutSeconds = 0,
            PollingIntervalMilliseconds = 500
        };

        Assert.Throws<FrameworkException>(
            () => WaitSettingsValidator.Validate(settings));
    }

    [Test]
    public void Validate_ShouldThrow_WhenPollingIntervalIsInValid()
    {
        var settings = new WaitSettings
        {
            DefaultTimeoutSeconds = 15,
            PollingIntervalMilliseconds = 0
        };

        Assert.Throws<FrameworkException>(
            () => WaitSettingsValidator.Validate(settings));
    }

    [Test]
    public void Validate_ShouldThrow_WhenPollingExceedsTimeout()
    {
        var settings = new WaitSettings
        {
            DefaultTimeoutSeconds = 1,
            PollingIntervalMilliseconds = 1500
        };

        Assert.Throws<FrameworkException>(
            () => WaitSettingsValidator.Validate(settings));
    }
}
