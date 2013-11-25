
public class main 
{

	public static void main(String [ ] args)
	{

//		String key = "asdqwejklaaaaaaaaaaaaaaasdasdaqwxzcxzaaassssssssdddddqddqqqqq";
//		String a = CifraRolim.cipher("",key);
//		System.out.print(a+"\n");
//		System.out.print(CifraRolim.decipher(a,key));
            
//            String cipheredMessage = CifraYusim.cipher("eu gosto de peixe", 3);
            
            String decipheredMessage = CifraYusim.decipher("eo peugsod ex tei", 3);
            
            System.out.println(decipheredMessage);
            
	}
}
