using EnterpriseAutomationFramework.Core.Abstractions.Browser;
using EnterpriseAutomationFramework.Core.Enums;
using EnterpriseAutomationFramework.Core.Models;
using EnterpriseAutomationFramework.Infrastructure.Web.Actions;
using EnterpriseAutomationFramework.Infrastructure.Web.Pages;

namespace EnterpriseAutomationFramework.Tests.Infrastructure.Web;

internal class LoginPageTests
{
    [Test]
    public void GoTo_ShouldNavigateToProvidedUrl()
    {
        var browser = new FakeBrowser();

        var page = new LoginPage(browser);

        const string url = "https://example.com/login";

        page.GoTo(url);

        Assert.That(browser.NavigatorFake.LastUrl, Is.EqualTo(url));
    }

    [Test]
    public void EnterUsername_ShouldTypeUsername()
    {
        var browser = new FakeBrowser();

        var page = new LoginPage(browser);

        page.EnterUsername("Alexander");

        Assert.Multiple(() =>
        {
            Assert.That(browser.ActionsFake.LastTypedText, Is.EqualTo("Alexander"));

            Assert.That(browser.ActionsFake.LastTypedLocator, Is.Not.Null);

            Assert.That(browser.ActionsFake.LastTypedLocator!.Type, 
                Is.EqualTo(LocatorType.Id));

            Assert.That(browser.ActionsFake.LastTypedLocator.Value, 
                Is.EqualTo("username"));
        });
    }

    [Test]
    public void EnterPassword_ShouldTypePassword()
    {
        var browser = new FakeBrowser();

        var page = new LoginPage(browser);

        page.EnterPassword("123456");

        Assert.Multiple(() =>
        {
            Assert.That(browser.ActionsFake.LastTypedText, Is.EqualTo("123456"));

            Assert.That(browser.ActionsFake.LastTypedLocator, Is.Not.Null);

            Assert.That(browser.ActionsFake.LastTypedLocator!.Type, 
                Is.EqualTo(LocatorType.Id));

            Assert.That(browser.ActionsFake.LastTypedLocator.Value, 
                Is.EqualTo("password"));
        });
    }

    [Test]
    public void ClickLogin_ShouldClickLoginButton()
    {
        var browser = new FakeBrowser();

        var page = new LoginPage(browser);

        page.ClickLogin();

        Assert.Multiple(() =>
        {
            Assert.That(
                browser.ActionsFake.LastClickedLocator,
                Is.Not.Null);

            Assert.That(
                browser.ActionsFake.LastClickedLocator!.Type,
                Is.EqualTo(LocatorType.CssSelector));

            Assert.That(
                browser.ActionsFake.LastClickedLocator.Value,
                Is.EqualTo("button[type='submit']"));
        });
    }

    [Test]
    public void Login_ShouldTypeCredentialsAndClickLogin()
    {
        var browser = new FakeBrowser();

        var page = new LoginPage(browser);

        page.Login("Alexander", "123456");

        Assert.Multiple(() =>
        {
            Assert.That(
                browser.ActionsFake.TypedActions.Count,
                Is.EqualTo(2));

            Assert.That(
                browser.ActionsFake.TypedActions[0].Locator.Value,
                Is.EqualTo("username"));

            Assert.That(
                browser.ActionsFake.TypedActions[0].Text,
                Is.EqualTo("Alexander"));

            Assert.That(
                browser.ActionsFake.TypedActions[1].Locator.Value,
                Is.EqualTo("password"));

            Assert.That(
                browser.ActionsFake.TypedActions[1].Text,
                Is.EqualTo("123456"));

            Assert.That(
                browser.ActionsFake.LastClickedLocator,
                Is.Not.Null);

            Assert.That(
                browser.ActionsFake.LastClickedLocator!.Value,
                Is.EqualTo("button[type='submit']"));
        });
    }

    private sealed class FakeBrowser : IBrowser
    {
        public FakeNavigator NavigatorFake { get; } = new();

        public FakeElementActions ActionsFake { get; } = new();

        public BrowserInfo Info => new(BrowserType.Chrome, "Fake Browser");

        public INavigator Navigator => NavigatorFake;

        public IElementFinder Elements => new FakeElementFinder();

        public IWaitStrategy Wait => new FakeWaitStrategy();

        public IElementActions Actions => ActionsFake;

        public string CurrentUrl => NavigatorFake.LastUrl ?? string.Empty;

        public string Title => string.Empty;

        public void Close()
        {
        }

        public void Dispose()
        {
        }
    }

    private sealed class FakeNavigator : INavigator
    {
        public string? LastUrl { get; private set; }

        public bool BackCalled { get; private set; }

        public bool ForwardCalled { get; private set; }

        public bool RefreshCalled { get; private set; }

        public void GoTo(string url)
        {
            LastUrl = url;
        }

        public void Back()
        {
            BackCalled = true;
        }

        public void Forward()
        {
            ForwardCalled = true;
        }

        public void Refresh()
        {
            RefreshCalled = true;
        }
    }

    private sealed class FakeElementActions : IElementActions
    {
        public ElementLocator? LastClickedLocator { get; private set; }

        public ElementLocator? LastTypedLocator { get; private set; }

        public string? LastTypedText { get; private set; }

        public List<TypedAction> TypedActions { get; } = [];

        public void Click(ElementLocator locator)
        {
            LastClickedLocator = locator;
        }

        public void Type(ElementLocator locator, string text, bool clearFirst = true)
        {
            LastTypedLocator = locator;
            LastTypedText = text;

            TypedActions.Add(new TypedAction(locator, text, clearFirst));
        }

        public void Clear(ElementLocator locator)
        {
        }

        public string GetText(ElementLocator locator)
        {
            return string.Empty;
        }

        public bool IsVisible(ElementLocator locator)
        {
            return true;
        }
    }

    private sealed class FakeElementFinder : IElementFinder
    {
        public IWebElementWrapper Find(ElementLocator locator)
        {
            return new FakeWebElementWrapper();
        }

        public IReadOnlyCollection<IWebElementWrapper> FindAll(ElementLocator locator)
        {
            return Array.Empty<IWebElementWrapper>();
        }
    }

    private sealed class FakeWaitStrategy : IWaitStrategy
    {
        private readonly IWebElementWrapper _element =
            new FakeWebElementWrapper();

        public IWebElementWrapper UntilPresent(ElementLocator locator)
        {
            return _element;
        }

        public IWebElementWrapper UntilVisible(ElementLocator locator)
        {
            return _element;
        }

        public IWebElementWrapper UntilClickable(ElementLocator locator)
        {
            return _element;
        }

        public bool UntilInvisible(ElementLocator locator)
        {
            return true;
        }
    }

    private sealed class FakeWebElementWrapper : IWebElementWrapper
    {
        public string Text => string.Empty;

        public bool IsDisplayed => true;

        public bool IsEnabled => true;

        public void Click()
        {
        }

        public void Clear()
        {
        }

        public void SendKeys(string text)
        {
        }

        public string? GetAttribute(string attributeName)
        {
            return null;
        }
    }

    private sealed record TypedAction(ElementLocator Locator, 
        string Text, bool ClearFirst);
}
