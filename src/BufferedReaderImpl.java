import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderImpl implements ILineReader
{
	private BufferedReader bufferedReader;
	public BufferedReaderImpl(String inputFilePath)
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));	
			this.bufferedReader = reader;
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public String readLine() throws IOException
	{
		String line = this.bufferedReader.readLine();
		return line;
	}
}