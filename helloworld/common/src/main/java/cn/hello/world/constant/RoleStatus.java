package cn.hello.world.constant;

/**
 * 角色状态
 *
 */
public enum RoleStatus {

	ON(1),OFF(0);
	
	private int status = 1;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	RoleStatus(int status) {
		this.status = status;
	}
}
