import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class du {
    private Boolean flagH;
    private Boolean flagC;
    private Boolean flagSi;
    private List<File> names;
    private int sum;

    public du(Boolean H, Boolean C, Boolean Si) {
        this.flagH = H;
        this.flagC = C;
        this.flagSi = Si;
        this.sum = 0;
    }

    public Boolean getFlagH() {
        return flagH;
    }

    public Boolean getFlagC() {
        return flagC;
    }

    public Boolean getFlagSi() {
        return flagSi;
    }

    public List<File> files(File tFile) {
        ArrayList<File> filesList = new ArrayList<>();
        filesList.add(tFile);
        return filesList;
    }

    private static long getFolderSize(File folder) {
        long length = 0;
        File[] files = folder.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isFile()) length += file.length();
            else length += getFolderSize(file);
        }
        return length;
    }

    public List<Long> findLength(File file) {
        List<Long> lengths = new ArrayList<>();
        for (File name : files(file)) {
            if (name.exists() && name.isDirectory())
                lengths.add(getFolderSize(name));
            else if (name.exists() && !name.isDirectory())
                lengths.add(name.length());
        }
        return lengths;
    }

    public List<String> GetHumanFormatSize(File file) {
        List<String> list = new ArrayList<>();
        List<Long> fileSize = new ArrayList<>(findLength(file));
        int base;
        if (this.flagSi) base = 1000;
        else base = 1024;
        if (this.flagH) {
            for (Long length : fileSize) {
                if (length < base)
                    list.add(files(file) + " " + length + " b");
                else if (length < base * base)
                    list.add(files(file) + " " + (double) length / base + " Kb");
                else if (length < base * base * base)
                    list.add(files(file) + " " + (double) length / (base * base) + " Mb");
                else if (length < base * base * base * base)
                    list.add(files(file) + " " + (double) length / (base * base * base) + " Gb");
                this.sum += length;
            }
        } else for (Long length : fileSize) {
            list.add(files(file) + " " + length + " b");
            this.sum += length;
        }
        return list;
    }

    public String prSum() {
        String printSum = "";
        int thisSum = this.sum;
        int base;
        if (this.flagSi) base = 1000;
        else base = 1024;
        if (!this.flagH)
            printSum = "Sum = " + this.sum / base;
        else {
            if (this.sum < base)
                printSum = "Sum = " + thisSum + " b";
            else if (this.sum < base * base)
                printSum = "Sum = " + this.sum / base + " Kb";
            else if (this.sum < base * base * base)
                printSum = "Sum = " + this.sum / (base * base) + " Mb";
            else if (this.sum < base * base * base * base)
                printSum = "Sum = " + this.sum / (base * base * base) + " Gb";
        }
        return printSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
           return true;
        if (o == null || getClass() != o.getClass())
            return false;
        du d = (du) o;
        return flagH == d.flagH &&
               flagC == d.flagC &&
               flagSi == d.flagSi &&
               Objects.equals(names, d.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flagC, flagH, flagSi);
    }
}
