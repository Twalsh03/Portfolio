package alarmsystem;
import java.util.Random;

public class Probability implements PollProbability {

    @Override
    public Boolean getProbability(int probConstraint) {

        Random rand = new Random();
        //random number is generated for the probability of it being called
        int probability = rand.nextInt(99);
        //for debugging
        System.out.println(probability);
        return probability <= probConstraint;
    }
}

