package com.coderme.core.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.coderme.dto.ContactsDto;

public class XmlObjUtil {

	public static String getXmlString(Object obj) throws Exception{
    	if(null==obj){
    		return "error:obj is null";
    	}
    	
        String rs=null;
        StringWriter sw =null;
        try{
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            sw = new StringWriter();
            m.marshal(obj,sw);
            sw.close(); 
            rs=sw.getBuffer().toString();
            return rs;
        }catch (Exception e) {
            throw e;
        }finally{
            if(null!=sw){
                sw.close();
            }
        }
    }
	
	@SuppressWarnings("rawtypes")
	public static Object getXmlObj(Class cls,String objStr) throws Exception{
        Object obj=null;
        StringReader reader=null;
        try{
            JAXBContext context = JAXBContext.newInstance(cls);
            Unmarshaller um = context.createUnmarshaller();
            reader=new StringReader(objStr);
            obj=um.unmarshal(reader);
            reader.close(); 
            return obj;
        }catch (Exception e) {
            throw e;
        }finally{
            if(null!=reader){
                reader.close();
            }
        }
    }
	
	public static void main(String[] a) throws Exception {
		ContactsDto contactsDto = new ContactsDto();
		contactsDto.setEmail("7@qq.com");
		contactsDto.setGroup("gp");
		contactsDto.setMobileNumber("123456789");
		contactsDto.setTelephoneNumber("021-000124");
		String str = getXmlString(contactsDto);
		System.out.println(str);
	}
}
