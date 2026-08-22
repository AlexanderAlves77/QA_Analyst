using EnterpriseAutomationFramework.Core.Configuration;
using EnterpriseAutomationFramework.Core.Exceptions;

namespace EnterpriseAutomationFramework.Core.Validation;

public static class WaitSettingsValidator
{
    public static void Validate(WaitSettings settings)
    {
        if (settings.DefaultTimeoutSeconds <= 0)
        {
            throw new FrameworkException(
                "Default wait timeout must be greater than zero.");
        }

        if (settings.PollingIntervalMilliseconds <= 0)
        {
            throw new FrameworkException(
                "Wait polling interval must be greater than zero.");
        }

        if (settings.PollingIntervalMilliseconds >= 
                settings.DefaultTimeoutSeconds * 1000)
        {
            throw new FrameworkException(
                "Wait polling interval must be smaller than the default timeout.");
        }
    }
}
