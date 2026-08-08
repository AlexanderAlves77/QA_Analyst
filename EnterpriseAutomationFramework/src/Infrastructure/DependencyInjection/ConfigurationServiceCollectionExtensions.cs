using EnterpriseAutomationFramework.Core.Abstractions;
using EnterpriseAutomationFramework.Infrastructure.Configuration;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

namespace EnterpriseAutomationFramework.Tests.DependencyInjection;

public static class ConfigurationServiceCollectionExtensions
{
    public static IServiceCollection AddEafConfiguration(
        this IServiceCollection services, IConfiguration configuration)
    {
        services.AddSingleton(configuration);

        services.AddSingleton<IFrameworkConfigurationProvider, 
            JsonConfigurationProvider>();
        
        return services;
    }
}
