package company.vk.genatulin.internshiptask.repositories;

public class IpAddressCount {
    public Long getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(Long ipAddr) {
        this.ipAddr = ipAddr;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    private Long ipAddr;
    private Long total;

    public IpAddressCount(Long ipAddr, Long total) {
        this.ipAddr = ipAddr;
        this.total = total;
    }
}
