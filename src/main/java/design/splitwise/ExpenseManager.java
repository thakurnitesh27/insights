package design.splitwise;

import javax.naming.OperationNotSupportedException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {
    private Map<String, Map<String, Map<String, BigDecimal>>> lenderToDebtorMap = new HashMap<>();

    void addTransaction(Group group, Transaction transaction) {

        Map<String, Map<String, BigDecimal>> lenders = lenderToDebtorMap.get(group.getGroupId());

        if (lenders == null) {
            lenders = new HashMap();
            lenderToDebtorMap.put(group.getGroupId(), lenders);
        }

        Map<String, BigDecimal> debtors = lenders.get(transaction.getLendor().getId());
        BigDecimal newDebt = transaction.getAmount();

        if (debtors.get(transaction.getDebtor().getId()) != null) {
            BigDecimal originalDebt = debtors.get(transaction.getDebtor().getId());
            newDebt = originalDebt.add(transaction.getAmount()).setScale(1, RoundingMode.CEILING);
        }

        debtors.put(transaction.getDebtor().getId(), newDebt);


    }


    void addExpense(Group group, User payee, List<User> debtor, Float amount, SharingMode sharingMode) throws OperationNotSupportedException {

        if (!payee.getGroup().equals(group)) {
            System.out.println("Payee is not part of group: " + group.getGroupName());
            return;
        }
        switch (sharingMode) {
            case EQUAL: {
                Float share = amount / (debtor.size() + 1);

                for (User user : debtor) {

                    addTransaction(group, new Transaction(payee, user, share));
                }

            }

            default: {
                throw new OperationNotSupportedException();
            }
        }


    }

    void settlePayment(Group group, User debtor, User lender, Integer amount) {

    }
}
