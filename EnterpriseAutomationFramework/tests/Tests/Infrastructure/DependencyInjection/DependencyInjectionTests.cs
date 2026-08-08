using EnterpriseAutomationFramework.Core.Abstractions;
using EnterpriseAutomationFramework.Infrastructure.DependencyInjection;
using EnterpriseAutomationFramework.Infrastructure.Logging;
using Microsoft.Extensions.DependencyInjection;
using Serilog;

namespace EnterpriseAutomationFramework.Tests.Infrastructure.DependencyInjection;

public class DependencyInjectionTests
{
    [Test]
    public void AddEafLogging_ShouldResolveLoggingService()
    {
        var services = new ServiceCollection();

        var logger = new LoggerConfiguration().CreateLogger();

        services.AddEafLogging(logger);

        using var provider = services.BuildServiceProvider();

        var loggingService = provider.GetService<ILoggingService>();

        Assert.That(loggingService, Is.Not.Null);
        Assert.That(loggingService, Is.TypeOf<SerilogLoggingService>());
    }

    [Test]
    public void AddEafLogging_ShouldRegisterLoggingServiceAsSingleton()
    {
        var services = new ServiceCollection();

        var logger = new LoggerConfiguration().CreateLogger();

        services.AddEafLogging(logger);

        using var provider = services.BuildServiceProvider();

        var firstInstance = provider.GetRequiredService<ILoggingService>();

        var secondInstance = provider.GetRequiredService<ILoggingService>();

        Assert.That(secondInstance, Is.SameAs(firstInstance));
    }
}
