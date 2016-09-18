package tool;

/**
 * ���ڱ��Ľ���ʱ����ƫ����
 * @author Jiapf
 */
public class MsgOffset {
	
	private int value = 0;
	
	public MsgOffset() {
		this.value = 0;
	}
	
	public MsgOffset(int value) {
		this.value = value;
	}
	
	public void IncOffset() {
		this.value += 1;
	}
	
	public void IncOffset(int value) {
		this.value += value;
	}
	
	public int GetOffset() {
		return value;
	}
	
	public void Reset() {
		this.value = 0;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
