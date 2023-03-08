package swt.timer.beans;

@FunctionalInterface
public interface TimerListener {
    public void expired(TimerEvent event);
}
