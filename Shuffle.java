/*a simple string shuffling program using ThreadLocalRandom. 
 * Satisfy your curiosity about which shuffle will come up most frequently!
 * made by Nathan McCloud updated Dec 11 2018
 */
package shuffle;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Shuffle
{		
        protected String mostFreq="";
        protected int numMatches=0;
        protected TreeSet<String> t_matching;
        protected HashMap<String,Integer> matchFreq;
		
		TreeSet<String> getMatching()
		{
			return this.t_matching;
		}
		
		String getMostFreq()
		{
			return this.mostFreq;
		}
		
		int getNumMatches()
		{
			return this.numMatches;
		}
		
		HashMap<String, Integer> getMatchFreq()
		{
			return this.matchFreq;
		}

        //use to expand a string to more easily read chars/'aesthetic' text effect
        public void expandString(String s)
        {
                for(int i=0; i<s.length(); i++)
                        System.out.print(s.charAt(i)+"\t");
                System.out.println("\n");
        }


        //helper function to find the most frequent string
        public String mostFreqString(HashMap<String,Integer> h)
        {
                int pp=-1;
                String pu="";
                for(String s: h.keySet())
                        if(h.get(s)>pp)
                        {
                                pp=h.get(s);
                                pu=s;
                        }
                return pu;
        }

        //string shuffle method
        public void shuffle(int iterations, String test)
        {
                int numeq=0;
                String config="";

                matchFreq = new HashMap<String,Integer>();
                HashSet<String> matching = new HashSet<String>();
                ArrayList<String> configs = new ArrayList<String>();
                ArrayList<Character> testList = new ArrayList<Character>();


                for(int p=0; p<iterations; p++)
                {
                        System.out.print(">"+p+"th: \t");
                        for(int i=0; i<test.length(); i++)
                                testList.add(test.charAt(i));
                        while(!testList.isEmpty())
                        {
                                int ind=ThreadLocalRandom.current().nextInt(0, testList.size());
                                System.out.print(testList.get(ind));
                                config+=testList.get(ind);
                                testList.remove(ind);
                        }
                        configs.add(config);
                        config="";
                        System.out.println();
                }
                for(int y=0; y<configs.size(); y++)
                        matchFreq.put(configs.get(y),0);
                for(int g=0; g<configs.size(); g++)
                        for(int k=g; k<configs.size(); k++)
                        {
                                if(configs.get(k).equals(configs.get(g))&&k!=g)
                                {
                                        numeq++;
                                        matching.add(configs.get(k));
                                        matchFreq.put(configs.get(k),matchFreq.get(configs.get(k))+1);
                                }
                        }

                mostFreq=mostFreqString(matchFreq);
                numMatches=matchFreq.get(mostFreq);
                t_matching=new TreeSet<String>(matching);//convert to TreeSet for alphabetical output
                System.out.print(numeq+" identical matchings \nMatched strings: {");
                for(String s: t_matching)
                        System.out.print(s+",");
                System.out.println("}");
                if(matchFreq.get(mostFreq)!=0)
                        System.out.println("Most frequent matching: "+mostFreq+" with "+matchFreq.get(mostFreq)+" matchings");
                else
                        System.out.println("Most frequent matching: None");

             /*   System.out.print("Expand shuffled strings? (y/n)");
                Scanner s=new Scanner(System.in);
                String ans=s.next();
                if(ans.equals("Y")||ans.equals("y")||ans.equals("Yes")||ans.equals("yes"))
                        for(String estring: configs)
                                expandString(estring);
                else
                        System.out.println("Thank you for using Shuffle");
                s.close();*/
        }
        
        private static void init()
        {
        	   Shuffle test01 = new Shuffle();
               Scanner scan=new Scanner(System.in);
               System.out.print("Input word to be shuffled: ");
               String test=scan.next();
               System.out.print("Input number of iterations: ");
               int iterations=scan.nextInt();
               test01.shuffle(iterations, test);
               scan.close();
        }
       
        public static void main(String args[]){
             init();
        }
}
                                                                                                                                                     
                                                                                                              
