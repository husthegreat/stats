public class Stats {
    private Double[] xValues;
    private Double[] yValues;
    private Double xMean;
    private Double yMean;
    private Double xSum;
    private Double ySum;
    private Integer xCount;
    private Integer yCount;
    private Double xStdDev;
    private Double yStdDev;
    private Double tmpSum = 0.0;
    private Double tmpMean = 0.0;
    private Double correl = 0.0;
    private Double slope = 0.0;
    private Double intercept = 0.0;
    

    public Stats()
    {
        xValues = new Double[3];
    }
    public Stats(Double[] xval, Double[] yval)
    {
        Double tmpNum = 0.0;
        Double tmpDeNum = 0.0;
        Double tmpXSqrDif = 0.0;
        Double tmpYSqrDif = 0.0;

        //first check if arrays contain same number of values
        xCount = xval.length;
        yCount = yval.length;
        if (xCount != yCount) 
        {
            throw new ArithmeticException("x and y not same number");
        }

        // set araay value
        xValues = xval;
        yValues = yval;
        
        //calculate standard deviation for x array and get mean and sum meanwhile
        xStdDev = calcStdDev(xval);
        xMean = tmpMean;
        xSum = tmpSum;

        //calculate standard deviation for y array and get mean and sum meanwhile
        yStdDev = calcStdDev(yval);
        yMean = tmpMean;
        ySum = tmpSum;

        //calculate correlation
        for (int cnt = 0; cnt < xCount; cnt++){
            tmpNum = tmpNum + ((xval[cnt] - xMean) * (yval[cnt] - yMean));
            tmpXSqrDif = tmpXSqrDif + Math.pow(xval[cnt] - xMean, 2);
            tmpYSqrDif = tmpYSqrDif + Math.pow(yval[cnt] - yMean, 2);
        }
        tmpDeNum = Math.sqrt(tmpXSqrDif * tmpYSqrDif);
        correl = tmpNum / tmpDeNum;

        if ((correl < -1.0) || (correl >1.0))
        {
            throw new ArithmeticException("woopsie! Something went terribly wrong");
        }        

        //calculate least squares regression line
        slope = correl * yStdDev / xStdDev;
        intercept = yMean - slope * xMean;
        //System.out.println(correl);
    }

    //accessors
    public Double[] getXValues(){
        return xValues;
    }
    public Double[] getYValues(){
        return yValues;
    }
    public Double getXMean(){
        return xMean;
    }
    public Double getYMean(){
        return yMean;
    }
    public Double getXSum(){
        return xSum;
    }
    public Double getYSum(){
        return ySum;
    }
    public Integer getXCount(){
        return xCount;
    }
    public Integer getYCount(){
        return yCount;
    }
    public Double getXStdDev(){
        return xStdDev;
    }
    public Double getYStdDev(){
        return yStdDev;
    }
    public Double getCorrelation(){
        return correl;
    }
    public Double getCoefficientOfDetermination(){
        return Math.pow(correl, 2);
    }
    public Double getLstSqRegSlope(){
        return slope;
    }
    public Double getLstSqRegIntercept(){
        return intercept;
    }


    //mutators
    public void setXvalues(Double[] xval)
    {
        xValues = xval;
    }
    public void setYvalues(Double[] yval)
    {
        yValues = yval;
    }
    public Double getxMean()
    {
        return xMean;
    }

    //helper methods
    private Double calcStdDev(Double[] xarr){
        Double tmpSum = 0.0;
        Double tmpMean = 0.0;
        Integer tmpCount = 0;
        Double tmpStdDev = 0.0;
        Double tmpVar = 0.0;

        //count
        tmpCount = xarr.length;
        //this.tmpCount = tmpCount;

        //sum
        for (int cnt = 0; cnt < tmpCount; cnt++){
            tmpSum += xarr[cnt];
        }
        this.tmpSum = tmpSum;

        //mean
        tmpMean = tmpSum / tmpCount;
        this.tmpMean = tmpMean;

        //StdDev
        for (int cnt = 0; cnt < tmpCount; cnt++){
            tmpVar= tmpVar + Math.pow(xarr[cnt]-tmpMean, 2);
        }    
        tmpVar = tmpVar / (tmpCount - 1);
        tmpStdDev = Math.sqrt(tmpVar);
        //this.tmpStdDev = tmpStdDev;

        return tmpStdDev;
    }

    public String toString(){
        String output = "X Values: ";

        for (int cnt = 0; cnt < xValues.length; cnt++){
            output = output + xValues[cnt] + ",";
        }

        output = output + System.getProperty("line.separator") + "Y Values: ";
        for (int cnt = 0; cnt < xValues.length; cnt++){
            output = output + yValues[cnt] + ",";
        }
        output = output + System.getProperty("line.separator") + "X Standard Deviation: " + xStdDev;
        output = output + System.getProperty("line.separator") + "Y Standard Deviation: " + yStdDev;
        output = output + System.getProperty("line.separator") + "X Mean: " + this.getXMean();
        output = output + System.getProperty("line.separator") + "Y Mean: " + this.getYMean();
        output = output + System.getProperty("line.separator") + "Correlation(r): " + this.getCorrelation();
        output = output + System.getProperty("line.separator") + "Coefficient Of Determination: " + this.getCoefficientOfDetermination() * 100 + "%";
        output = output + System.getProperty("line.separator") + "Best fit slope: " + this.getLstSqRegSlope();
        output = output + System.getProperty("line.separator") + "Best fit intercept: " + this.getLstSqRegIntercept();
        output = output + System.getProperty("line.separator") + "Does mean fit the regression line: y=int+slope*x? " + this.getYMean() + " = " + this.getLstSqRegIntercept() + "+" + this.getLstSqRegSlope() + "*" + this.getXMean() +" ???";
        output = output + System.getProperty("line.separator") + "I calculate y mean as " + (this.getLstSqRegIntercept() + this.getLstSqRegSlope() *  this.getXMean()) +", " +"given x mean is " + this.getXMean() + " ???";
        return (output);
    }

    //main
    public static void  main(String[] args) {
        //Double[] xarr = {2.0, 3.0, 5.0, 8.0};
        //Double[] yarr = {3.0, 5.0, 6.0, 11.0};
        //Stats st = new Stats(xarr,yarr);
        //System.out.println("xSum=" + xSum);
    }
}
