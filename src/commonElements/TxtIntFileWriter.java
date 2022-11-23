package commonElements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TxtIntFileWriter {
    public TxtIntFileWriter(String txtFileWriterName) {
        try {
            FileWriter txtFileWriter = new FileWriter(new File(txtFileWriterName));
            //txtFileWriter.write(String.valueOf());
        } catch (IOException e){
        }
    }
    public void write(){

    }
}
