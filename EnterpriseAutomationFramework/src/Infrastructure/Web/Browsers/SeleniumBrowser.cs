using EnterpriseAutomationFramework.Core.Abstractions.Browser;
using EnterpriseAutomationFramework.Core.Models;
using OpenQA.Selenium;

namespace EnterpriseAutomationFramework.Infrastructure.Web.Browsers;

public sealed class SeleniumBrowser : IBrowser
{
    private readonly IWebDriver _driver;

    private bool _disposed;

    public BrowserInfo Info { get; }

    public INavigator Navigator { get; }

    public IElementFinder Elements { get; }

    public IWaitStrategy Wait { get; }

    public IElementActions Actions { get; }

    public string CurrentUrl => _driver.Url;

    public string Title => _driver.Title;

    public SeleniumBrowser(IWebDriver driver, BrowserInfo info,
        INavigator navigator, IElementFinder elements, IWaitStrategy wait,
        IElementActions actions)
    {
        _driver = driver ?? throw new ArgumentNullException(nameof(driver));

        Info = info ?? throw new ArgumentNullException(nameof(info));

        Navigator = navigator ?? throw new ArgumentNullException(nameof(navigator));

        Elements = elements ?? throw new ArgumentNullException(nameof(elements));

        Wait = wait ?? throw new ArgumentNullException(nameof(elements));

        Actions = actions ?? throw new ArgumentNullException(nameof(actions));
    }

    public void Close()
    {
        Dispose();
    }

    public void Dispose()
    {
        if (_disposed) return;

        try
        {
            _driver.Quit();
        }
        finally
        {
            _driver.Dispose();
            _disposed = true;
        }
    }
}
