using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

namespace EnterpriseAutomationFramework.Infrastructure.Bootstrap;

public sealed class EafBootstrapContext : IDisposable
{
    public IConfiguration Configuration { get; }

    public IServiceProvider Services { get; }

    public string Environment { get; }

    public EafBootstrapContext(IConfiguration configuration, 
        IServiceProvider services, string environment)
    {
        Configuration = configuration;
        Services = services;
        Environment = environment;
    }

    public void Dispose()
    {
        if (Services is IDisposable disposable)
        {
            disposable.Dispose();
        }
    }
}
