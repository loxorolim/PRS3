
public class main 
{

	public static void main(String [ ] args)
	{

		String key = "asdqwejklaaaaaaaaaaaaaaasdasdaqwxzcxzaaassssssssdddddqddqqqqq";
		String a = CifraRolim.cipher("",key);
		System.out.print(a+"\n");
		System.out.print(CifraRolim.decipher(a,key));
	}
}
