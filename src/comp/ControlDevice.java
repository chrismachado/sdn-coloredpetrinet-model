package comp;

import java.util.ArrayList;

public class ControlDevice {

    private String name;
    private ArrayList<ForwardDevice> fwdList;
    private ArrayList<Action> actions;

    public ControlDevice(String name) {
        this.name = name;
        this.fwdList = new ArrayList<ForwardDevice>();
        this.actions = new ArrayList<Action>();
    }

    public void addDevice(ForwardDevice fwd) {
        this.fwdList.add(fwd);
    }

    public ForwardDevice getLastFwd() {
        if (this.fwdList.size() == 0) return null;
        return this.fwdList.get(this.fwdList.size() - 1);
    }
    public void popDevice() {
        if (this.fwdList.size() == 0) return;
        this.fwdList.remove(this.fwdList.size() - 1);
    }

    public void addNewFlow(int id, String flow) {
        int fwdListId = 0;
        for (ForwardDevice fwd : this.fwdList) {
            if (fwd.getId() == id) break;
            fwdListId++;
        }
        try {
            ForwardDevice fwd = this.fwdList.get(fwdListId);
            fwd.setLastFlow(flow);
        } catch (ArrayIndexOutOfBoundsException aie) {
            System.err.println("Cannot added new flow, because the element doesn't exist. \n"
                    + aie.getMessage());
        }
    }

    public void addAction(String action) {
        String type = action.split(" ")[0];
        String address = action.split(" ")[1];
        this.actions.add(new Action(type, address));
    }

    public Action getLastAction() {
        return this.actions.get(this.actions.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder tempR = new StringBuilder();
        for (ForwardDevice fwd : fwdList)
            tempR.append(fwd.toString());
        return this.name + "!" + tempR.toString();
    }
}
