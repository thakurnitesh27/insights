package design.splitwise;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Transaction {

    private User lendor;
    private User debtor;
    BigDecimal amount;

    public Transaction(User lendor, User debtor, Float amount) {
        this.lendor = lendor;
        this.amount = new BigDecimal(amount).setScale(1, RoundingMode.CEILING);
    }

    public User getLendor() {
        return lendor;
    }

    public User getDebtor() {
        return debtor;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
