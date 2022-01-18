import archive.GithubConfig;
import archive.MarkdownGenerator;

public class ArchiveLauncher {
    public static void main(String[] args) {
        GithubConfig config = new GithubConfig("yhh1056", "studyAlgorithm", "main");
        MarkdownGenerator generator = new MarkdownGenerator(config);
        generator.generate();
    }
}
