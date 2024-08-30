package org.snoflo;

public class Test {

    public static void main(String[] args) {

        String rootDirectory = System.getProperty("user.dir");
        String csv = "library.csv";
        String word = rootDirectory + "/src/main/resources/" + csv;
        System.out.println(word);

        StringBuilder word2 = new StringBuilder();
        word2.append(rootDirectory)
                .append("/src/main/resources/")
                .append(csv);

        System.out.println(word2);
    }
}
