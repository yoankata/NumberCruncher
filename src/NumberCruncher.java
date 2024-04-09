import java.util.ArrayList;

public class NumberCruncher 
{ 
	public static void main(String[] args) throws InterruptedException {
		System.out.println(System.getProperty("user.dir"));
		String inputFilePath = "input.csv";
		String outputFilePath = "output.csv";
		
        // lambda expression to define the calculate method
        IValueProcessor sumValuesFn = (double x, double y) -> x + y;
        IValueProcessor multiplyValuesFn = (double x, double y) -> x * y;
        
        ArrayList<Double> listAddition = new ArrayList<Double>(1000000);
        ArrayList<Double> listMultiplication = new ArrayList<Double>(1000000);
		

		Thread adderThread = new Thread(() -> NumberCruncherFunctions.lineProcessor(new BufferedReaderImpl(inputFilePath), sumValuesFn, listAddition, ","));
		Thread multiplierThread = new Thread(() -> NumberCruncherFunctions.lineProcessor(new BufferedReaderImpl(inputFilePath), multiplyValuesFn, listMultiplication, ","));
		adderThread.start();
		multiplierThread.start();

		try 
		{
			adderThread.join();
		    multiplierThread.join();
		} catch (InterruptedException e) 
		{
		    e.printStackTrace();
		}
		
	     BufferedWriterImpl bufferedWriter = new BufferedWriterImpl(outputFilePath); 
	     NumberCruncherFunctions.lineWriter(bufferedWriter, outputFilePath, "#sum", "#prod", listAddition, listMultiplication);
	}
}

