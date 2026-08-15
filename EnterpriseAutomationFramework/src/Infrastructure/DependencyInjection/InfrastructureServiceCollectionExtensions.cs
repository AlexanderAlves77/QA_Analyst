using EnterpriseAutomationFramework.Tests.DependencyInjection;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Serilog;

namespace EnterpriseAutomationFramework.Infrastructure.DependencyInjection;

public static class InfrastructureServiceCollectionExtensions
{
    public static IServiceCollection AddEafInfrastructure(
        this IServiceCollection services,
        IConfiguration configuration, ILogger logger)
    {
        services.AddEafConfiguration(configuration);
        services.AddEafLogging(logger);
        services.AddEafWeb(configuration);

        return services;
    }
}
