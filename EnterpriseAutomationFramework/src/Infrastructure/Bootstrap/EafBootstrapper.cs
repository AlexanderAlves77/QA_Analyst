using EnterpriseAutomationFramework.Core.Configuration;
using EnterpriseAutomationFramework.Core.Validation;
using EnterpriseAutomationFramework.Infrastructure.Configuration;
using EnterpriseAutomationFramework.Infrastructure.DependencyInjection;
using EnterpriseAutomationFramework.Infrastructure.Logging;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

namespace EnterpriseAutomationFramework.Infrastructure.Bootstrap;

public static class EafBootstrapper
{
    public static EafBootstrapContext Initialize()
    {
        var configuration = ConfigurationBuilderFactory.Create();

        var frameworkSettings = configuration
            .GetSection(FrameworkSettings.SectionName)
            .Get<FrameworkSettings>()
            ?? throw new InvalidOperationException(
                "Framework configuration was not found.");

        FrameworkSettingsValidator.Validate(frameworkSettings);

        var loggingSettings = configuration
            .GetSection(LoggingSettings.SectionName)
            .Get<LoggingSettings>()
            ?? throw new InvalidOperationException(
                "Logging configuration was not found.");

        LoggingSettingsValidator.Validate(loggingSettings);

        var logger = SerilogConfiguration.CreateLogger(loggingSettings);

        var services = new ServiceCollection();

        services.AddEafInfrastructure(configuration, logger);

        var serviceProvider = services.BuildServiceProvider(
            new ServiceProviderOptions
            {
                ValidateOnBuild = true,
                ValidateScopes = true
            });


        return new EafBootstrapContext(
            configuration, 
            serviceProvider, 
            frameworkSettings.Environment
        );
    }
}
