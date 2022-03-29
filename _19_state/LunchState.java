package _19_state;

public class LunchState implements State {
    private static LunchState singleton = new LunchState();
    public static State getInstance() {
        return singleton;
    }
    private LunchState() {}

    @Override
    public void doClock(Context context, int hour) {
        if (hour != 12) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurityCenter("非常：昼飯食いながらの金庫使用！");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル（昼飯食いながら）");
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        context.recording("昼飯食いながらの通話録音");
    }
    
}
