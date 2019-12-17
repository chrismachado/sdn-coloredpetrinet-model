package comp;

public class NetDevice {

    private String name, ipsrc, ipdst, payload;

    public NetDevice(String name, String ipsrc, String ipdst, String payload) {
        this.name = name;
        this.ipsrc = ipsrc;
        this.ipdst = ipdst;
        this.payload = payload;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIpsrc(String ipsrc) {
        this.ipsrc = ipsrc;
    }

    public void setIpdst(String ipdst) {
        this.ipdst = ipdst;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getName() {
        return name;
    }

    public String getIpsrc() {
        return ipsrc;
    }

    public String getIpdst() {
        return ipdst;
    }

    public String getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return  name + ',' +
                ipsrc + ',' +
                ipdst + ',' +
                payload;
    }
}
