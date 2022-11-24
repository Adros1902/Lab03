package commonElements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TxtIntFileWriter {
    public void writeInt(String txtFileWriterName, int intToWrite) throws IOException {
        FileWriter txtFileWriter = new FileWriter(new File(txtFileWriterName),true);
        txtFileWriter.write(String.valueOf(intToWrite));
        txtFileWriter.close();
    }
    public void clearFile(String txtFileWriterName) throws IOException {
        FileWriter txtFileWriter = new FileWriter(new File(txtFileWriterName));
        txtFileWriter.close();
    }
    public void writerReplaceInt(String txtFileWriterName, int intToWrite) throws IOException {
        FileWriter txtFileWriter = new FileWriter(new File(txtFileWriterName));
    }
}
