using EnterpriseAutomationFramework.Core.Configuration;
using EnterpriseAutomationFramework.Core.Exceptions;

namespace EnterpriseAutomationFramework.Core.Validation;

public static class LoggingSettingsValidator
{
    public static void Validate(LoggingSettings settings)
    {
        if (string.IsNullOrWhiteSpace(settings.MinimumLevel))
        {
            throw new FrameworkException("Logging minimum level configuration is required.");
        }

        if (settings.EnableFile && string.IsNullOrWhiteSpace(settings.FilePath))
        {
            throw new FrameworkException("Logging file path is required when file logging is enabled.");
        }
    }
}
