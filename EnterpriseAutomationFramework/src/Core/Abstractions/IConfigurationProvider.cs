namespace EnterpriseAutomationFramework.Core.Abstractions;

public interface IConfigurationProvider
{
    T Get<T>(string sectionName) where T : class, new();
}
