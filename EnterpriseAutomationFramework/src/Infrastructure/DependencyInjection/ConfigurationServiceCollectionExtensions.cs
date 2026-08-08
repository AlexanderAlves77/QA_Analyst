using EnterpriseAutomationFramework.Core.Abstractions;
using EnterpriseAutomationFramework.Infrastructure.Configuration;
using Microsoft.Extensions.DependencyInjection;

namespace EnterpriseAutomationFramework.Tests.DependencyInjection;

public static class ConfigurationServiceCollectionExtensions
{
    public static IServiceCollection AddEafConfiguration(
        this IServiceCollection services)
    {
        services.AddSingleton<IFrameworkConfigurationProvider, 
            JsonConfigurationProvider>();
        
        return services;
    }
}
