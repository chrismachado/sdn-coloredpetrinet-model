package comp;

import java.util.ArrayList;

public class FlowTable {

    private ArrayList<String> flowTable;

    public FlowTable() {
        this.flowTable = new ArrayList<String>();
    }

    public String pop() {
        if (flowTable.size() == 0) return "";
        return flowTable.remove(flowTable.size() - 1);
    }

    public void insert(String flow) {
        flowTable.add(flow);
    }

    public boolean isOnTable(String flow) {
        return this.flowTable.contains(flow);
    }

    @Override
    public String toString() {
        StringBuilder tempR = new StringBuilder();
        for (String flow : flowTable)
            tempR.append(flow).append("#");
//        tempR.deleteCharAt(tempR.length() - 1);
        return tempR.toString();
    }
}
