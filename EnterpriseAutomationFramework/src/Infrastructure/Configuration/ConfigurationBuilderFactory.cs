using EnterpriseAutomationFramework.Core.Constants;
using Microsoft.Extensions.Configuration;

namespace EnterpriseAutomationFramework.Infrastructure.Configuration;

public static class ConfigurationBuilderFactory
{
    private const string EnvironmentVariableName = "EAF_ENVIRONMENT";

    public static IConfigurationRoot Create()
    {
        var environment = Environment.GetEnvironmentVariable(EnvironmentVariableName)
                ?? EnvironmentNames.Development;

        return new ConfigurationBuilder()
            .SetBasePath(AppContext.BaseDirectory)
            .AddJsonFile(
                "appsettings.json",
                optional: false,
                reloadOnChange: false)
            .AddJsonFile(
                $"appsettings.{environment}.json",
                optional: true,
                reloadOnChange: false)
            .AddEnvironmentVariables()
            .Build();
    }
}
