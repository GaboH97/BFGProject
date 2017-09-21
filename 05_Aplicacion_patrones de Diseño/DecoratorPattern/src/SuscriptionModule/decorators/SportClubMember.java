package SuscriptionModule.decorators;

import SuscriptionModule.Utils.Utils;
import SuscriptionModule.products.ISuscriptionData;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Cesar Cardozo
 */
public class SportClubMember extends Decorator {

    public SportClubMember(ISuscriptionData isuscriptionM) {
        super(isuscriptionM);
    }

    @Override
    public String getName() {
        return super.getName() + Utils.SPORT_CLUB_MEMBER_NAME;
    }

    @Override
    public BigDecimal getPrice() {
        return (super.getPrice().multiply(Utils.SPORT_CLUB_MEMBER_RATIO)).setScale(1, RoundingMode.HALF_UP);
    }
}