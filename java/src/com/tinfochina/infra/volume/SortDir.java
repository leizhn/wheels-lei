package com.tinfochina.infra.volume;

/**
 * ��ʾ������
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
	 * ���ݱ���ʵ����
	 * 
	 * @param description
	 *            0Ϊ��������Ϊ����
	 * @return ��ʾ����Ķ���
	 */
	public static SortDir instance(int description) {
		if (description == 0)
			return ASC;
		else
			return DESC;
	}

	/**
	 * ���ݱ���ʵ����
	 * 
	 * @param description
	 *            desc(���ִ�Сд)�ǽ�������Ϊ����
	 * @return ��ʾ����Ķ���
	 */
	public static SortDir instance(String description) {
		if (description.equalsIgnoreCase("DESC")
				|| description.equalsIgnoreCase("descend"))
			return DESC;
		else
			return ASC;
	}

	/**
	 * ����
	 */
	public static SortDir ASC = new SortDir("ascend");
	/**
	 * ����
	 */
	public static SortDir DESC = new SortDir("descend");
}
