package lightspeed.task.counter;

import lightspeed.task.IpToIntValueConverter;

import java.util.BitSet;

public class UniqueIpAddressCounterBitSetImpl implements UniqueIpAddressCounter {

    // for values in range  0 - 2_147_483_647
    private final BitSet positiveHashValues = new BitSet(Integer.MAX_VALUE);


    // for values in range 2_147_483_648 - 4_294_967_295, which will be in negative value for int.
    private final BitSet negativeHashValues = new BitSet(Integer.MAX_VALUE);

    @Override
    public void registerIpAddress(String ipAddr) {

        int intValue = IpToIntValueConverter.ipHashFunction(ipAddr);

        if (intValue >= 0) {

            positiveHashValues.set(intValue);

        } else {

            negativeHashValues.set(~intValue);

        }

    }

    @Override
    public long getUniqueAddrCount() {

        return positiveHashValues.cardinality() + negativeHashValues.cardinality();

    }
}
