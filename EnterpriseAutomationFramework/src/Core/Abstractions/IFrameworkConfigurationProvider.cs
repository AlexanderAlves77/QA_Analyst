namespace EnterpriseAutomationFramework.Core.Abstractions;

public interface IFrameworkConfigurationProvider
{
    T Get<T>(string sectionName) where T : class, new();
}
