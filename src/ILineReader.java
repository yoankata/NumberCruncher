import java.io.IOException;

@FunctionalInterface
public interface ILineReader
{
	public String readLine() throws IOException;
}