package bridge;

import java.util.List;

public class Bridge {
    private List<String> answerBridge;

    public Bridge(List<String> answerBridge) {
        this.answerBridge = answerBridge;
    }

    public boolean RightDirection(int index, String direction) {
        if (answerBridge.get(index).equals(direction)) {
            return true;
        }
        return false;
    }
}