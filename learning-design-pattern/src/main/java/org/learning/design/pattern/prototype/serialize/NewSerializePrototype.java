package org.learning.design.pattern.prototype.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class NewSerializePrototype implements Serializable {
	private static final long serialVersionUID = -3964934424362460367L;
	private String id;
	private SerializePrototype serializePrototype;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SerializePrototype getSerializePrototype() {
		return serializePrototype;
	}

	public void setSerializePrototype(SerializePrototype serializePrototype) {
		this.serializePrototype = serializePrototype;
	}

	public Object deepClone() {
		try {
			ByteArrayOutputStream bo = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(bo);
			oo.writeObject(this);

			ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
			ObjectInputStream oi = new ObjectInputStream(bi);
			return oi.readObject();
		} catch (IOException | ClassNotFoundException e) {
			return null;
		}
	}
}
