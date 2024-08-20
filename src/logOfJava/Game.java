package logOfJava;
public class Game {
	private Player player = new Player();
	private int stage;
	
	// 기본 생성자
	public Game() {}
	
	public Game(Player player, int stage) {
		this.player = player;
		this.stage = stage;
	}

	// getter, setter
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}
}
