package bridge;

import static bridge.Application.*;

import java.util.ArrayList;
import java.util.List;

import Util.Validate;
import View.InputView;
import View.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int MIN_BRIDGE_LEN = 3;
    private static final int MAX_BRIDGE_LEN = 20;
    private static final String DOWN = "D";
    private static final String UP = "U";
    private static final String RESTART = "R";
    private static final String QUIT = "Q";
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    List<String> visited = new ArrayList<>();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    Bridge bridge;
    Validate validate = new Validate();
    private int tryNum = 1;
    private boolean isSuccess = true;
    public void init(String input) {
        validate.validateNumberRange(input, MIN_BRIDGE_LEN, MAX_BRIDGE_LEN);
        int bridgeLen = Integer.parseInt(input);
        List<String> answerBridge = bridgeMaker.makeBridge(bridgeLen);
        bridge = new Bridge(answerBridge);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(String direction) {
        validate.validateContainWord(direction, UP, DOWN);
        visited.add(direction);
        return visited;
    }
    public boolean isRightDirection(int idx, String direction) {
        return bridge.isRightDirection(idx, direction);
    }

    public List<String> getUpBridge() {
        List<String> upBridge = new ArrayList<>();
        for(int i = 0; i < visited.size(); i++) {
            boolean rightDirection = isRightDirection(i, visited.get(i));
            String result = getResult(i, UP, rightDirection);
            upBridge.add(result);
        }
        return upBridge;
    }
    public List<String> getDownBridge() {
        List<String> downBridge = new ArrayList<>();
        for(int i = 0; i < visited.size(); i++) {
            boolean rightDirection = isRightDirection(i, visited.get(i));
            String result = getResult(i, DOWN, rightDirection);
            downBridge.add(result);
        }
        return downBridge;
    }
    public boolean isGameCompleted() {
        if(bridge.isCrossDirection(visited) && isSuccess) {
            return true;
        }
        return false;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String select) {
        validate.validateContainWord(select, RESTART, QUIT);
        if(select.equals("R")) {
            restartInit();
            return true;
        }
        return false;
    }
    public void restartInit() {
        visited = new ArrayList<>();
        tryNum += 1;
        isSuccess = true;
    }
    public int getTryNum() {
        return tryNum;
    }
    public String getGameResult() {
        String result = "실패";
        if(isGameCompleted()) {
            result = "성공";
        }
        return result;
    }
}
