using EnterpriseAutomationFramework.Core.Abstractions;
using Serilog;

namespace EnterpriseAutomationFramework.Infrastructure.Logging;

public sealed class SerilogLoggingService : ILoggingService
{
    private readonly ILogger _logger;

    public SerilogLoggingService(ILogger logger)
    {
        _logger = logger;
    }

    public void Debug(string message) { _logger.Debug(message); }

    public void Information(string message) { _logger.Information(message); }

    public void Warning(string message) { _logger.Warning(message); }

    public void Error(string message) { _logger.Error(message); }

    public void Error(Exception exception, string message) 
    { 
        _logger.Error(exception, message); 
    }
}
