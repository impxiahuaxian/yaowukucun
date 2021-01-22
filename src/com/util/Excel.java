package com.util;

import java.io.File;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Excel {
	// 报表Excel生成
	public String getExcel(List<String[]> strList, String[] strTitle, String banner, String paths) {
		String fp = "upfiles\\" + VeDate.getStringDatex() + ".xls";
		String filepath = paths + fp;
		try {
			WritableWorkbook book = Workbook.createWorkbook(new File(filepath));
			//生成第一页名为进货订单表的表格
			WritableSheet sheet = book.createSheet(banner, 0);
			for (int i = 0; i < strTitle.length; i++) {
				//先把标题行生成
				sheet.addCell(new Label(i, 0, strTitle[i]));
			}
			for (int i = 0; i < strList.size(); i++) {
				String[] str = strList.get(i);
				for (int j = 0; j < str.length; j++) {
					try {
						Label label = new Label(j, i + 1, str[j]);
						sheet.addCell(label);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			//写入数据并关闭文件
			book.write();
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fp;
	}

}
