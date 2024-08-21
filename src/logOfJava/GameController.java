package logOfJava;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class GameController {
	// 암튼 그거다.
	private Game g;
	private Player player;
	private ItemController ic = new ItemController();
	private Scanner sc = new Scanner(System.in);
	
	// 기본 생성자
	public GameController() {}
	
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
	
	// 스테이지 진행
	public boolean stageProgress() {
		// 전투 판별
		int battleOn = (int)(Math.random() * 100 + 1);
		if(battleOn < player.getLUCK()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// 전투 진행
	public void stageBattle() {
		// 몹불러오기
		
		// 공격 커맨드 띄우기
		
	}
	
	// 휴식 1 - 체력 회복
	public void stageRecovery() {
		System.out.println("\n▷ 휴식을 취합니다.");
		int max = player.getJob().getJobHP();
		if(max == player.getHP()) {
			System.out.println("▷ 이미 HP가 가득한 상태이므로 HP가 회복되지 않았습니다.\n");
		}
		else if(max <= (player.getHP() + 10)) {
			System.out.println("▷ HP가 전부 회복되었습니다.\n");
			player.setHP(max);
		}
		else {
			System.out.println("\n▷ HP가 10 회복되었습니다.");
			System.out.println("▷ 현재 HP : " + player.getHP() + " / " + max + "\n");
			player.setHP(player.getHP() + 10);
		}
	}	
	
	// 휴식 2 - 아이템 획득
	public void stageItem() {
		System.out.println("\n▷ 근처에서 괜찮은 아이템을 찾아봅니다.");
		if(itemListSize() >= 5) {
			System.out.println("▷ 이런! 소지 가능한 아이템 수를 초과하여 더 얻을 수 없습니다.\n");
		}
		else {
			int dropRate = (int)(Math.random() * 100 + 1);
			if((100 - dropRate) <= player.getBONUS()) {
				ic.itemDrop(player, 1);
			}
			else {
				System.out.println("▷ 아무 것도 발견하지 못했습니다...\n");
			}
		}
	}
	
	// 플레이어 스테이터스
	public void playerStatus() {
		System.out.println("플레이어명 : " + player.getPlayerName());
		System.out.println("직업 : " + player.getJob().getJob());
		System.out.println("소지 아이템 수 : " + player.getItemList().size());
		System.out.println("============ 상세 스테이터스 ============");
		System.out.print("체력\t" + player.getHP() + " / " + player.getJob().getJobHP() + "\t\t");
		System.out.println("행운\t" + player.getLUCK());
		System.out.print("근력 \t" + player.getATK() + "\t\t\t");
		System.out.println("보너스\t" + player.getBONUS());
		System.out.println("지능 \t" + player.getINT() + "\n");
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
		}
		
		player.setItemList(itemList);
	}
	
	// player 정보 반환
	public Player getPlayer() {
		return this.player;
	}
	
	// stage 이동
	public void stageUp() {
		g.setStage(g.getStage() + 1);
	}
}
