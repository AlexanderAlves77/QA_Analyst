using EnterpriseAutomationFramework.Core.Abstractions.Browser;
using EnterpriseAutomationFramework.Core.Enums;
using EnterpriseAutomationFramework.Core.Models;
using EnterpriseAutomationFramework.Infrastructure.Web.Actions;

namespace EnterpriseAutomationFramework.Tests.Infrastructure.Web;

internal class SeleniumElementActionsTests
{
    [Test]
    public void Click_ShouldWaitUntilClickableAndClick()
    {
        var element = new FakeWebElementWrapper();

        var wait = new FakeWaitStrategy(element);

        var actions = new SeleniumElementActions(wait);

        var locator = new ElementLocator(LocatorType.Id, "login");

        actions.Click(locator);

        Assert.That(element.WasClicked, Is.True);
    }

    [Test]
    public void Click_ShouldClearAndSendKeys_WhenClearFirstIsTrue()
    {
        var element = new FakeWebElementWrapper();

        var wait = new FakeWaitStrategy(element);

        var actions = new SeleniumElementActions(wait);

        var locator = new ElementLocator(LocatorType.Id, "username");

        actions.Type(locator, "Alexander");

        Assert.Multiple(() =>
        {
            Assert.That(element.WasCleared, Is.False);
            Assert.That(element.EnteredText, Is.EqualTo("Alexander"));
        });
    }

    [Test]
    public void Type_ShouldNotClear_WhenClearFirstIsFalse()
    {
        var element = new FakeWebElementWrapper();

        var wait = new FakeWaitStrategy(element);

        var actions = new SeleniumElementActions(wait);

        var locator = new ElementLocator(LocatorType.Id, "username");

        actions.Type(locator, "Alexander", clearFirst: false);

        Assert.Multiple(() =>
        {
            Assert.That(element.WasCleared, Is.True);
            Assert.That(element.EnteredText, Is.EqualTo("Alexander"));
        });
    }

    [Test]
    public void Click_ShouldWaitUntilVisibleAndClear()
    {
        var element = new FakeWebElementWrapper();

        var wait = new FakeWaitStrategy(element);

        var actions = new SeleniumElementActions(wait);

        var locator = new ElementLocator(LocatorType.Id, "username");

        actions.Clear(locator);

        Assert.That(element.WasCleared, Is.True);
    }

    [Test]
    public void GetText_ShouldReturnElementText()
    {
        var element = new FakeWebElementWrapper
        {
            TextValue = "Welcome"
        };

        var wait = new FakeWaitStrategy(element);

        var actions = new SeleniumElementActions(wait);

        var locator = new ElementLocator(LocatorType.Id, "message");

        var result = actions.GetText(locator);

        Assert.That(result, Is.EqualTo("Welcome"));
    }

    [Test]
    public void GetText_ShouldReturnTrue_WhenElementIsVisible()
    {
        var element = new FakeWebElementWrapper();

        var wait = new FakeWaitStrategy(element);

        var actions = new SeleniumElementActions(wait);

        var locator = new ElementLocator(LocatorType.Id, "username");

        var result = actions.IsVisible(locator);

        Assert.That(result, Is.True);
    }

    private sealed class FakeWaitStrategy : IWaitStrategy
    {
        private readonly IWebElementWrapper _element;

        public FakeWaitStrategy(IWebElementWrapper element)
        {
            _element = element;
        }

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
        public bool WasClicked { get; private set; }

        public bool WasCleared { get; private set; }

        public string? EnteredText { get; private set; }

        public string TextValue { get; set; } = string.Empty;

        public string Text => TextValue;

        public bool IsDisplayed => true;

        public bool IsEnabled => true;

        public void Click()
        {
            WasClicked = true;
        }

        public void Clear()
        {
            WasCleared = true;
        }

        public void SendKeys(string text)
        {
            EnteredText = text;
        }

        public string? GetAttribute(string attributeName)
        {
            return null;
        }
    }
}
