namespace EnterpriseAutomationFramework.Core.Results;

public class Result<T> : Result
{
    public T? Value { get; }

    private Result(T value) : base(true, null)
    {
        this.Value = value;
    }

    private Result(string error) : base(false, error)
    {
        this.Value = default;
    }

    public static Result<T> Ok(T value) => new(value);

    public static new Result<T> Fail(string error) => new(error);
}
