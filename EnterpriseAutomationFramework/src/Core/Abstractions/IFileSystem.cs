namespace EnterpriseAutomationFramework.Core.Abstractions;

public interface IFileSystem
{
    bool FileExists(string path);

    string ReadAllText(string path);

    void WriteAllText(string path, string content);
}
