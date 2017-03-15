package lfsr;  
  
import java.util.*;

/**
 * The LFSR class simulutate a Linear-Feedback-Shift-Register. 
 *
 * methodes :
 *      - LFSR : constructor, defines the size, initial state and coefficients
 *      - compute_next : compute the next output
 *      - get_sequence(until, from=0) : return the sequence between from and until
 */
public class LFSR  
{  
    private int len;
    int modulo = 2;
    private int[] coefficients;
    private ArrayList<Integer> outputs = new ArrayList<Integer> ();

    @Override  
    public String toString()  
    {  
        return "I am a Linear FeedBack Shift Register !";  
    }  

    public LFSR(int[] coeff, int[] init_state)
    {
        this.len = coeff.length;
        this.coefficients = coeff.clone();
        for (int s : init_state) {
            this.outputs.add(s);
        }
    }

    public int[] get_sequence(int until){
        int [] res = new int[until];

        while(this.outputs.size() < until){
            this.compute_next();
        }

        for(int i = 0; i < until; i++) {
            res[i] = this.outputs.get(i);
        }
        System.out.println(res);
        return res;
    }

    public void compute_next() {
        int sj = 0;
        for(int i = 0; i < this.len ; i++){
            sj += this.outputs.get((this.outputs.size()-1) - i) * coefficients[i];
        }
        sj = sj % this.modulo;
        this.outputs.add(sj);
    }
}  
