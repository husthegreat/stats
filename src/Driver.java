import java.util.Random;
public class Driver {
    private Double xarr[];
    private Double yarr[];

    //constructor for random data
    public Driver(int arrlength){
        initArray(arrlength);
        Stats s1 = new Stats(xarr, yarr);
        System.out.println(s1);
    }

    //constructor for fixed data
    public Driver(Double[] xarr, Double[] yarr){
        Stats s1 = new Stats(xarr, yarr);
        System.out.println(s1);
    }

    //helper to create random size arrays and fill with random numbers for testing purposes
    public void initArray(int length) {
        Random rand = new Random();
        xarr = new Double[length];
        yarr = new Double[length];
        for (int cnt = 0; cnt < length; cnt++){
            xarr[cnt] = rand.nextDouble() * 10;
            yarr[cnt] = rand.nextDouble() * 10;
        }
    }
    //main methot to test the Stats class
    public static void  main(String[] args) {
        int alength = 5;

        //auto run for 3-10 times with rAndom varşables
        for (int cnt= 0; cnt < new Random().nextInt(7) + 3; cnt++)
        {
            alength = new Random().nextInt(5) + 3;
            System.out.println("   ");
            System.out.println("Loop no: " + cnt);
            System.out.println("Length of arr: " + alength);
            Driver d1 = new Driver(alength);
        }

        //manual run withhard coded array
        Double[] xarr = {2.0, 3.0, 4.0, 5.0};
        Double[] yarr = {4.0, 6.0, 8.0, 11.0};

        System.out.println("--------");
        System.out.println("Manual: ");
        Driver d2 = new Driver(xarr, yarr);

    }        
}

