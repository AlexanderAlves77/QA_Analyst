using Microsoft.VisualBasic;

namespace EnterpriseAutomationFramework.Core.Configuration;

public sealed class LoggingSettings
{
    public const string SectionName = "Logging";

    public string MinimumLevel { get; init; } = "Information";

    public bool EnableConsole { get; init; } = true;

    public bool EnableFile { get; init; } = true;

    public string FilePath { get; init; } = "logs/eaf-.json";
}
