using EnterpriseAutomationFramework.Core.Configuration;
using EnterpriseAutomationFramework.Core.Exceptions;

namespace EnterpriseAutomationFramework.Core.Validation;

public static class FrameworkSettingsValidator
{
    public static void Validate(FrameworkSettings settings)
    {
        if (string.IsNullOrWhiteSpace(settings.Environment))
        {
            throw new FrameworkException("Framework environment configuration is required.");
        }

        if (settings.DefaultTimeoutSeconds <= 0)
        {
            throw new FrameworkException("Default timeout must be greater than zero.");
        }
    }
}
