package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoStatistics
import lotto.domain.Money
import lotto.domain.WinnerLotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = Money(InputView().getMoney())
    val tickets = LottoMachine().buy(money)
    ResultView().printTickets(tickets)

    val winner = InputView().getPastWinner()
    val bonus = InputView().getBonusNumber()

    val lottoResults = tickets.getResult(WinnerLotto(winner, bonus))

    ResultView().printLottoResult(lottoResults)

    val statistics = LottoStatistics(money, lottoResults)
    ResultView().printWinningStatistics(statistics)
}