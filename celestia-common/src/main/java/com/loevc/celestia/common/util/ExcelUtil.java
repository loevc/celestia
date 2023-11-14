package com.loevc.celestia.common.util;

import com.alibaba.excel.EasyExcel;
import java.util.List;

public class ExcelUtil {

	private static final String DEFAULT_SHEET_NAME = "sheet1";


	public static <T> void writeExcel2File(List<T> list,String fileName,Class clazz){
		EasyExcel.write(fileName, clazz).sheet(DEFAULT_SHEET_NAME).doWrite(list);
	}


}
