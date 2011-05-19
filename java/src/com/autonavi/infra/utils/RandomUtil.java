package com.autonavi.infra.utils;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

public final class RandomUtil {
	public static void main(String[] args) {
		RandomEnum<A> randomEnum = randomEnum(A.class, new Random());
		for (int i = 0; i < 10; i++) {
			System.out.println(randomEnum.next());
		}
	}

	public static double nextDouble(double start, double end, Random random) {
		if (start > end) {
			throw new IllegalArgumentException(String.format(
					"start > end : %s,%s", start, end));
		}
		double ran = random.nextDouble();
		double result = start + (ran * (end - start));
		return result;
	}

	/**
	 * contain start,end
	 * 
	 * @param start
	 * @param end
	 * @param random
	 * @return
	 */
	public static int nextInt(int start, int end, Random random) {
		if (start > end) {
			throw new IllegalArgumentException(String.format(
					"start > end : %s,%s", start, end));
		}
		int ran = random.nextInt(end - start + 1);
		int result = start + ran;
		return result;
	}

	public static <E extends Enum<E>> RandomEnum<E> randomEnum(
			Class<E> eleType, Random random) {
		return new SimpleRandomEnum<E>(random, EnumSet.allOf(eleType));
	}

	public static interface RandomEnum<E extends Enum<E>> {
		public E next();
	}

	private enum A {
		cat, dog, panda, tiger
	}

	private static class SimpleRandomEnum<E extends Enum<E>> implements
			RandomEnum<E> {
		private SimpleRandomEnum(Random r, EnumSet<E> enums) {
			super();
			this.r = r;
			list = new ArrayList<E>(enums);
		}

		@Override
		final public E next() {
			return list.get(r.nextInt(list.size()));
		}

		final private List<E> list;
		final private Random r;

	}
}
