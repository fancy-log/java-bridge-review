package bridge;

import java.util.ArrayList;
import java.util.List;

import View.InputView;
import View.OutputView;

public class Application {
    private static final String DOWN = "D";
    private static final String UP = "U";
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static List<String> visited;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            init();
            gameStart();
            printGameResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void init() {
        outputView.printGameStart();
        String input = inputView.readBridgeSize();
        bridgeGame.init(input);
    }

    private static void gameStart() {
        while(true) {
            String direction = inputView.readMoving();
            visited = bridgeGame.move(direction);
            printUpBridge();
            printDownBridge();
            if(bridgeGame.isGameCompleted()) {
                break;
            }
            if(!bridgeGame.isRightDirection(visited.size()-1, direction) && !retry()) {
                break;
            }
        }
    }
    private static void printUpBridge() {
        List<String> upBridge = new ArrayList<>();
        for(int i = 0; i < visited.size(); i++) {
            boolean rightDirection = bridgeGame.isRightDirection(i, visited.get(i));
            String result = getResult(i, UP, rightDirection);
            upBridge.add(result);
        }
        outputView.printMap(upBridge);
    }

    private static void printDownBridge() {
        List<String> downBridge = new ArrayList<>();
        for(int i = 0; i < visited.size(); i++) {
            boolean rightDirection = bridgeGame.isRightDirection(i, visited.get(i));
            String result = getResult(i, DOWN, rightDirection);
            downBridge.add(result);
        }
        outputView.printMap(downBridge);
    }

    public static String getResult(int i, String direction, boolean rightDirection) {
        String result = "O";
        if(!rightDirection) {
            result ="X";
        }
        if(!visited.get(i).equals(direction)) {
            result = " ";
        }
        return result;
    }
    public static boolean retry() {
        String select = inputView.readGameCommand();
        return bridgeGame.retry(select);
    }
    private static void printGameResult() {
        outputView.printEnding();
        printUpBridge();
        printDownBridge();
        String result = bridgeGame.getGameResult();
        int tryNum = bridgeGame.getTryNum();
        outputView.printResult(result,tryNum);
    }
}
