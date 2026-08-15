using EnterpriseAutomationFramework.Core.Configuration;
using EnterpriseAutomationFramework.Core.Exceptions;

namespace EnterpriseAutomationFramework.Core.Validation;

public static class BrowserSettingsValidator
{
    public static void Validate(BrowserSettings settings)
    {
        if (!Enum.IsDefined(settings.Type))
        {
            throw new FrameworkException($"Unsupported browser type: {settings.Type}.");
        }

        if (settings.WindowWidth <= 0)
        {
            throw new FrameworkException("Browser window width must be greater than zero.");
        }

        if (settings.WindowHeight <= 0)
        {
            throw new FrameworkException("Browser window height must be greater than zero.");
        }

        if (settings.PageLoadTimeoutSeconds <= 0)
        {
            throw new FrameworkException("Browser page load timeout must be greater than zero.");
        }

        if (settings.ImplicitWaitSeconds < 0)
        {
            throw new FrameworkException("Browser implicit wait cannot be negative.");
        }
    }
}
