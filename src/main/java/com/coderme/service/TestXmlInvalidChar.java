package com.coderme.service;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TestXmlInvalidChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 测试的字符串应该为：<r><c d="s" n="j"></c></r>
		// 正常的对应的byte数组为
		byte[] ba1 = new byte[] { 60, 114, 62, 60, 99, 32, 100, 61, 34, 115,
				34, 32, 110, 61, 34, 106, 34, 62, 60, 47, 99, 62, 60, 47, 114,
				62 };
		System.out.println("ba1 length=" + ba1.length);
		String ba1str = new String(ba1);
		System.out.println(ba1str);
		System.out.println("ba1str length=" + ba1str.length());
		System.out.println("-----------------------------------------");
		// 和正常的byte 数组相比 多了一个不可见的 31
		byte[] ba2 = new byte[] { 60, 114, 62, 60, 99, 32, 100, 61, 34, 115,
				34, 32, 110, 61, 34, 106, 31, 34, 62, 60, 47, 99, 62, 60, 47,
				114, 62 };
		System.out.println("ba2 length=" + ba2.length);
		String ba2str = new String(ba2);
		System.out.println(ba2str);
		System.out.println("ba2str length=" + ba2str.length());
		System.out.println("-----------------------------------------");
		try {
			DocumentBuilderFactory dbfactory = DocumentBuilderFactory
					.newInstance();
			dbfactory.setIgnoringComments(true);
			DocumentBuilder docBuilder = dbfactory.newDocumentBuilder();

			// 过滤掉非法不可见字符 如果不过滤 XML解析就报异常
			String filter = ba2str.replaceAll(
					"[\\x00-\\x08\\x0b-\\x0c\\x0e-\\x1f]", "");
			System.out.println("过滤后的length=" + filter.length());
			ByteArrayInputStream bais = new ByteArrayInputStream(
					filter.getBytes());
			Document doc = docBuilder.parse(bais);
			Element rootEl = doc.getDocumentElement();
			System.out.println("过滤后解析正常 root child length="
					+ rootEl.getChildNodes().getLength());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}