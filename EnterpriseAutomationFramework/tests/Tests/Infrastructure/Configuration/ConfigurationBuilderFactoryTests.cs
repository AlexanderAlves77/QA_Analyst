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

    [Test]
    public void Create_ShouldLoadQAConfiguration_WhenEnvironmentIsQA()
    {
        Environment.SetEnvironmentVariable(EnvironmentVariableName, "QA");

        var configuration = ConfigurationBuilderFactory.Create();

        var environment = configuration["Framework:Environment"];

        Assert.That(environment, Is.EqualTo("QA"));
    }

    [Test]
    public void Create_ShouldPrioritizeEnvironmentVariables()
    {
        Environment.SetEnvironmentVariable(EnvironmentVariableName, "QA");

        Environment.SetEnvironmentVariable("Logging__MinimumLevel", "Debug");

        try
        {
            var configuration = ConfigurationBuilderFactory.Create();

            var minimumLevel = configuration["Logging:MinimumLevel"];

            Assert.That(minimumLevel, Is.EqualTo("Debug"));
        }
        finally
        {
            Environment.SetEnvironmentVariable("Logging__MinimumLevel", null);
        }        
    }
}
