package lfsr;  
  

import static java.lang.System.out;  
import java.util.*;

public class Main  
{  
    public static void main(final String[] arguments)  
    {  
		Scanner scan = new Scanner(System.in);
        int [] coefficients = {1, 0, 1, 1, 1};
        int [] state = {1, 1, 0, 0, 1};
        System.out.println(Arrays.toString(state));
        LFSR lfsr1 = new LFSR(coefficients, state);
        int [] res = lfsr1.get_sequence(12);
        int [] res2 = {1,0,1,0,0};
        System.out.println(Arrays.toString(res2));
		Berlekamp_Massey berlekamp = new Berlekamp_Massey(res);

		String rep = scan.nextLine();

		while ( ! rep.equals("stop")) {
			berlekamp.iteration();
			rep = scan.nextLine();
		}


    }  
}  
