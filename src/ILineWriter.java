import java.io.IOException;

public interface ILineWriter {

	public void write(String cbuff)  throws IOException;
	public void flush()  throws IOException;
	public void close()  throws IOException;
}
