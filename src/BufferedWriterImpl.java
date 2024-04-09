import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterImpl implements ILineWriter
{
	private BufferedWriter bufferedWriter;
	
	public BufferedWriterImpl(String outputFilePath)
	{
		try
		{
			this.bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void write(String cbuff) throws IOException
	{
		this.bufferedWriter.write(cbuff);
		this.bufferedWriter.flush();		
	}


	@Override
	public void flush() throws IOException 
	{
		this.bufferedWriter.flush();		
	}

	@Override
	public void close() throws IOException 
	{
		this.bufferedWriter.close();
	}
}
