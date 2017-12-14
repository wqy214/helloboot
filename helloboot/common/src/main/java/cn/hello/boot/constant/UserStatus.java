package cn.hello.boot.constant;

/**
 * 用户状态
 * @author jameszhou
 *
 */
public enum UserStatus {

	ON(1),OFF(0);
	
	private int status = 1;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	UserStatus(int status) {
		this.status = status;
	}
}
