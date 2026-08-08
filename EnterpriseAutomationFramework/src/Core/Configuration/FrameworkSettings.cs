namespace EnterpriseAutomationFramework.Core.Configuration;

public sealed class FrameworkSettings
{
    public const string SectionName = "Framework";

    public string Environment { get; init; } = "Development";

    public int DefaultTimeoutSeconds { get; init; } = 30;
}
