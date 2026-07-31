namespace EnterpriseAutomationFramework.Core.Exceptions;

public class FrameworkException : Exception
{
    public string ErrorCode { get; }

    public FrameworkException(string message) : base(message)
    {
        ErrorCode = GetType().Name;
    }

    public FrameworkException(string message, Exception innerException) 
        : base(message, innerException)
    {
        ErrorCode = GetType().Name;
    }
}
