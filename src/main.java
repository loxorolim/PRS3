
public class main 
{

	public static void main(String [ ] args)
	{

//		String key = "asdqwejklaaaaaaaaaaaaaaasdasdaqwxzcxzaaassssssssdddddqddqqqqq";
//		String a = CifraRolim.cipher("",key);
//		System.out.print(a+"\n");
//		System.out.print(CifraRolim.decipher(a,key));
            
//			int railsize = 100;
//             String cipheredMessage = CifraYusim.cipher("eu gosto de          peixe", railsize);
//             System.out.println(cipheredMessage);
//            String decipheredMessage = CifraYusim.decipher(cipheredMessage, railsize);
//            
//            System.out.println(decipheredMessage);
		
		String message = "Abacate bate tanto quanto uma batida de carro";
		String key = "aocue";
		
//		String yucipher = CifraRolim.cipher(message, key);
//		String yudecipher = CifraRolim.decipher(yucipher, key);
//		System.out.print(yudecipher);
		String cifrado = cipher(message,key);
		System.out.println("Resultado da cifragem: ");
		System.out.println(cifrado);
		String decifrado = decipher(cifrado,key);
		System.out.println("Resultado da decifragem: ");
		System.out.println(decifrado);
	}
	public static String cipher(String m, String key)
	{
		String yucipher = CifraYusim.cipher(m, key.length());
		System.out.println("Primeira cifragem:");
		System.out.println(yucipher);
		System.out.println(yucipher.length());
		String rocipher = CifraRolim.cipher(yucipher, key);
		System.out.println("Segunda cifragem:");
		System.out.println(rocipher);
		System.out.println(rocipher.length());
		return rocipher;
	}
	public static String decipher(String m, String key)
	{

		String rodecipher = CifraRolim.decipher(m, key);
		System.out.println("Primeira decifragem:");
		System.out.println(rodecipher);
		System.out.println(rodecipher.length());
		String yudecipher = CifraYusim.decipher(rodecipher, key.length());
		System.out.println("Segunda decifragem:");
		System.out.println(yudecipher);
		return yudecipher;
	}
}
