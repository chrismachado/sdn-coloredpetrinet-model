package comp;

public class ForwardDevice {

    private int id;
    private String lastFlow = "";
    private FlowTable flowTable = new FlowTable();

    public ForwardDevice(int id) {
        this.id = id;
    }
    public ForwardDevice(int id, String lastFlow, FlowTable flowTable) {
        this.id = id;
        this.lastFlow = lastFlow;
        this.flowTable = flowTable;
    }
    public ForwardDevice(int id, FlowTable flowTable) {
        this.id = id;
        this.flowTable = flowTable;
    }
    public boolean verifyFlow() {
        return !flowTable.isOnTable(this.lastFlow) || this.lastFlow.equals("");
    }

    public void setLastFlow(String lastFlow) {
        this.lastFlow = lastFlow;
        if (this.verifyFlow())
            this.flowTable.insert(lastFlow);
    }

    public String getLastFlow() {
        return this.flowTable.pop();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id +
                "@" + flowTable;
    }
}
