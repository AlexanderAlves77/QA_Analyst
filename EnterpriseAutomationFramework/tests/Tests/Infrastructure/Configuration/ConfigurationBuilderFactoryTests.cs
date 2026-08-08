using EnterpriseAutomationFramework.Infrastructure.Configuration;

namespace EnterpriseAutomationFramework.Tests.Infrastructure.Configuration;

public class ConfigurationBuilderFactoryTests
{
    private const string EnvironmentVariableName = "EAF_ENVIRONMENT";

    [TearDown]
    public void TearDown()
    {
        Environment.SetEnvironmentVariable(EnvironmentVariableName, null);
    }

    [Test]
    public void Create_ShouldUseDevelopment_WhenEnvironmentIsNotDefined()
    {
        Environment.SetEnvironmentVariable(EnvironmentVariableName, null);

        var configuration = ConfigurationBuilderFactory.Create();

        var environment = configuration["Framework:Environment"];

        Assert.That(environment, Is.EqualTo("Development"));
    }
}
