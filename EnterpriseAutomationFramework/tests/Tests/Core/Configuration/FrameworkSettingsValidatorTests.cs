using EnterpriseAutomationFramework.Core.Configuration;
using EnterpriseAutomationFramework.Core.Exceptions;
using EnterpriseAutomationFramework.Core.Validation;

namespace EnterpriseAutomationFramework.Tests.Core.Configuration;

public class FrameworkSettingsValidatorTests
{
    [Test] 
    public void Validate_ShouldNotThrow_WhenSettingsAreValid()
    {
        var settings = new FrameworkSettings
        {
            Environment = "QA",
            DefaultTimeoutSeconds = 30
        };

        Assert.DoesNotThrow(() => FrameworkSettingsValidator.Validate(settings));
    }

    [Test]
    public void Validate_ShouldThrow_WhenTimeoutIsInvalid()
    {
        var settings = new FrameworkSettings
        {
            Environment = "QA",
            DefaultTimeoutSeconds = 0
        };

        Assert.Throws<FrameworkException>(() => FrameworkSettingsValidator.Validate(settings));
    }
}