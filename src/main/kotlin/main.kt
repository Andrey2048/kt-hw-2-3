fun main() {

    println("Обычные покупатели")
    var isMeloman = false

    for (i in 1..20) {
        var amount = i * 1_000
        var finalPrice: Int
        finalPrice = amount - discountForPurchases(amount, isMeloman)
        println(
            "Сумма  $amount руб." +
                    " Скидка " +
                    discountForPurchases(amount, isMeloman) + " руб.  "
                    + "Сумма со скидкой $finalPrice руб."
        )
    }

    println("Меломаны")
    isMeloman = true

    for (i in 1..20) {
        var amount = i * 1_000
        var finalPrice: Int
        finalPrice = amount - discountForPurchases(amount, isMeloman)
        println(
            "Сумма  $amount руб." +
                    " Скидка " +
                    discountForPurchases(amount, isMeloman) + " руб.  "
                    + "Сумма со скидкой $finalPrice руб."
        )
    }
}


//расчет скидки в зависимости от стоимости покупки
fun discountForPurchases(
    totalPrice: Int,
    isMeloman: Boolean
): Int {
    val discountStartFix = 1_000 //порог применения фиксированной скидки
    val discountFix = 100 //фиксированная скидка в рублях
    val discountStartPercent = 10_000 //порог применения процентной скидки
    val discountPercent = 5 //скидка в % при превышении discountStartPercent
    val discountMeloman = 1 //дополнительная скидка в % для меломанов
    var discount: Int

    if (totalPrice > discountStartFix) discount = discountFix
    else discount = 0
    if (totalPrice > discountStartPercent) discount = totalPrice * discountPercent / 100


    if (isMeloman) discount = discount * (100 + discountMeloman) / 100
    return discount
}
