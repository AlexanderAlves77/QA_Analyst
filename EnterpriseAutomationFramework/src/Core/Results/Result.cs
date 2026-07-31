namespace EnterpriseAutomationFramework.Core.Results;

public class Result
{
    public bool Success { get; }

    public bool Failure => !Success;

    public string? Error { get; }

    protected Result(bool success, string? error)
    {
        Success = success;
        Error = error;
    }

    public static Result Ok() => new(true, null);

    public static Result Fail(string error) => new(false, error);
}
