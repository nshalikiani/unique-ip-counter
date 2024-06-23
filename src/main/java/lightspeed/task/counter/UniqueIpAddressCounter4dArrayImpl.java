package lightspeed.task.counter;

import java.util.Arrays;

public class UniqueIpAddressCounter4dArrayImpl implements UniqueIpAddressCounter {

    private byte[][][][] byteArray = new byte[256][256][256][256];
    private long uniqueCount = 0;

    @Override
    public void registerIpAddress(String ipAddr) {

       int[] splitIp = Arrays.stream(ipAddr.split("[.]")).mapToInt(Integer::valueOf).toArray();

       if (byteArray[splitIp[0]][splitIp[1]][splitIp[2]][splitIp[3]] != 1){
           byteArray[splitIp[0]][splitIp[1]][splitIp[2]][splitIp[3]] = 1;
           uniqueCount++;
       }

    }

    @Override
    public long getUniqueAddrCount() {

        return uniqueCount;
    }
}
