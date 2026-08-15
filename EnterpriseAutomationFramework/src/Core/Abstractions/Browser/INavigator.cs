namespace EnterpriseAutomationFramework.Core.Abstractions.Browser;

public interface INavigator
{
    void GoTo(string url);

    void Back();

    void Forward();

    void Refresh();
}
