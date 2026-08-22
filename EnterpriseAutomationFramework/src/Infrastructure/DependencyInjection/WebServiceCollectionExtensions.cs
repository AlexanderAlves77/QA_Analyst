using EnterpriseAutomationFramework.Core.Abstractions.Browser;
using EnterpriseAutomationFramework.Core.Configuration;
using EnterpriseAutomationFramework.Core.Validation;
using EnterpriseAutomationFramework.Infrastructure.Web.Browsers;
using EnterpriseAutomationFramework.Infrastructure.Web.Drivers;
using EnterpriseAutomationFramework.Infrastructure.Web.Providers;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

namespace EnterpriseAutomationFramework.Infrastructure.DependencyInjection;

public static class WebServiceCollectionExtensions
{
    public static IServiceCollection AddEafWeb(
        this IServiceCollection services, IConfiguration configuration)
    {
        var browserSettings = configuration
            .GetSection(BrowserSettings.SectionName)
            .Get<BrowserSettings>()
            ?? throw new InvalidOperationException("Browser configuration was not found.");

        var waitSettings = configuration
            .GetSection(WaitSettings.SectionName)
            .Get<WaitSettings>()
            ?? throw new InvalidOperationException("Wait configuration was not found.");

        WaitSettingsValidator.Validate(waitSettings);
        BrowserSettingsValidator.Validate(browserSettings);

        services.AddSingleton(browserSettings);
        services.AddSingleton(waitSettings);

        services.AddSingleton<IWebDriverFactory, SeleniumWebDriverFactory>();

        services.AddTransient<IBrowserFactory, SeleniumBrowserFactory>();

        services.AddScoped<IBrowserProvider, BrowserProvider>();

        return services;
    }
}
