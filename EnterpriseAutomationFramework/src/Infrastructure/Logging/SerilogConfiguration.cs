using EnterpriseAutomationFramework.Core.Configuration;
using Serilog;
using Serilog.Formatting.Json;

namespace EnterpriseAutomationFramework.Infrastructure.Logging;

public static class SerilogConfiguration
{
    public static ILogger CreateLogger(LoggingSettings settings)
    {
        var configuration = new LoggerConfiguration()
            .MinimumLevel.Information().Enrich.FromLogContext();

        if (settings.EnableConsole)
        {
            configuration.WriteTo.Console();
        }

        if (settings.EnableFile)
        {
            configuration.WriteTo.File(
                new JsonFormatter(), 
                settings.FilePath, 
                rollingInterval: RollingInterval.Day
            );
        }

        return configuration.CreateLogger();
    }
}
