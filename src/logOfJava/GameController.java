package logOfJava;

import java.io.File;
import java.util.List;

public class GameController {
	// 암튼 그거다.
	Game g = new Game();
	private Player player = new Player();
	private ItemController ic = new ItemController();
	
	// 기본 생성자
	public GameController() {};
	
	// 새 게임 데이터 생성
	public void newData(String playerName, String job) {
		this.player = new Player(playerName, new Job(job));
		g = new Game(player, 1);
	}
	
	// 저장된 데이터 검색 (플레이어명)
	public boolean searchData(String searchPlayer) {
		String currentDirectory = System.getProperty("user.dir");
		File file = new File(currentDirectory, searchPlayer + ".text");
		return file.exists();
	}
	
	// 저장된 데이터 불러오기
	
	// 현재 게임 진행 상태 출력
	public void playingState() {
		System.out.println("< " + player.getPlayerName() + " - " + player.getJob().getJob() + " >");
		System.out.println("HP : " + player.getHP() + " / " + player.getJob().getJobHP());
		System.out.println("현재 층수 : " + g.getStage());
	}
	
	// 플레이어 스테이터스
	public void playerStatus() {
		System.out.println("플레이어명 : " + player.getPlayerName());
		System.out.println("직업 : " + player.getJob().getJob());
		System.out.println("소지 아이템 수 : " + player.getItemList().size());
		System.out.println("============ 상세 스테이터스 ============");
		System.out.print("체력\t" + player.getJob().getJobHP() + "\t\t");
		System.out.println("행운\t" + player.getJob().getJobLUCK());
		System.out.print("근력\t" + player.getJob().getJobATK() + "\t\t");
		System.out.println("보너스\t" + player.getJob().getJobBONUS());
		System.out.println("지능\t" + player.getJob().getJobINT() + "\n");
	}
	
	// 플레이어명 수정
	public boolean playerNameChange(String playerName) {
		player.setPlayerName(playerName);
		
		if(playerName.equals(player.getPlayerName())) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// 아이템 목록 크기 반환
	public int itemListSize() {
		return player.getItemList().size();
	}
	
	// 아이템 목록 불러오기
	public void itemList() {
		List itemList = player.getItemList();
		for(int i = 0; i < itemList.size(); i++) {
			System.out.println("[" + (i + 1) + ". " + itemList.get(i) + "]");
		}
		System.out.println();
	}
	
	// 아이템 상세 불러오기
	public String itemDetail(int itemIndex) {
		List itemList = player.getItemList();
		return ic.itemDetailPrint(itemList.get(itemIndex).toString());
	}
	
	// 아이템 사용
	public void itemUse(int itemIndex) {
		List itemList = player.getItemList();
		String itemName = itemList.get(itemIndex).toString();
		
		if(ic.itemUsing(player, itemName)) {
			itemList.remove(itemIndex);
			System.out.println("▷ 아이템 사용을 완료했습니다. 메인으로 돌아갑니다.");
		}
	}
	
	// player 정보 반환
	public Player getPlayer() {
		return this.player;
	}
}
