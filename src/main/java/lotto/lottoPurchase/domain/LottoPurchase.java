package lotto.lottoPurchase.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoPurchase {

    private final Integer price = 1000;

    private Integer money;

    private Integer purchaseAmount;

    public LottoPurchase() {
        this.money = 0;
        this.purchaseAmount = 0;
    }

    public void insult() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String insultedMoney = readLine();
            this.money = Integer.parseInt(insultedMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("money must be a number");
        }
    }

    public void calculate() throws IllegalArgumentException {
        if (this.money % price != 0) {
            throw new IllegalArgumentException("money must be dividable by 1000");
        }
        this.purchaseAmount = this.money / price;
    }

    public Integer getPurchaseAmount() {
        return this.purchaseAmount;
    }

}
