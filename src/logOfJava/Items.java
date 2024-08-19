package logOfJava;

public class Items {
	// Items 변수
	public String itemName;
	public String itemFlavor;
	public String itemInfo;
	public String itemCtg;
	public int itemEffect;
	
	// 기본 생성자
	public Items() {};
	
	public Items(String itemName, String itemFlavor, String itemInfo, String itemCtg, int itemEffect) {
		super();
		this.itemName = itemName;
		this.itemFlavor = itemFlavor;
		this.itemInfo = itemInfo;
		this.itemCtg = itemCtg;
		this.itemEffect = itemEffect;
	};
	
	// toString
	@Override
	public String toString() {
		return "============ " + itemName + " ============\n"
				+ itemFlavor + "\n("
				+ itemInfo + ")\n";
	}

	// getter, setter
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemFlavor() {
		return itemFlavor;
	}

	public void setItemFlavor(String itemFlavor) {
		this.itemFlavor = itemFlavor;
	}

	public String getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}
	
	public String getItemCtg() {
		return itemCtg;
	}
	
	public void seetItemCtg() {
		this.itemCtg = itemCtg;
	}

	public int getItemEffect() {
		return itemEffect;
	}

	public void setItemEffect(int itemEffect) {
		this.itemEffect = itemEffect;
	}
	
}
