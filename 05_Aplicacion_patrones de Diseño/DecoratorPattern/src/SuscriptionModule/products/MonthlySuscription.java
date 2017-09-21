package SuscriptionModule.products;

import SuscriptionModule.Utils.Utils;
import java.math.BigDecimal;

/**
 *
 * @author Cesar Cardozo
 */
public class MonthlySuscription extends Suscription {

    MonthlySuscritionType mst;

    public MonthlySuscription(MonthlySuscritionType mst) {
        this.mst = mst;
    }

    @Override
    public BigDecimal getPrice() {
        switch (mst.valueOf(mst.name())) {
            case SPINNING:
                return Utils.MONTHLY_SUSCRIPTION_SPINNING_BASIC_PRICE;
            case WEIGHTLIFINTG:
                return Utils.MONTHLY_SUSCRIPTION_BASIC_PRICE;
            case ALL:
                return Utils.MONTHLY_SUSCRIPTION_ALL_BASIC_PRICE;
        }
        return null;
    }

    @Override
    public String getDescription() {
        switch (mst.valueOf(mst.name())) {
            case SPINNING:
                return Utils.MONTHLY_SUSCRIPTION_SPINNING_DESCRIPTION;
            case WEIGHTLIFINTG:
                return Utils.MONTHLY_SUSCRIPTION_DESCRIPTION;
            case ALL:
                return Utils.MONTHLY_SUSCRIPTION_ALL_DESCRIPTION;
        }
        return null;
    }

    @Override
    public String getName() {
        return Utils.MONTHLY_SUSCRIPTION_NAME;
    }
}
