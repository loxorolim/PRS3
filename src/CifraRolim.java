import java.util.ArrayList;
import java.util.Arrays;


public class CifraRolim 
{
	String key;
	String message;
	
	public CifraRolim(String key,String message)
	{
		this.key = key;
		this.message = message;
	}
	public String cipher()
	{
		String ret = "";
		int[] order = getKeyNumber();
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
		
		for(int i = 0; i < numberOfLines ; i++)
		{
			
			for(int j = 0; j < numberOfColumns ; j++)
			{
				
			}		
		}
		
//		String msgCopy = new String(message);
//		for(int i = 0; i < msgCopy.length()/key.length()+1; i++)
//		{
//			for(int j = 0; j < key.length() ; j++)
//			{
//				ret+= msgCopy.charAt(getPositionInIntArray(j,order));
//			}
//			msgCopy = msgCopy.substring(key.length(),msgCopy.length());
//		}
//		System.out.print(ret);
		
		
		return null;
	}
	public String decipher()
	{
		return null;
	}
	public int[] getKeyNumber()
	{
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
	public int getPositionInIntArray(int num,int [] array)
	{
		for(int i = 0;i< array.length ; i++)
		{
			if(array[i] == num)
				return i;
		}
		return -1;
	}

}
