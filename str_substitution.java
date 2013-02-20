import java.io.*;
import java.util.HashSet;

public class str_substitution {

  static HashSet<Integer> set = new HashSet<Integer>();
	
	static String findNrpl(String tar,String s1,String s2)
	{
	
		for(int i = 0; i < tar.length(); i++)
		{
			int pos = tar.indexOf(s1,i);
			
			if(pos == -1)
			{
				return tar;
			}
			else 
			{    
				    if(canSub(pos,pos + s1.length() - 1))
				    {
				    	  	String mid = tar.substring(pos, pos + s1.length()).replace(s1, s2);
				    	    
				    		tar = tar.substring(0, pos) + mid + tar.substring( pos + s1.length());
				    		
				    		if(s1.length() == s2.length())
				    		{
				    			
				    			for(int j = pos; j < pos + s1.length(); j++)
								{
									set.add(j);
								}
								
				    			
				    		}
				    		else
				    		{
				    			if(s1.length() > s2.length())
				    			{
				    				
				    				for(Integer e : set)
				    				{
				    					if(e >= pos + s1.length()) e = e - (s1.length() - s2.length());
				    				}
				    				
				    				for(int j = pos; j < pos + s2.length(); j++)
								{
										set.add(j);
								}
				    				
				    			}
				    			else
				    			{
				    				
				    				for(Integer e : set)
				    				{
				    					if(e >= pos + s1.length()) e = e + (s1.length() - s2.length());
				    				}
				    				
				    				for(int j = pos; j < pos + s2.length(); j++)
								{
										set.add(j);
								}
				    				
				    			}
				    			
				    			
				    		}
				    		
				    		i = pos + s2.length() - 1;
				    	
				    }
				    else
				    {
				    	i = pos;
				    }
						
			}
			
		}
		
		return tar;
	}
	
	
	static boolean canSub(int start,int end)
	{
		
		for(int idx = start; idx <= end; idx++)
		{
			if(!set.contains(idx)) continue;
			else
				return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		 File file = new File(args[0]);
		 BufferedReader in = new BufferedReader(new FileReader(file));
		 String line;
		 while ((line = in.readLine()) != null) 
		 {
			 String[] str = line.split(";");
			 String tarstr = str[0];
			 String repstr = str[1];
			 
			 String[] Replace = repstr.split(",");
			 
			 for(int idxR = 0; idxR < Replace.length - 1; idxR += 2)
			 {
				 tarstr = findNrpl(tarstr,Replace[idxR],Replace[idxR + 1]);
			 }
			 System.out.println(tarstr);
			
		 }
		
		 in.close();
		 System.exit(0);
	}

}
