package xyz.dreeks.trailz.trails;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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