package File;

import dto.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyFileWriter {
    public void writeUserDataFromDbToFile(String filePath, List<User> users) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
            for (User user : users) {
                bw.write("ID: " + user.id() + " -------- Name: " + user.name() + "-------- Email: " + user.email());
                bw.newLine();
            }
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
