namespace EnterpriseAutomationFramework.Core.Abstractions;

public interface IClock
{
    DateTime Now { get; }

    DateTime UtcNow { get; }
}
