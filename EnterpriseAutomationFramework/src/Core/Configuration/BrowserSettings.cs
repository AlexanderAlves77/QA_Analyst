using EnterpriseAutomationFramework.Core.Enums;

namespace EnterpriseAutomationFramework.Core.Configuration;

public sealed class BrowserSettings
{
    public const string SectionName = "Browser";

    public BrowserType Type { get; set; } = BrowserType.Chrome;

    public bool Headless { get; set; }

    public int WindowWidth { get; init; } = 1920;

    public int WindowHeight { get; init; } = 1080;

    public int PageLoadTimeoutSeconds { get; init; } = 60;

    public int ScriptTimeoutSeconds { get; init; } = 30;

    public int ImplicitWaitSeconds { get; init; } 

    public string? BinaryPath { get; init; }

    public string[] AdditionalArguments { get; init; } = [];
}
