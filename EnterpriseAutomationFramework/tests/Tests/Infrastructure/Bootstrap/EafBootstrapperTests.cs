using EnterpriseAutomationFramework.Core.Abstractions;
using EnterpriseAutomationFramework.Infrastructure.Bootstrap;
using EnterpriseAutomationFramework.Infrastructure.Configuration;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

namespace EnterpriseAutomationFramework.Tests.Infrastructure.Bootstrap;

public class EafBootstrapperTests
{
    private const string EnvironmentVariableName = "EAF_ENVIRONMENT";

    [TearDown]
    public void TearDown()
    {
        Environment.SetEnvironmentVariable(EnvironmentVariableName, null);
    }

    [Test]
    public void Initialize_ShouldCreateBootstrapContext()
    {
        Environment.SetEnvironmentVariable(EnvironmentVariableName, "Development");

        using var context = EafBootstrapper.Initialize();

        Assert.That(context, Is.Not.Null);
        Assert.That(context.Configuration, Is.Not.Null);
        Assert.That(context.Services, Is.Not.Null);
    }

    [Test]
    public void Initialize_ShouldUseConfiguredEnvironment()
    {
        Environment.SetEnvironmentVariable(EnvironmentVariableName, "QA");

        using var context = EafBootstrapper.Initialize();

        Assert.That(context.Environment, Is.EqualTo("QA"));
    }

    [Test]
    public void Initialize_ShouldResolveLoggingService()
    {
        Environment.SetEnvironmentVariable(EnvironmentVariableName, "Development");

        using var context = EafBootstrapper.Initialize();

        var loggingService = context.Services.GetService<ILoggingService>();

        Assert.That(loggingService, Is.Not.Null);
    }

    [Test]
    public void Initialize_ShouldShareConfigurationWithContainer()
    {
        Environment.SetEnvironmentVariable(EnvironmentVariableName, "Development");

        using var context = EafBootstrapper.Initialize();

        var resolvedConfiguration = context.Services.GetService<IConfiguration>();

        Assert.That(resolvedConfiguration, Is.SameAs(context.Configuration));
    }
}
