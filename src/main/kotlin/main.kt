fun main() {
    val type = PaymentType.VkPay
    val previousTransfer = 100
    val currentTransfer = 100
    //  val commission = calculateCommission()
    println("Размер комиссии " + calculateCommission() + " руб.")
}

fun calculateCommission(
    type: PaymentType = PaymentType.VkPay,
    previousTransfer: Int = 1_000_000,
    currentTransfer: Int = 1_000_000,
): Int {
    if (previousTransfer > 7_500_000 && type == PaymentType.Maestro || previousTransfer > 7_500_000 && type == PaymentType.MasterCard) {
        var commission: Int = ((currentTransfer / 100 * 0.6 + 20000).toInt()) / 100
        return commission

    } else if (type == PaymentType.Mir || type == PaymentType.Visa) {
        var commision: Int = (currentTransfer / 100 * 0.75).toInt()
        if (commision < 3500) {
            commision = 3500 / 100
            return commision
        } else {
            var commission = (commision.toInt()) / 100
            return commission

        }
    } else {
        var commission = 0
        return commission
    }
}

enum class PaymentType {
    Maestro, MasterCard, Visa, Mir, VkPay
}