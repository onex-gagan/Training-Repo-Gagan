package File;

import dto.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MyFileReader {

    public static void printFile(String filePath){
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<User> getAllUsers(String filePath) {
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines().skip(1)
                    .map(MyFileReader::getUserDetails)
                    .map(MyFileReader::createDtoFromDetails)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return List.of(); // return empty list in case of error
    }

    private static List<String> getUserDetails(String userDetails) {
        return List.of(userDetails.split(","));
    }

    private static User createDtoFromDetails(List<String> userDetails) {
        return new User(
                Integer.parseInt(userDetails.get(0)),
                userDetails.get(1),
                userDetails.get(2)
        );
    }
}
