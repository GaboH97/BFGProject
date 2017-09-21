package SuscriptionModule.decorators;

import SuscriptionModule.Utils.Utils;
import SuscriptionModule.products.ISuscriptionData;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Cesar Cardozo, Gabriel Amaya
 */
public class MontlyPayment extends Decorator {

    private int monthAmount;

    public MontlyPayment(ISuscriptionData isuscriptionM, int monthAmount) {
        super(isuscriptionM);
        this.monthAmount = monthAmount;
    }

    @Override
    public String getName() {
        switch (monthAmount) {
            case 0:
                return Utils.HALF_MONTH_MP_NAME;
            case 2:
                return Utils.TWO_MONTH_MP_NAME;
            case 3:
                return Utils.THREE_MONTH_MP_NAME;
            case 6:
                return Utils.SIX_MONTH_MP_NAME;
            case 12:
                return Utils.ONE_YEAR_MP_NAME;
            default:
                return Utils.ERROR_MESSAGE;
        }
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal bd = super.getPrice();
        switch (monthAmount) {
            case 0:
                return ((bd.multiply(Utils.X1_2MONTH_RATIO)).divide(new BigDecimal(2))).setScale(1, RoundingMode.HALF_UP);
            case 2:
                bd = bd.multiply(Utils.X2MONTH_RATIO);
                break;
            case 3:
                bd = bd.multiply(Utils.X3MONTH_RATIO);
                break;
            case 6:
                bd = bd.multiply(Utils.X6MONTH_RATIO);
                break;
            case 12:
                bd = bd.multiply(Utils.X12MONTH_RATIO);
                break;
        }
        bd = bd.multiply(new BigDecimal(monthAmount));
        return bd.setScale(1, RoundingMode.HALF_UP);
    }

    @Override
    public String getDescription() {
        String desc = super.getDescription();
        switch (monthAmount) {
             case 0:
                desc += Utils.HALF_MONTH_MP_DESCRIPTION;
                break;
            case 2:
                desc += Utils.TWO_MONTH_MP_DESCRIPTION;
                break;
            case 3:
                desc += Utils.THREE_MONTH_MP_DESCRIPTION;
                break;
            case 6:
                desc += Utils.SIX_MONTH_MP_DESCRIPTION;
                break;
            case 12:
                desc += Utils.ONE_YEAR_MP_DESCRIPTION;
                break;
        }
        return desc;
    }

}
