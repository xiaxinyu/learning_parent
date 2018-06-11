package org.learning.design.pattern.prototype.deepcopy;

import org.learning.design.pattern.prototype.lightcopy.Prototype;

/**
 * 深拷贝不仅拷贝对象本身，而且拷贝对象包含的引用指向的所有对象。
 * @author summer.xiasz
 *
 */
public class NewPrototype implements Cloneable {
	private String id;
	private Prototype prototype;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Prototype getPrototype() {
		return prototype;
	}

	public void setPrototype(Prototype prototype) {
		this.prototype = prototype;
	}

	@Override
	public Object clone() {
		NewPrototype ret = null;
		try {
			ret = (NewPrototype) super.clone();
			ret.prototype = (Prototype) this.prototype.clone();
			return ret;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
