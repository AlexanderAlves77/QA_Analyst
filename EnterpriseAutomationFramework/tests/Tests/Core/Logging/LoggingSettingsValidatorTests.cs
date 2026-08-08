using EnterpriseAutomationFramework.Core.Configuration;
using EnterpriseAutomationFramework.Core.Exceptions;
using EnterpriseAutomationFramework.Core.Validation;

namespace EnterpriseAutomationFramework.Tests.Core.Logging;

public class LoggingSettingsValidatorTests
{
    [Test]
    public void Validate_ShouldNotThrow_WhenSettingsAreValid()
    {
        var settings = new LoggingSettings
        {
            MinimumLevel = "Information",
            EnableConsole = true,
            EnableFile = true,
            FilePath = "logs/eaf-.json"
        };

        Assert.DoesNotThrow(() => LoggingSettingsValidator.Validate(settings));
    }

    [Test]
    public void Validate_ShouldThrow_WhenMinimumLevelIsEmpty()
    {
        var settings = new LoggingSettings
        {
            MinimumLevel = "",
            EnableConsole = true
        };

        Assert.Throws<FrameworkException>(() => LoggingSettingsValidator.Validate(settings));
    }

    [Test]
    public void Validate_ShouldThrow_WhenFilePathIsEmptyAndFileLoggingIsEnabled()
    {
        var settings = new LoggingSettings
        {
            MinimumLevel = "Information",
            EnableFile = true,
            FilePath = ""
        };

        Assert.Throws<FrameworkException>(() => LoggingSettingsValidator.Validate(settings));
    }
}
