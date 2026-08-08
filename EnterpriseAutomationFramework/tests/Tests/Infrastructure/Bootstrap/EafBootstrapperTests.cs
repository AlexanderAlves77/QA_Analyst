using EnterpriseAutomationFramework.Infrastructure.Bootstrap;
using EnterpriseAutomationFramework.Infrastructure.Configuration;

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
}
