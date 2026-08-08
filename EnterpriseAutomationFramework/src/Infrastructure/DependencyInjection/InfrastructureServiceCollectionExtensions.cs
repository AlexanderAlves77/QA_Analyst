using EnterpriseAutomationFramework.Tests.DependencyInjection;
using Microsoft.Extensions.DependencyInjection;
using Serilog;

namespace EnterpriseAutomationFramework.Infrastructure.DependencyInjection;

public static class InfrastructureServiceCollectionExtensions
{
    public static IServiceCollection AddEafInfrastructure(
        this IServiceCollection services, ILogger logger)
    {
        services.AddEafConfiguration();
        services.AddEafLogging(logger);

        return services;
    }
}
