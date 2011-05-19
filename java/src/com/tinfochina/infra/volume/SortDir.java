package com.tinfochina.infra.volume;

/**
 * 表示排序方向
 * 
 * @author zhenhua.lei
 * @version 0.1.1,2011-5-19
 * @deprecated
 */
final public class SortDir {
	private SortDir(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		else
			return false;
	}

	@Override
	public int hashCode() {
		return this.getClass().hashCode() + this.description.hashCode();
	}

	final public String description;

	/**
	 * 根据编码实例化
	 * 
	 * @param description
	 *            0为升序，其他为降序
	 * @return 表示排序的对象
	 */
	public static SortDir instance(int description) {
		if (description == 0)
			return ASC;
		else
			return DESC;
	}

	/**
	 * 根据编码实例化
	 * 
	 * @param description
	 *            desc(部分大小写)是降序，其他为升序
	 * @return 表示排序的对象
	 */
	public static SortDir instance(String description) {
		if (description.equalsIgnoreCase("DESC")
				|| description.equalsIgnoreCase("descend"))
			return DESC;
		else
			return ASC;
	}

	/**
	 * 升序
	 */
	public static SortDir ASC = new SortDir("ascend");
	/**
	 * 降序
	 */
	public static SortDir DESC = new SortDir("descend");
}
