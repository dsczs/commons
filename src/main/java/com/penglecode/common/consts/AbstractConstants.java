package com.penglecode.common.consts;

/**
 * 常量基类
 * 
 * @author	  	pengpeng
 * @date	  	2014年7月18日 下午10:43:06
 * @version  	1.0
 */
public abstract class AbstractConstants {

	/**
	 * 一个静态方法用于创建Constant对象
	 * @param defaultValue
	 * @return
	 */
	public static <T> Constant<T> valueOf(T defaultValue) {
		return new Constant<T>(defaultValue);
	}
	
	/**
	 * 常量值的包装对象
	 * @param <T>
	 * @author	  	pengpeng
	 * @date	  	2014年7月19日 下午10:17:56
	 * @version  	1.0
	 */
	public static final class Constant<T> {
		
		private T value;
		
		private Constant(T value){
			this.value = value;
		}
		
		public T VALUE(){
			return value;
		}

		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@SuppressWarnings("unchecked")
		public boolean equals(Object obj) {
			if (obj == null || getClass() != obj.getClass()){
				return false;
			}
			if (this == obj){
				return true;
			}
			Constant<T> other = (Constant<T>) obj;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		public String toString() {
			return value.toString();
		}
		
	}

}
