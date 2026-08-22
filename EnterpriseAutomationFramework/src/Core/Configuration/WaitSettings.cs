namespace EnterpriseAutomationFramework.Core.Configuration;

public sealed class WaitSettings
{
    public const string SectionName = "Wait";

    public int DefaultTimeoutSeconds { get; init; } = 15;

    public int PollingIntervalMilliseconds { get; init; } = 500;
}
