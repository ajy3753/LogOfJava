package logOfJava;

import java.util.Scanner;

public class GameMenu {
	private GameController gc = new GameController();
	private Player player = new Player();
	private Scanner sc = new Scanner(System.in);
	private int choice;
	
	// 기본 생성자
	public GameMenu() {}
	
	// 시작화면
	public void gameStart() {
		System.out.println("********** Log Of Java **********");
		System.out.println("[1. 새 게임 시작하기]");
		System.out.println("[2. 이어하기]");
		System.out.println("[3. 종료]");
		
		System.out.print("▶ 메뉴 선택 : ");
		choice = sc.nextInt();
		
		switch(choice) {
		case 1 :
			System.out.println("\n▷ 캐릭터 생성으로 이동합니다.");
			newGame();
			break;
		case 2 :
			loadGame();
			break;
		case 3 :
			System.out.println("\n▷ 게임을 종료합니다.");
			return;
		default :
			System.out.println("\n▷ 잘못된 입력입니다. 처음으로 돌아갑니다.\n");
			gameStart();
		}
	}
	
	// 시작 화면 1 - 캐릭터 생성
	public void newGame() {
		System.out.println("\n============ 새 캐릭터 생성 ============");
		
		System.out.print("▶ 플레이어명을 입력하세요 (띄어쓰기 불가능) : ");
		String playerName = sc.next();
		sc.nextLine();
		
		System.out.println("\n▷ 입력한 플레이어명은 < " + playerName + " >입니다.");
		System.out.println("▷ 다음으로 직업을 선택해주세요.");
		
		String job = "";
		do {
			System.out.print("[1. 검사] \t");
			System.out.println("체력 ◆◆◆\t 근력 ◆◆◆\t 지능 ◆◇◇\t 행운 ◆◆◇\t 보너스 ◆◇◇");
			System.out.print("[2. 궁수] \t");
			System.out.println("체력 ◆◆◇\t 근력 ◆◆◇\t 지능 ◆◆◇\t 행운 ◆◆◇\t 보너스 ◆◆◇");
			System.out.print("[3. 마법사] \t");
			System.out.println("체력 ◆◇◇\t 근력 ◆◇◇\t 지능 ◆◆◆\t 행운 ◆◆◆\t 보너스 ◆◆◇");
			System.out.print("[4. 도적] \t");
			System.out.println("체력 ◆◆◇\t 근력 ◆◇◇\t 지능 ◆◇◇\t 행운 ◆◆◆\t 보너스 ◆◆◆");
			
			System.out.print("▶ 직업 선택 (숫자 입력) : ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1 :
				job = "검사";
				break;
			case 2 :
				job = "궁수";
				break;
			case 3 :
				job = "마법사";
				break;
			case 4 :
				job = "도적";
				break;
			default :
				System.out.println("▷ 잘못된 입력입니다. 다시 입력해주세요.\n");
			}
		} while(job.equals(""));
		
		System.out.println("\n< 캐릭터 생성 정보 >");
		System.out.println("플레이어명 : " + playerName);
		System.out.println("직업 : " + job);
		
		System.out.println("\n▷ 이 캐릭터로 게임을 시작할까요?");
		System.out.println("[1. 예]");
		System.out.println("[2. 아니오 (다시 생성)]");
		System.out.println("[3. 생성을 취소하고 시작 화면으로 돌아간다.]");
		
		System.out.print("▶ 메뉴 선택 : ");
		choice = sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1 :
			gc.newData(playerName, job);
			playGame();
			break;
		case 2 :
			newGame();
			break;
		default :
			System.out.println("▷ 시작 화면으로 돌아갑니다.\n");
			gameStart();
			return;
		}
	}
	
	// 시작 화면 2 - 이어하기
	public void loadGame() {
		System.out.println("\n============ 저장 데이터 불러오기 ============");
		System.out.print("▶ 데이터를 불러올 플레이어명을 입력하세요 : ");
		String searchPlayer = sc.next();
		sc.nextLine();
		
		if(gc.searchData(searchPlayer)) {
			while(true) {
				System.out.println("▷ 다음 데이터를 이어서 플레이하시겠습니까?");
				System.out.println("[1. 이어하기]");
				System.out.println("[2. 다른 데이터 불러오기]");
				
				System.out.print("▶ 메뉴 선택 : ");
				choice = sc.nextInt();
				sc.nextLine();
				
				if(choice == 1) {
					break;
				}
				else if(choice == 2) {
					loadGame();
					break;
				}
				else {
					System.out.println("▷ 잘못된 입력입니다. 다시 입력해주세요.\n");
				}
			}
		}
		else {
			System.err.println("▷ " + searchPlayer + "를 찾을 수 없습니다. 시작 화면으로 돌아갑니다.\n");
			gameStart();
		}
	}
	
	// 게임 플레이 - 메인 메뉴
	public void playGame() {
		System.out.println("\n********** Playing **********");
		// 현재 플레이어 정보 (이름 / 직업 / HP / 현재 층수)
		gc.playingState();
		System.out.println();
		
		// 행동 선택지
		while(true) {
			System.out.println("[1. 나아간다]");
			System.out.println("[2. 플레이어 정보]");
			System.out.println("[3. 소지 아이템]");
			System.out.println("[4. 게임 종료]");
			
			System.out.print("▶ 행동 선택 : ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1 :
				stageMenu();
				return;
			case 2 :
				playerMenu();
				return;
			case 3 :
				itemMenu();
				return;
			case 4 :
				gameStop();
				return;
			default :
				System.out.println("▷ 잘못된 입력입니다. 다시 입력해주세요.\n");
			}
		}
	}
	
	// 메인 1 - 스테이지 진행
	public void stageMenu() {
		if(gc.stageProgress()) {
			battleMenu();
			return;
		}
		else {
			System.out.println("\n********** 휴식 **********");
			System.out.println("▷ 안전한 공간을 발견했습니다.");
			
			do {
				System.out.println("[1. 휴식을 취한다. ( HP +10 )]");
				System.out.println("[2. 주변을 둘러본다. ( 랜덤 확률로 아이템 획득 )");
				
				System.out.print("▶ 행동 선택 : ");
				choice = sc.nextInt();
				sc.nextLine();
				
				switch(choice) {
				case 1 :
					gc.stageRecovery();
					break;
				case 2 :
					gc.stageItem();
					break;
				default :
					System.out.println("▷ 잘못된 입력입니다. 다시 선택해주세요.\n");
					continue;
				}
				
				choice = 0;
			} while(choice != 0);
		}
		
		System.out.print("▶ 다음 층으로 이동 (아무 키나 누르세요) : ");
		sc.nextLine();
		
		gc.stageUp();
		playGame();
	}
	
	// 메인 1.5 - 전투
	public void battleMenu() {
		System.out.println("\n********** Battle **********");
		// 배틀 시작
		// true > 승리, false > 패배
		if(gc.stageBattle()) {
			if(gc.getStage() == 15) {
				
			}
			else {
				System.out.print("▶ 다음 층으로 이동 (아무 키나 누르세요) : ");
				sc.nextLine();
				
				gc.stageUp();
				playGame();
				return;
			}
		}
		else {
			System.out.println("\n▷ 다시 도전하시겠습니까?");
			System.out.println("[1. 예]");
			System.out.println("[2. 아니오]");
			
			System.out.print("▶ 선택 : ");
			choice = sc.nextInt();
			sc.nextLine();
			
			if(choice == 1) {
				System.out.println("\n▷ 새 캐릭터 생성으로 이동합니다.");
				newGame();
			}
			
			System.out.println("\n▷ 게임을 종료합니다. 플레이 해주셔서 감사합니다.");
			return;
		}
	}
	
	// 메인 2 - 스테이터스
	public void playerMenu() {
		System.out.println("\n********** 플레이어 정보 일람 **********");
		gc.playerStatus();
		
		System.out.print("[1. 플레이어명 수정]\t");
		System.out.println("[2. 아이템 확인]");
		
		System.out.print("▶ 메뉴 선택 (0: 메인으로 돌아가기) : ");
		choice = sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1 :
			System.out.println("\n============ 플레이어명 수정 ============");
			System.out.print("▶ 플레이어명 수정 (띄어쓰기 불가능) : ");
			String playerName = sc.next();
			sc.nextLine();
			
			if(gc.playerNameChange(playerName)) {
				System.out.println("성공적으로 수정되었습니다.\n");
			}
			else {
				System.out.println("▷ 오류가 발생했습니다. 메인으로 돌아갑니다.\n");
			}
			playGame();
			return;
		case 2:
			itemMenu();
			return;
		default :
			playGame();
			return;
		}
	}
	
	// 메인 3 - 아이템
	public void itemMenu() {
		System.out.println("\n********** 소지 아이템 **********");
		int itemListSize = gc.itemListSize();
		
		if(itemListSize == 0) {
			System.out.println("\n▷ 소지중인 아이템이 없습니다. 메인으로 돌아갑니다.");
			playGame();
		}
		else {
			gc.itemList();
			
			System.out.print("▶ 아이템 선택 (0 : 메인으로 돌아가기 ) : ");
			int index = sc.nextInt();
			sc.nextLine();
			
			if(index == 0) {
				playGame();
				return;
			}
			else if(index > itemListSize) {
				System.out.println("▷ 잘못된 입력입니다. 다시 입력해주세요.\n");
			}
			else {
				System.out.println("\n" + gc.itemDetail(index - 1));
				System.out.print("[1. 아이템 사용]\t");
				System.out.println("[2. 목록으로 돌아가기]");
				
				System.out.print("▶ 메뉴 선택 : ");
				choice = sc.nextInt();
				sc.nextLine();
				
				if(choice == 1) {
					gc.itemUse(index - 1);
				}
			}
			itemMenu();
		}
	}
	
	// 메인 4 - 게임 종료
	public void gameStop() {
		System.out.println("\n▷ 게임을 종료하시겠습니까?");
		System.out.println("[1. 예]");
		System.out.println("[2. 아니오]");
		
		System.out.print("▶ 메뉴 선택 : ");
		choice = sc.nextInt();
		sc.nextLine();
		
		if(choice == 1) {
			System.out.println("\n▷ 지금까지의 진행상황을 저장하시겠습니까? (데이터는 플레이어명으로 저장됩니다.)");
			System.out.println("[1. 예. 지금까지의 진행상황을 저장하고 종료합니다.]");
			System.out.println("[2. 아니오. 저장하지 않고 종료합니다.]");
			
			System.out.print("▶ 메뉴 선택 : ");
			choice = sc.nextInt();
			sc.nextLine();
			
			if(choice == 1) {
				// boolean해서 저장되면 true
				System.out.println("▷ 저장 완료되었습니다.");
			}
			
			System.out.println("\n▷ 게임을 종료합니다.");
			return;
		}
		else {
			System.out.println("\n▷ 메인으로 돌아갑니다.");
			playGame();
			return;
		}
	}
	
	// 막줄 세이버
}
