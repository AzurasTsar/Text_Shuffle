package testing;
import java.util.ArrayList;
import java.io.*;

import testing.ShuffleTest;

public class ElapsedTimeTest {

	public static void main(String[] args) throws IOException {
			
		  ArrayList<Long> timeList = new ArrayList<Long>();
          ShuffleTest testShuf=new ShuffleTest();
          
		  //testing treeset from start
          for(int i=0; i<500; i++)
          {
        	  long start_time=System.nanoTime();
        	  testShuf.shuffle_with_treeset(1000, "shuffle");
        	  long end_time=System.nanoTime();
        	  long elapsed_time=end_time-start_time;
              System.out.println("Program finished execution in " + elapsed_time + " nanoseconds.");
              timeList.add(elapsed_time);
          }
          
          Writer writer = new BufferedWriter(new FileWriter("Without_Conversion.txt"));
          
          double average=0L;
          
          for(Long times: timeList)
          {
        	  writer.write(times+"\n");
        	  average+=(double)times;
          }
          average /= (double) timeList.size();
          writer.write("Average over " + timeList.size() + " runs: " + average);
          writer.close();
          
          timeList.clear();
          
         /*************************************************************************/
          
      /*    //testing treeset conversion
          for(int i=0; i<500; i++)
          {
        	  long start_time=System.nanoTime();
        	  testShuf.shuffle_with_convert(500, "shuffle");
        	  long end_time=System.nanoTime();
        	  long elapsed_time=end_time-start_time;
              System.out.println("Program finished execution in " + elapsed_time + " nanoseconds.");
              timeList.add(elapsed_time);
          }
          
          Writer writer2 = new BufferedWriter(new FileWriter("With_Conversion.txt"));
          
          double average2=0L;
        	  
          for(Long times: timeList)
          {
        	  writer2.write(times+"\n");
        	  average2+=(double)times;
          }
          average2 /= (double) timeList.size();
          writer2.write("Average over " + timeList.size() + " runs: " + average2);
          writer2.close(); */
	}

}
