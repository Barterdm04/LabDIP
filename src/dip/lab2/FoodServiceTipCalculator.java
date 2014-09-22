package dip.lab2;

/**
 * An example low-level class. Does this class definition follow the DIP?
 * If not, fix it.
 *
 * Any other best practice violations? Fix them too.
 *
 * @author Dylan Barter
 */
public class FoodServiceTipCalculator implements TipCalculator{
    private double minBill = 0.00;
    private double goodRate = 0.20;
    private double fairRate = 0.15;
    private double poorRate = 0.10;
    private String billEntryError = "Error: bill must be greater than or equal to " + minBill;
    private double bill;
    private ServiceQuality serviceQuality;

    public FoodServiceTipCalculator(ServiceQuality q, double bill) {
        this.setServiceRating(q);
        this.setBill(bill);
    }

    @Override
    public double getTip() {
        double tip = 0.00; // always initialize local variables

        switch(serviceQuality) {
            case GOOD:
                tip = bill * goodRate;
                break;
            case FAIR:
                tip = bill * fairRate;
                break;
            case POOR:
                tip = bill * poorRate;
                break;
        }

        return tip;
    }

    public final void setBill(double bill) {
        if(bill < minBill) {
            throw new IllegalArgumentException(billEntryError);
        }
        this.bill = bill;
    }

    public final void setServiceRating(ServiceQuality q) {
        // No need to validate because enums provide type safety!
        serviceQuality = q;
    }

    public ServiceQuality getServiceQuality() {
        return serviceQuality;
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

    public String getBillEntryError() {
        return billEntryError;
    }

    public void setBillEntryError(String billEntryError) {
        this.billEntryError = billEntryError;
    }
}
