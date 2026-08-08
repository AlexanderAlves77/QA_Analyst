using EnterpriseAutomationFramework.Core.Abstractions;
using EnterpriseAutomationFramework.Infrastructure.Logging;
using Microsoft.Extensions.DependencyInjection;
using Serilog;

namespace EnterpriseAutomationFramework.Infrastructure.DependencyInjection;

public static class LoggingServiceCollectionExtensions
{
    public static IServiceCollection AddEafLogging(this IServiceCollection services,
        ILogger logger)
    {
        services.AddSingleton(logger);

        services.AddSingleton<ILoggingService, SerilogLoggingService>();

        return services;
    }
}
