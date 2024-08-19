package logOfJava;
public class Game {
	private Player player = new Player();
	private int stage;
	
	// 기본 생성자
	public Game() {};
	
	public Game(Player player, int stage) {
		this.player = player;
		this.stage = stage;
	}
	
	// getter
	public Player getPlayer() {
		return this.player;
	}
	
	public int getStage() {
		return this.stage;
	}
	
	// setter
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setStage(int stage) {
		this.stage = stage;
	}
}
