package xyz.dreeks.trailz.trails;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

import xyz.dreeks.trailz.utils.Constants;

public class TrailsLoader {

    public static void load() {
        if (!Constants.TRAILS_FOLDER.exists()) Constants.TRAILS_FOLDER.mkdirs();
        Constants.TRAILS.clear();

        for (File f : Constants.TRAILS_FOLDER.listFiles(new TextFilter())) {
            try (BufferedReader br = new BufferedReader(new FileReader(f))){
                Trail t = new Trail();

                t.setName(br.readLine());
                t.setUUID(br.readLine());
                t.setCreator(br.readLine());
                t.setTexture(br.readLine());

                Constants.TRAILS.add(t);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
			}
        }
    }

    public static void write(Trail t) {
        if (!Constants.TRAILS_FOLDER.exists()) Constants.TRAILS_FOLDER.mkdirs();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(getUniqueFile(t)))) {
            writeLine(bw, t.getName());
            writeLine(bw, t.getUUID());
            writeLine(bw, t.getCreator());
            writeLine(bw, t.getTexture());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static File getUniqueFile(Trail t) {
        String name     = t.getName();
        File   baseFile = new File(Constants.TRAILS_FOLDER, name + ".txt");

        if (!baseFile.exists()) return baseFile;

        boolean found = false;
        int i = 1;
        while (!found) {
            baseFile = new File(Constants.TRAILS_FOLDER, name + "_" + i + ".txt");
            found = !baseFile.exists();
        }

        return baseFile;
    }

    private static void writeLine(BufferedWriter bw, String s) throws IOException {
        bw.write(s);
        bw.newLine();
    }
}

class TextFilter implements FilenameFilter {

    public boolean accept(File dir, String name) {
        if (name.lastIndexOf('.') > 0) {
            String ext = name.substring(name.lastIndexOf('.'));
            return ext.equalsIgnoreCase(".txt");
        }

        return false;
    }

}