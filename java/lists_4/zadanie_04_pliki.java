import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public Main {
    private static List<String> fileNames = List.of("file_1", "file_2", "file_3", "file_4");
    private static String fileContent = "Lorem ipsum dolor sit amet enim. Etiam ullamcorper. Suspendisse a pellentesque dui, non felis. Maecenas malesuada elit lectus felis, malesuada ultricies. Curabitur et ligula. Ut molestie a, ultricies porta urna. Vestibulum commodo volutpat a, convallis ac, laoreet enim. Phasellus fermentum in, dolor. Pellentesque facilisis. Nulla imperdiet sit amet magna. Vestibulum dapibus, mauris nec malesuada fames ac turpis velit, rhoncus eu, luctus et interdum adipiscing wisi. Aliquam erat ac ipsum. Integer aliquam purus. Quisque lorem tortor fringilla sed, vestibulum id, eleifend justo vel bibendum sapien massa ac turpis faucibus orci luctus non, consectetuer lobortis quis, varius in, purus. Integer ultrices posuere cubilia Curae, Nulla ipsum dolor lacus, suscipit adipiscing. Cum sociis natoque penatibus et ultrices volutpat. Nullam wisi ultricies a, gravida vitae, dapibus risus ante sodales lectus blandit eu, tempor diam pede cursus vitae, ultricies eu, faucibus quis, porttitor eros cursus lectus, pellentesque eget, bibendum a, gravida ullamcorper quam. Nullam viverra consectetuer. Quisque cursus et, porttitor risus. Aliquam sem. In hendrerit nulla quam nunc, accumsan congue. Lorem ipsum primis in nibh vel risus. Sed vel lectus. Ut sagittis, ipsum dolor quam.";
    private static List<String> filesContent = new ArrayList<>();
    private static final String PATH = System.getProperty("user.dir") + "/src/files/";

    public static void main(String[] args) {

        createFiles(fileNames);
        saveDataFromFilesToList(fileNames);
        makeFirstLetterUpperAndWriteToFile();
    }

    private static void createFiles(List<String> fileNames) {
        fileNames
                .stream()
                .map(name -> PATH + name + ".txt")
                .forEach(path -> {
                    try {
                        FileOutputStream stream = new FileOutputStream(path);
                        byte[] bytes = fileContent.getBytes(StandardCharsets.UTF_8);
                        stream.write(bytes);
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    private static void saveDataFromFilesToList(List<String> fileNames) {
        fileNames
                .stream()
                .map(name -> PATH + name + ".txt")
                .forEach(path -> {
                    try {
                        Stream<String> stream = Files.lines(Paths.get(path));
                        stream
                                .forEach(data -> filesContent.add(data));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    private static void makeFirstLetterUpperAndWriteToFile() {
        int size = fileNames.size();

        for (int i = 0; i < size; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            List<String> words = List.of(filesContent.get(i).split("\s"));
            for (String word : words) {
                if (word.length() > 1) {
                    stringBuilder.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append("\s");
                } else {
                    stringBuilder.append(word).append("\s");
                }
            }
            saveDataToFile(stringBuilder.toString(), fileNames.get(i));
        }
    }

    private static void saveDataToFile(String content, String fileName) {
        try {
            FileOutputStream stream = new FileOutputStream(PATH + fileName + ".txt");
            byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}