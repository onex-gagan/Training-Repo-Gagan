package File;

public class FilePathUtil {
    final String FILE_PATH = "/home/onextel1/Desktop/File_IO/src/main/java/Resources/users.csv";

    final String WRITABLE_FILE_PATH = "/home/onextel1/Desktop/File_IO/src/main/java/Resources/usersFromDb.txt";


    public String getAbsoluteFilePath(){
        return this.FILE_PATH;
    }

    public String getWritableFilePath(){
        return this.WRITABLE_FILE_PATH;
    }
}
