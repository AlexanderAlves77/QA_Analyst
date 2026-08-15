using EnterpriseAutomationFramework.Core.Abstractions.Browser;
using EnterpriseAutomationFramework.Core.Configuration;
using EnterpriseAutomationFramework.Core.Enums;
using EnterpriseAutomationFramework.Core.Models;
using EnterpriseAutomationFramework.Infrastructure.Web.Providers;

namespace EnterpriseAutomationFramework.Tests.Infrastructure.Web;

public class BrowserProviderTests
{
    [Test]
    public void Browser_ShouldReuseInstanceWithinProvider()
    {
        var browser = new FakeBrowser();

        var factory = new FakeBrowserFactory(browser);

        var settings = new BrowserSettings { Type = BrowserType.Chrome };

        using var provider = new BrowserProvider(factory, settings);

        var first = provider.Browser;
        var second = provider.Browser;

        Assert.That(second, Is.SameAs(first));
    }

    private sealed class FakeBrowserFactory : IBrowserFactory
    {
        private readonly IBrowser _browser;

        public FakeBrowserFactory(IBrowser browser)
        {
            _browser = browser;
        }

        public IBrowser Create(BrowserType browserType)
        {
            return _browser;
        }
    }

    private sealed class FakeBrowser : IBrowser
    {
        public BrowserInfo Info => new(BrowserType.Chrome, "Fake Browser");

        public INavigator Navigator => null!;

        public IElementFinder Elements => null!;

        public string CurrentUrl => string.Empty;

        public string Title => string.Empty;

        public void Close() { }

        public void Dispose() { }
    }
}
