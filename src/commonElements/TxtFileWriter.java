package commonElements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TxtFileWriter {
    public TxtFileWriter(String txtFileWriterName) {
        try {
            FileWriter txtFileWriter = new FileWriter(new File(txtFileWriterName));
        } catch (IOException e){
        }
    }
}
