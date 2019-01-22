package org.learning.jvm;

/**
 * 设置方法区最大、最小空间：-XX:MetaspaceSize=3m -XX:MaxMetaspaceSize=3m -Xmx3m -Xms3m<br>
 */
public class StringOOMError {

	public static void main(String[] args) {
		String base = "StringLSFJAL;SDFJsdkfjsaldkfjasdl;f " + "ewoirwpmq;icnpwmirnwoqiruwinpolqruilnuipquwoq;im"
				+ "rwq,opqmwirifsjdlkajfklsdjfklasdjflasdjfalskdfjalsd;fja"
				+ "ldfjsadlfasjdfljasdlkfjasldfjalskdjfkalsdfjasldfjadasdfasflas"
				+ "dflsd;fjals;dfjasldfasdl;fjsdka;lfjdklcmdasl;ifj"
				+ "sid;afjaklsdjfal;sdfjals;dfjkdsal;fjdla;sdkjal;j" + "fal'sfjdslvndlksvlksdscsdfsdfsfs";
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			base += base;
		}
	}
}
