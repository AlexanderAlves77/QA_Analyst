using EnterpriseAutomationFramework.Core.Abstractions;
using Microsoft.Extensions.Configuration;

namespace EnterpriseAutomationFramework.Infrastructure.Configuration;

public sealed class JsonConfigurationProvider : IFrameworkConfigurationProvider
{
    private readonly IConfiguration _configuration;

    public JsonConfigurationProvider(IConfiguration configuration)
    {
        _configuration = configuration;
    }

    public T Get<T>(string sectionName) where T : class, new()
    {
        var settings = new T();

        _configuration.GetSection(sectionName).Bind(settings);

        return settings;
    }
}
