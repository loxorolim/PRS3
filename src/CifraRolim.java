import java.util.ArrayList;
import java.util.Arrays;


public class CifraRolim 
{

	//String message;

	public static String cipher(String message,String key)
	{
		if(key.length() == 0)
			return message;
		if(key.length() > message.length())
			key = key.substring(0,message.length());
		key = removeDuplicates(key);
		String ret = "";
		int[] order = getKeyNumber(key);
		int messageSize = message.length();
		int numberOfLines = (messageSize/key.length());
		if(messageSize % key.length() != 0)
			numberOfLines++;
		int numberOfColumns = key.length();
		char[][] matrix = new char[numberOfLines][numberOfColumns];
		int msgPos = 0;
		for(int i = 0; i < numberOfLines ; i++)
		{
			for(int j = 0; j < numberOfColumns ; j++)
			{
				if(msgPos < message.length())
					matrix[i][j] = message.charAt(msgPos);
				msgPos++;
			}		
		}
		int finalLineNumber = messageSize%key.length();
	
		for(int i = 0; i < numberOfColumns ; i++)
		{
			int pos = getPositionInIntArray(i,order);
			for(int j = 0; j < numberOfLines ; j++)
			{
				if(!(j == numberOfLines-1 && pos > finalLineNumber-1 && finalLineNumber > 0))
				{
					ret+=matrix[j][pos];
				}
					
			}		
		}
	//	System.out.print(ret);
			
		return ret;
	}
	public static  String decipher(String message,String key)
	{
		if(key.length() == 0)
			return message;
		if(key.length() > message.length())
			key = key.substring(0,message.length());
		key = removeDuplicates(key);
		String ret = "";
		int[] order = getKeyNumber(key);
		int messageSize = message.length();
		int numberOfLines = (messageSize/key.length());
		if(messageSize % key.length() != 0)
			numberOfLines++;
		int numberOfColumns = key.length();
		char[][] matrix = new char[numberOfLines][numberOfColumns];
		String msgCopy = new String(message);
		int finalLineNumber = messageSize%key.length();
		for(int i = 0; i < numberOfColumns ; i++)
		{
			int pos = getPositionInIntArray(i,order);
			for(int j = 0; j < numberOfLines ; j++)
			{
				if(!(j == numberOfLines-1 && pos > finalLineNumber-1 && finalLineNumber > 0))
					matrix[j][pos] = msgCopy.charAt(j);				
			}	
			if(pos > finalLineNumber-1 && finalLineNumber > 0)
				msgCopy = msgCopy.substring(numberOfLines-1, msgCopy.length());
			else
				msgCopy = msgCopy.substring(numberOfLines, msgCopy.length());
		}
		for(int i = 0 ; i < numberOfLines ; i++)
		{
			for(int j = 0; j<numberOfColumns; j++)
			{
				//if(!(i == numberOfColumns && j > finalLineNumber-1))
					ret += matrix[i][j];
			}
		}

		
		
		
		return ret;
	}

	public static  int[] getKeyNumber(String k)
	{
		String key = new String(k);
		int size = key.length();
		int[] ret = new int[size];
		char[] letters = key.toCharArray();
		Arrays.sort(letters); 
		
		for(int i = 0; i < size ; i++)
		{
			int pos = key.indexOf(letters[i]);
			ret[pos] = i;
		}
				
		return ret;
	}
	public  static int getPositionInIntArray(int num,int [] array)
	{
		for(int i = 0;i< array.length ; i++)
		{
			if(array[i] == num)
				return i;
		}
		return -1;
	}
	static String removeDuplicates(String s) 
	{
	    StringBuilder noDupes = new StringBuilder();
	    for (int i = 0; i < s.length(); i++) {
	        String si = s.substring(i, i + 1);
	        if (noDupes.indexOf(si) == -1) {
	            noDupes.append(si);
	        }
	    }
	    return noDupes.toString();
	}

}
