import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.util.ArrayList;

public class Main {
    @Option(name = "-h")
    private boolean flagH;

    @Option(name = "-c")
    private boolean flagC;

    @Option(name = "--si")
    private boolean flagSi;

    @Argument(required = true)
    private ArrayList<File> names;

    public Main() {
    }

    private void argument(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        du du1 = new du(flagH, flagC, flagSi);
        try {
            if (!names.isEmpty()) {
                for (File name : names) {
                    System.out.println(du1.GetHumanFormatSize(name));
                }
            }
            if (flagC) {
                System.out.println(du1.prSum());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
    public static void main(String[] args) {
        new Main().argument(args);
    }
}
