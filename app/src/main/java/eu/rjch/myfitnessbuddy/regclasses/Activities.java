package eu.rjch.myfitnessbuddy.regclasses;

public class Activities {
    private String activity;
    private int activity_id;
    private boolean selected = true;

    public Activities(String pActivity, int pId){
        this.activity = pActivity;
        this.activity_id = pId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
