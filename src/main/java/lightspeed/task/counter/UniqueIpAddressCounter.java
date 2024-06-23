package lightspeed.task.counter;

public interface UniqueIpAddressCounter {
;
    void registerIpAddress(String ipAddr);

    long getUniqueAddrCount();

}
