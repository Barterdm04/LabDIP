package dip.lab2;

/**
 * An example low-level class. Does this class definition follow the DIP?
 * If not, fix it.
 *
 * Any other best practice violations? Fix them too.
 *
 * @author Dylan Barter
 */
public class BaggageServiceTipCalculator implements TipCalculator {
    private double minBill = 0.00;
    private double goodRate = 0.20;
    private double fairRate = 0.15;
    private double poorRate = 0.10;
    private double maxBill = 100.00;
    private String billEntryError =
            "Error: bill must be between " + minBill + " and "
            + maxBill;
    private double baseTipPerBag = 1.00; // set default value
    private int bagCount;

    private ServiceQuality serviceQuality;

    
    public BaggageServiceTipCalculator(ServiceQuality q, int bags) {
        this.setServiceRating(q); // perform validation
        this.setBagCount(bags);
    }
    public BaggageServiceTipCalculator(ServiceQuality q, int bags, double baseTipPerBag){
        this.setServiceRating(q);
        this.setBagCount(bags);
        this.setBaseTipPerBag(baseTipPerBag);
    }
    
    @Override
    public double getTip() {
        double tip = 0.00; // always initialize local variables

        switch(serviceQuality) {
            case GOOD:
                tip = baseTipPerBag * bagCount * (1 + goodRate);
                break;
            case FAIR:
                tip = baseTipPerBag * bagCount * (1 + fairRate);
                break;
            case POOR:
                tip = baseTipPerBag * bagCount * (1 + poorRate);
                break;
        }

        return tip;
    }

    public final void setServiceRating(ServiceQuality q) {
        // No need to validate because enums provide type safety!
        serviceQuality = q;
    }

    public ServiceQuality getServiceQuality() {
        return serviceQuality;
    }

    public int getBagCount() {
        return bagCount;
    }

    public void setBagCount(int bagCount) {
        if(bagCount < 0) {
            throw new IllegalArgumentException(
                    "bag count must be greater than or equal to zero");
        }
        this.bagCount = bagCount;
    }

    public double getBaseTipPerBag() {
        return baseTipPerBag;
    }

    public void setBaseTipPerBag(double baseTipPerBag) {
        if(baseTipPerBag < 0) {
            throw new IllegalArgumentException(
                    "error: base tip must be greater than or equal to zero");
        }
        this.baseTipPerBag = baseTipPerBag;
    }

    public double getMinBill() {
        return minBill;
    }

    public void setMinBill(double minBill) {
        if(minBill < 0) {
            throw new IllegalArgumentException(
                    "error: bill minimum must be greater than or equal to zero");
        }
        this.minBill = minBill;
    }

    public double getGoodRate() {
        return goodRate;
    }

    public void setGoodRate(double goodRate) {
        this.goodRate = goodRate;
    }

    public double getFairRate() {
        return fairRate;
    }

    public void setFairRate(double fairRate) {
        this.fairRate = fairRate;
    }
    
    public double getPoorRate() {
        return poorRate;
    }

    public void setPoorRate(double poorRate) {
        this.poorRate = poorRate;
    }

    public double getMaxBill() {
        return maxBill;
    }

    public void setMaxBill(double maxBill) {
        if(maxBill < 0) {
            throw new IllegalArgumentException(
                    "error: bill max must be greater than or equal to zero");
        }
        this.maxBill = maxBill;
    }

    public String getBillEntryError() {
        return billEntryError;
    }

    public void setBillEntryError(String billEntryError) {
        this.billEntryError = billEntryError;
    }

}