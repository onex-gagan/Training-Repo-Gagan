package org.example.fileIO;

import File.FilePathUtil;
import File.MyFileReader;
import File.MyFileWriter;
import dto.User;
import repository.UserRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyFileReader myFileReader = new MyFileReader();
        FilePathUtil filePathUtil = new FilePathUtil();
        String FILE_PATH = filePathUtil.getAbsoluteFilePath();
        String WRITABLE_FILE_PATH = filePathUtil.getWritableFilePath();
        List<User> users = myFileReader.getAllUsers(FILE_PATH);

        // Saving the users from the CSV to the DB
        UserRepository userRepository = new UserRepository();
        try {
//            userRepository.saveUsersToDb(users);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        List<User> usersFetchedFromDb = userRepository.getAllUsersFromDb();
//        for (User user : usersFetchedFromDb) {
//            System.out.println(user);
//        }
        MyFileWriter myFileWriter = new MyFileWriter();
        myFileWriter.writeUserDataFromDbToFile(WRITABLE_FILE_PATH, usersFetchedFromDb);

    }
}