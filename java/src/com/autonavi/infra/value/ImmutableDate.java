package com.autonavi.infra.value;

import java.util.Date;

/**
 * 不可变Date类型，所有修改内部状态方法均抛出UnsupportedOperationException
 * 
 * @author zhenhua.lei
 * @version 0.1.0,2011-3-4
 */
final public class ImmutableDate extends Date {
	public ImmutableDate() {
		this.entity = new Date();
	}

	public ImmutableDate(long millisecond) {
		this.entity = new Date(millisecond);
	}

	@Override
	public boolean after(Date when) {
		return entity.after(when);
	}

	@Override
	public boolean before(Date when) {
		return entity.before(when);
	}

	@Override
	public ImmutableDate clone() {
		return new ImmutableDate(this.getTime());
	}

	@Override
	public int compareTo(Date anotherDate) {
		return entity.compareTo(anotherDate);
	}

	@Override
	public boolean equals(Object obj) {
		return entity.equals(obj);
	}

	@Override
	@Deprecated
	public int getDate() {
		return entity.getDate();
	}

	@Override
	@Deprecated
	public int getDay() {
		return entity.getDay();
	}

	@Override
	@Deprecated
	public int getHours() {
		return entity.getHours();
	}

	@Override
	@Deprecated
	public int getMinutes() {
		return entity.getMinutes();
	}

	@Override
	@Deprecated
	public int getMonth() {
		return entity.getMonth();
	}

	@Override
	@Deprecated
	public int getSeconds() {
		return entity.getSeconds();
	}

	@Override
	public long getTime() {
		return entity.getTime();
	}

	@Override
	@Deprecated
	public int getTimezoneOffset() {
		return entity.getTimezoneOffset();
	}

	@Override
	@Deprecated
	public int getYear() {
		return entity.getYear();
	}

	@Override
	public int hashCode() {
		return entity.hashCode();
	}

	@Override
	@Deprecated
	public void setDate(int date) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Deprecated
	public void setHours(int hours) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Deprecated
	public void setMinutes(int minutes) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Deprecated
	public void setMonth(int month) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Deprecated
	public void setSeconds(int seconds) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Deprecated
	public void setTime(long time) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Deprecated
	public void setYear(int year) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Deprecated
	public String toGMTString() {
		return entity.toGMTString();
	}

	@Override
	@Deprecated
	public String toLocaleString() {
		return entity.toLocaleString();
	}

	@Override
	public String toString() {
		return entity.toString();
	}

	final private Date entity;

	private static final long serialVersionUID = 3580674010213759227L;

}
