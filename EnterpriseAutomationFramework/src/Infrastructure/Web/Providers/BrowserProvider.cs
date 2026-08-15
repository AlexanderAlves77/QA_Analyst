using EnterpriseAutomationFramework.Core.Abstractions.Browser;
using EnterpriseAutomationFramework.Core.Configuration;

namespace EnterpriseAutomationFramework.Infrastructure.Web.Providers;

public sealed class BrowserProvider : IBrowserProvider, IDisposable
{
    private readonly IBrowserFactory _browserFactory;
    private readonly BrowserSettings _settings;

    private IBrowser? _browser;

    public BrowserProvider(IBrowserFactory browserFactory, BrowserSettings settings)
    {
        _browserFactory = browserFactory;
        _settings = settings;
    }

    public IBrowser Browser
    {
        get
        {
            _browser ?? = _browserFactory.Create(_settings.Type);
            return _browser;
        }
    }

    public void Dispose()
    {
        _browser?.Dispose();
        _browser = null;
    }
}
