package _19_state;

public class DayState implements State {
    private static DayState singleton = new DayState();

    private DayState() {}
    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (12 <= hour) {
            context.changeState(LunchState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recording("金庫使用(昼間)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル(昼間)");
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("通常の通話(昼間)");
    }

    public String toString() {
        return "[昼間]";
    }
    
}
