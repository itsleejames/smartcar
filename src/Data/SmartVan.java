
package Data;

import java.time.LocalDate;

public class SmartVan extends Petrol {
    private static final double HOURLY_RATE = 15.0;
    private static final double DAILY_RATE = 85.0;
    private static final double EXTRA_KM_RATE = 0.25;
    private static final int FREE_KMS = 50;

    public SmartVan(int id, String regNo, String manufacturer, String model, LocalDate regDate, Location location, double engine, int co2) {
        super(id, regNo, manufacturer, model, regDate, location, engine, co2);
    }

    @Override
    public double calculateRate(int hours, int kilometers) {
        double timeRate = (hours <= 24) ? hours * HOURLY_RATE : DAILY_RATE;
        double extraKmCharge = (kilometers > FREE_KMS) ? (kilometers - FREE_KMS) * EXTRA_KM_RATE : 0;
        return timeRate + extraKmCharge;
    }
}
