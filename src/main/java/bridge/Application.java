package bridge;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        init();
        gameStart(bridgeGame);
    }

    private static void init() {
        outputView.printGameStart();
        String input = inputView.readBridgeSize();
        bridgeGame.init(input);
    }

    private static void gameStart(BridgeGame bridgeGame) {
        while(true) {
            boolean move = bridgeGame.move();
            if(bridgeGame.isGameCompleted()) {
                break;
            }
            if(!move && !bridgeGame.retry()) {
                break;
            }
        }
    }
}
