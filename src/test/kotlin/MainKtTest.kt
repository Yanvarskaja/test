import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calculateCommission_Maestro_previosTransfer_more_7500000() {
        val type = PaymentType.Maestro
        val previousTransfer = 10_000_000
        val currentTransfer = 1_00_000

        val commission = calculateCommission(
            type = type,
            previousTransfer = previousTransfer,
            currentTransfer = currentTransfer
        )

        assertEquals(206, commission)
    }

    @Test
    fun calculateCommission_Maestro_previosTransfer_less_7500000() {
        val type = PaymentType.Maestro
        val previousTransfer = 7_400_000
        val currentTransfer = 1_00_000

        val commission = calculateCommission(
            type = type,
            previousTransfer = previousTransfer,
            currentTransfer = currentTransfer
        )

        assertEquals(0, commission)
    }

    @Test
    fun calculateCommission_MasterCard_previosTransfer_more_7500000() {
        val type = PaymentType.MasterCard
        val previousTransfer = 10_000_000
        val currentTransfer = 1_00_000

        val commission = calculateCommission(
            type = type,
            previousTransfer = previousTransfer,
            currentTransfer = currentTransfer
        )

        assertEquals(206, commission)
    }

    @Test
    fun calculateCommission_MasterCard_previosTransfer_less_7500000() {
        val type = PaymentType.MasterCard
        val previousTransfer = 7_400_000
        val currentTransfer = 1_00_000

        val commission = calculateCommission(
            type = type,
            previousTransfer = previousTransfer,
            currentTransfer = currentTransfer
        )

        assertEquals(0, commission)
    }

    @Test
    fun calculateCommission_Visa_commission_less_35() {
        val type = PaymentType.Visa
        //  val previousTransfer = 7_400_000
        val currentTransfer = 100_000

        val commission = calculateCommission(
            type = type,
            //    previousTransfer =  previousTransfer,
            currentTransfer = currentTransfer
        )

        assertEquals(35, commission)
    }

    @Test
    fun calculateCommission_Visa_commission_more_35() {
        val type = PaymentType.Visa
        val previousTransfer = 7_400_000
        val currentTransfer = 1_000_000

        val commission = calculateCommission(
            type = type,
            previousTransfer = previousTransfer,
            currentTransfer = currentTransfer
        )

        assertEquals(75, commission)
    }

    @Test
    fun calculateCommission_Mir_commission_less_35() {
        val type = PaymentType.Mir
        //  val previousTransfer = 7_400_000
        val currentTransfer = 100_000

        val commission = calculateCommission(
            type = type,
            //    previousTransfer =  previousTransfer,
            currentTransfer = currentTransfer
        )

        assertEquals(35, commission)
    }

    @Test
    fun calculateCommission_Mir_commission_more_35() {
        val type = PaymentType.Mir
        val previousTransfer = 7_400_000
        val currentTransfer = 1_000_000

        val commission = calculateCommission(
            type = type,
            previousTransfer = previousTransfer,
            currentTransfer = currentTransfer
        )

        assertEquals(75, commission)
    }

    @Test
    fun calculateCommission_VkPay() {
        val type = PaymentType.VkPay
        val previousTransfer = 100
        val currentTransfer = 100

        val commission = calculateCommission(
            type = type,
            previousTransfer = previousTransfer,
            currentTransfer = currentTransfer
        )

        assertEquals(0, commission)
    }
}