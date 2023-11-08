package lotto.lottoResults.domain;

import static lotto.component.rank.Rank.getReward;
import static lotto.component.rank.Statistics.getStatistics;

import java.util.ArrayList;
import java.util.List;

public class LottoStatistics {

    private final List<Integer> counts;

    private Long totalReward;

    public LottoStatistics() {
        totalReward = 0L;
        counts = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            counts.add(0);
        }
    }

    public void incrementCount(Integer matchedCount, Integer bonusMatched) {
        Integer rank = convertRank(matchedCount, bonusMatched);
        counts.set(rank - 1, counts.get(rank - 1) + 1);
        totalReward += getReward(rank);
    }

    public void printStatistics() {
        System.out.println("당첨 통계\n" + "---");
        for (int i = 4; i >= 0; i--) {
            System.out.println(getStatistics(i + 1) + " - " + counts.get(i) + "개");
        }
    }

    public void printReturnRate(Integer spendMoney) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", calculateReturnRate(spendMoney));
    }

    private Integer convertRank(Integer matchedCount, Integer bonusMatched) {
        if (matchedCount == 3) {
            return 5;
        } else if (matchedCount == 4) {
            return 4;
        } else if (matchedCount == 5 && bonusMatched == 0) {
            return 3;
        } else if (matchedCount == 5 && bonusMatched == 1) {
            return 2;
        } else if (matchedCount == 6) {
            return 1;
        }
        return 6;
    }

    private Double calculateReturnRate(Integer spendMoney) {
        return (totalReward / (double) spendMoney);
    }

}
