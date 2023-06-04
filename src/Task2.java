import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    static List<User> readUsersFromFile(String inputFile) {
        List<User> userList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String header = reader.readLine(); // Пропускаємо перший рядок з заголовком

            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);

                User user = new User(name, age);
                userList.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userList;
    }

    static void writeUsersToJsonFile(List<User> userList, String outputFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("[\n");
            for (int i = 0; i < userList.size(); i++) {
                User user = userList.get(i);
                writer.write("    {\n");
                writer.write("        \"name\": \"" + user.getName() + "\",\n");
                writer.write("        \"age\": " + user.getAge() + "\n");
                if (i < userList.size() - 1) {
                    writer.write("    },\n");
                } else {
                    writer.write("    }\n");
                }
            }
            writer.write("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
