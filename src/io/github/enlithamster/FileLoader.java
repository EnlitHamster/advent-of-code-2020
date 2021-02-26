package io.github.enlithamster;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

public class FileLoader {

    // Singleton instance
    private static FileLoader instance;

    public static FileLoader instance() {
        if (instance == null)   try { instance = new FileLoader(); } 
                                catch (Exception e) { e.printStackTrace(); }
        return instance;
    }

    public static File getFile2(String path) throws URISyntaxException {
        URL rsc = FileLoader.class.getResource("/resources/" + path);
        return new File(rsc.toURI());
    }

    // --- Class section

    // Quick access to files using path as key
    private final HashMap<String, File> files;

    private FileLoader() throws IOException, URISyntaxException {
        files = new HashMap<>();
        URL rscDir = getClass().getResource("/one/");
        if (rscDir == null) throw new IOException();
        else {
            File dir = new File(rscDir.toURI());
            extractResources("", dir);
        }

        // --- DEBUG
        for (String key : files.keySet()) System.out.println(files.get(key).getPath());
    }

    /**
     * Recursively loads all resources from a folder.
     * The files are added to the files map of the FileLoader.
     * 
     * @param path Directory path of the reached level
     * @param rscDir Directory being explored
     */
    private void extractResources(String path, File rscDir) {
        for (File nextFile : rscDir.listFiles()) {
            String filePath = path + nextFile.getName();
            if (nextFile.isDirectory()) extractResources(filePath + "/", nextFile);
            else files.put(filePath, nextFile);
        }
    }

    /**
     * Returns the given file if present in the resources directory.
     * 
     * @param path Path from /resources/
     * @return The file if found
     * @throws FileNotFoundException If the file does not exist
     */
    public File getFile(String path) throws FileNotFoundException {
        if (files.containsKey(path)) return files.get(path);
        else throw new FileNotFoundException();
    }

}
