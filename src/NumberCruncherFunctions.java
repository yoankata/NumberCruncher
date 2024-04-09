import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

public class NumberCruncherFunctions {
	  public static void lineProcessor(ILineReader reader, IValueProcessor processingFunction, List<Double> resultList, String regEx) 
	    {

			String line;
			try 
			{
				line = reader.readLine();  //skip header line
			} catch (IOException e) 
			{
				e.printStackTrace();
			} 
			
			try 
			{
				while ((line = reader.readLine()) != null) 
				{
					String[] tokens = line.split(regEx);
					double i = Double.parseDouble(tokens[0]);
					double number = Double.parseDouble(tokens[1]);
					double res = processingFunction.calculate(i, number);
					resultList.add(res);
				}
			} catch (NumberFormatException e) 
			{
				e.printStackTrace();
			} catch (IOException e) 
			{
				e.printStackTrace();
			}

	    }
	    
	    public static void lineWriter(ILineWriter writer, String outputFilePath, String header1, String header2, List<Double> firstColumn, List<Double> secondColumn)
	    {
			try 
			{
				try 
				{
					writer.write(MessageFormat.format("{0}, {1}\n", header1, header2)); //header line
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
				
				if(firstColumn.size() != secondColumn.size())
				{
					throw new IOException("The size of first and second column are expected to be the same!");
				}

				for (int i = 1; i < secondColumn.size(); i++) 
				{
					writer.write(MessageFormat.format("{0}, {1}\n", firstColumn.get(i), secondColumn.get(i)));
				}
				
				writer.flush();
			    System.out.println("Data is flushed to the file.");
		
		        writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
}
