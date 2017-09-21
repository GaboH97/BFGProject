package SuscriptionModule.decorators;

import SuscriptionModule.Utils.Utils;
import SuscriptionModule.products.ISuscriptionData;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Cesar Cardozo
 */
public class ExecutiveCard extends Decorator {

    private int sessionAmount;

    public ExecutiveCard(ISuscriptionData isuscriptionM, int sessionAmount) {
        super(isuscriptionM);
        this.sessionAmount = sessionAmount;
    }

    @Override
    public String getName() {
        switch (sessionAmount) {
            case 5:
                return Utils.X5CARD_NAME;
            case 10:
                return Utils.X10CARD_NAME;
            case 15:
                return Utils.X15CARD_NAME;
            case 20:
                return Utils.X20CARD_NAME;
            case 30:
                return Utils.X30CARD_NAME;
            default:
                return Utils.ERROR_MESSAGE;
        }
    }

    @Override
    public String getDescription() {
        switch (sessionAmount) {
            case 5:
                return Utils.X5CARD_DESCRITION;
            case 10:
                return Utils.X10CARD_DESCRITION;
            case 15:
                return Utils.X15CARD_DESCRITION;
            case 20:
                return Utils.X20CARD_DESCRITION;
            case 30:
                return Utils.X30CARD_DESCRITION;
            default:
                return Utils.ERROR_MESSAGE;
        }
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal bd = super.getPrice();
        switch (sessionAmount) {
            case 5:
                bd = bd.multiply(Utils.X5CARD_RATIO);
                break;
            case 10:
                bd = bd.multiply(Utils.X10CARD_RATIO);
                break;
            case 15:
                bd.multiply(Utils.X15CARD_RATIO);
                break;
            case 20:
                bd.multiply(Utils.X20CARD_RATIO);
                break;
            case 30:
                bd.multiply(Utils.X30CARD_RATIO);
                break;
        }
        bd = bd.multiply(new BigDecimal(sessionAmount));
        return bd.setScale(1, RoundingMode.HALF_UP);
    }

}
