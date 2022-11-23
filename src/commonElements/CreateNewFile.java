package commonElements;

import java.io.File;
import java.io.IOException;

public class CreateNewFile {

    public CreateNewFile(String fileToCreate){
        try{
            File newFile = new File(fileToCreate);
            newFile.createNewFile();

            } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
