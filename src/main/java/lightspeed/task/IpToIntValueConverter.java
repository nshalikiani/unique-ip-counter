package lightspeed.task;

import java.util.Arrays;

public class IpToIntValueConverter {

    public static int ipHashFunction(String ipAddress) {

        long result = 0;

        int[] splitIp = Arrays.stream(ipAddress.split("[.]")).mapToInt(Integer::valueOf).toArray();

        for (int ipPart : splitIp) {

            result = (result << 8) | ipPart ;

        }

        return (int) result;
    }

}
