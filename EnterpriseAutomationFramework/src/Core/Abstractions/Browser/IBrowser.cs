using EnterpriseAutomationFramework.Core.Models;

namespace EnterpriseAutomationFramework.Core.Abstractions.Browser;

public interface IBrowser : IDisposable
{
    BrowserInfo Info { get; }

    INavigator Navigator { get; }

    IElementFinder Elements { get; }

    string CurrentUrl { get; }

    string Title { get; }

    void Close();
}
