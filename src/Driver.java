import java.util.Random;
public class Driver {
    private Double xarr[];
    private Double yarr[];
    
    public Driver(int arrlength){
        initArray(arrlength);
        Stats s1 = new Stats(xarr, yarr);
        System.out.println(s1);
    }

    public Driver(Double[] xarr, Double[] yarr){
        //initArray(arrlength);
        Stats s1 = new Stats(xarr, yarr);
        System.out.println(s1);
    }


    public void initArray(int length) {
        Random rand = new Random();
        xarr = new Double[length];
        yarr = new Double[length];
        for (int cnt = 0; cnt < length; cnt++){
            xarr[cnt] = rand.nextDouble() * 10;
            yarr[cnt] = rand.nextDouble() * 10;
        }
    }
    public static void  main(String[] args) {
        int alength = 5;

        //auto run for 3-10 times
        for (int cnt= 0; cnt < new Random().nextInt(7) + 3; cnt++)
        {
            alength = new Random().nextInt(5) + 3;
            System.out.println("   ");
            System.out.println("Loop no: " + cnt);
            System.out.println("Length of arr: " + alength);
            Driver d1 = new Driver(alength);
        }

        //manual run
        Double[] xarr = {2.0, 3.0, 4.0, 5.0};
        Double[] yarr = {4.0, 6.0, 8.0, 11.0};

        System.out.println("   ");
        System.out.println("Manual: ");
        Driver d2 = new Driver(xarr, yarr);

    }        
}

