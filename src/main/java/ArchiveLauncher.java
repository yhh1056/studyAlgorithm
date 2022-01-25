import archive.algorithm.archive.GithubConfig;
import archive.algorithm.file.DefaultBaekjoonMarkdownGenerator;
import archive.algorithm.file.MarkdownGenerator;

public class ArchiveLauncher {
    public static void main(String[] args) {
        GithubConfig config = new GithubConfig("yhh1056", "studyAlgorithm", "main");
        ArchiveLauncher launcher = new ArchiveLauncher();
        launcher.run(new DefaultBaekjoonMarkdownGenerator(config));
    }

    public void run(MarkdownGenerator... generators) {
        for (MarkdownGenerator generator : generators) {
            generator.generate();
        }
    }
}
