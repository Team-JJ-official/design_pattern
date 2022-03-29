package _19_state;

public class UrgentState implements State {
    private static UrgentState singleton = new UrgentState();
    public static State getInstance() {
        return singleton;
    }
    private UrgentState() {}

    @Override
    public void doClock(Context context, int hour) {}

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("非常：非常時の金庫使用！");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル（非常時）");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("非常：非常時の電話使用！");
    }
}
