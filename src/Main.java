import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFile1 = "phones.txt";
        Task1.validatePhoneNumbers(inputFile1);

        String inputFile = "file.txt";
        String outputFile = "user.json";
        List<Task2.User> userList = Task2.readUsersFromFile(inputFile);
        Task2.writeUsersToJsonFile(userList, outputFile);

        String filePath = "words.txt";
        Map<String, Integer> wordFrequency = Task3.calculateWordFrequency(filePath);
        Task3.printWordFrequency(wordFrequency);
    }
}

