package logOfJava;

import java.util.ArrayList;
import java.util.List;

public class ItemController {
	private List<Item> itemList = new ArrayList<>();
	
	// 기본 생성자
	public ItemController() {
		super();
		// 회복 아이템
		itemList.add(new Item("시작의 주먹밥", "여행의 시작은 주먹밥과 함께.", "평범한 주먹밥. 체력을 10만큼 회복시켜준다.", "회복", 10));
		itemList.add(new Item("마라탕후루", "탕탕후루후루 탕탕후루루루루", "마라탕과 탕후루. 체력을 20만큼 회복시켜준다.", "회복", 20));
		itemList.add(new Item("혈액팩(2L)", "아무 일도... 없었다...!", "긴급 수혈용 혈액팩. 체력을 100만큼 회복시켜준다.", "회복", 100));
		itemList.add(new Item("수상한 버섯", "어떤 버섯은 일생에 딱 한 번만 먹을 수 있다지.", "누가봐도 수상해 보이는 버섯. 먹으면 큰일날 거 같다.", "회복", -5));
		
		// 강화 아이템
		itemList.add(new Item("피 묻은 성배", "피라고 생각했는데 포도주였어.", "무언가 묻어있는 성배. 최대 체력을 50만큼 상승시켜준다.", "강화/HP", 50));
		itemList.add(new Item("코코넛맛 프로틴", "난 안 울어. 그거 유산소잖아.", "코코넛맛이 나는 프로틴이다. 근력을 20만큼 상승시켜준다.", "강화/ATK", 20));
		itemList.add(new Item("연금술사의 마지막 연성진", "정답이다 연금술사.", "누군가의 연성진. 지능을 30만큼 상승시켜준다.", "강화/INT", 30));
		itemList.add(new Item("고대의 금화", "또 유적을 파괴했구나 인디아나 존스!", "반짝반짝 빛나는 오래된 금화. 행운을 5만큼 상승시켜준다.", "강화/LUCK", 5));
		itemList.add(new Item("수맥봉", "수맥이랑 아이템이랑 무슨 상관이냐고!", "수맥탐지용 수맥봉. 아이템 드롭률을 10만큼 상승시켜준다.", "강화/BONUS", 10));
		
		// 전투 아이템
		itemList.add(new Item("쥐덫", "치즈를 달아둔 쥐덫에 걸리는 몬스터가 진짜로 있다고?", "쥐 잡기용 쥐덫. 적에게 15만큼의 대미지를 준다.", "전투", 15));
		itemList.add(new Item("함정카드", "YOU JUST ACTIVITY MY TRAP CARD", "즉발형 함정카드. 적에게 25만큼의 대미지를 준다.", "전투", 25));
		itemList.add(new Item("다이너마이트", "폭발은 예술이다!!!", "탄광에서 쓰는 다이너마이트. 적에게 60만큼의 대미지를 준다.", "전투", 60));
	};
	
	// 아이템 인덱스값 반환
	public int itemIndexReturn(String item) {
		for(int i = 0; i < itemList.size(); i++) {
			if(item.equals(itemList.get(i).itemName)) {
				return i;
			}
		}
		return 404;
	}
	
	// 아이템 상세 정보 출력
	public String itemDetailPrint(String item) {
		int index = itemIndexReturn(item);
		if(index == 404) {
			return "▷ 아이템 정보를 불러오는데 실패했습니다.\n";
		}
		else {
			return itemList.get(index).toString();
		}
	}
	
	// 아이템 분류값 반환
	public String itemCtgReturn(int itemIndex) {
		return itemList.get(itemIndex).getItemCtg();
	}
	
	// 아이템 수치값 반환
	public int itemEffectReturn(int itemIndex) {
		return itemList.get(itemIndex).getItemEffect();
	}
	
	// 아이템 사용
	public boolean itemUsing(Player pl, String item) {
		Player player = pl;
		int index = itemIndexReturn(item);
		String ctg = itemCtgReturn(index);
		
		switch(ctg) {
		case "회복" :
			int max = player.getJob().getJobHP();
			int recovery = itemEffectReturn(index);
			
			if(max == player.getHP()) {
				System.out.println("▷ 이미 HP가 가득찬 상태이므로 아이템을 사용할 수 없습니다.\n");
				return false;
			}
			else if(max <= (player.getHP() + recovery)) {
				player.setHP(max);
				System.out.println("▷ HP가 전부 회복되었습니다.\n");
			}
			else {
				player.setHP(player.getHP() + recovery);
			}
			break;
		case "전투" :
			// 전투 상황이 아니면 사용 불가능하게 설정
			break;
		default :
			itemReinforce(itemIndexReturn(item), ctg, player);
			break;
		}
		
		return true;
	}
	
	// 강화 아이템 전용
	public boolean itemReinforce(int index, String ctg, Player player) {
		String ctgArr[] = ctg.split("/");
		int reinforce = itemEffectReturn(index);
		int addStat = 0;
		
		switch(ctgArr[1]) {
		case "HP" :
			addStat = player.getJob().getJobHP() + reinforce;
			player.setHP(addStat);
			break;
		case "ATK" :
			addStat = player.getJob().getJobATK() + reinforce;
			player.setATK(addStat);
			break;
		case "INT" :
			addStat = player.getJob().getJobINT() + reinforce;
			player.setINT(addStat);
			break;
		case "LUCK" :
			addStat = player.getJob().getJobLUCK() + reinforce;
			player.setLUCK(addStat);
			break;
		default :
			addStat = player.getJob().getJobBONUS() + reinforce;
			player.setBONUS(addStat);
			break;
		}
		
		return true;
	}
}
