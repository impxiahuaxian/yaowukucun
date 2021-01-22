package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entity.Conf;
import com.entity.Vegs;
import com.entity.Orders;
import com.service.ConfService;
import com.service.VegsService;
import com.service.OrdersService;
import com.util.Excel;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping(value = "/chartBar", produces = "text/plain;charset=utf-8")
public class ChartBarAction extends BaseAction {
	@Autowired
	@Resource
	private VegsService vegsService;
	@Autowired
	@Resource
	private ConfService confService;
	@Autowired
	@Resource
	private OrdersService ordersService;

	@RequestMapping("preChartBar.action")
	public String preChartBar() {
		List<Vegs> vegsList = this.vegsService.getAllVegs();
		this.getRequest().setAttribute("vegsList", vegsList);
		return "chart";
	}

	@RequestMapping("chartBar.action")
	@ResponseBody
	public String chartBar() throws JSONException {
		String id = this.getRequest().getParameter("id");
		Vegs vegs = this.vegsService.getVegsById(id);
		double snum = Double.parseDouble(vegs.getSnum());
		JSONArray vegsname = new JSONArray();
		vegsname.put(vegs.getVegsname());
		JSONArray snumscount = new JSONArray();
		//库存
		snumscount.put(snum);
		snumscount.put(0);
		snumscount.put(0);
		snumscount.put(0);
		JSONArray cate = new JSONArray();
		cate.put("库存");
		cate.put("需求量");
		cate.put("当日消耗量");
		cate.put("日均消耗量");
		Orders orders = new Orders();
		orders.setVegsid(id);
		orders.setStatus("未完成");
		List<Orders> needList = this.ordersService.getOrdersByCond(orders);
		double needs = 0;
		for (Orders x : needList) {
			needs += Double.parseDouble(x.getNum());
		}
		JSONArray needscount = new JSONArray();
		//需求量
		needscount.put(0);
		needscount.put(needs);
		needscount.put(0);
		needscount.put(0);
		orders.setStatus("完成");
		List<Orders> sellList = this.ordersService.getOrdersByCond(orders);
		double sell = 0;
		for (Orders x : sellList) {
			sell += Double.parseDouble(x.getNum());
		}
		JSONArray sellscount = new JSONArray();
		//当日消耗量
		sellscount.put(0);
		sellscount.put(0);
		sellscount.put(sell);
		sellscount.put(0);
		Conf conf = this.confService.getConfById("1");
		String today = VeDate.getStringDateShort();
		int cycle = Integer.parseInt(conf.getCycles());
		double allSell = 0;
		for (int i = cycle; i >= 0; i--) {
			String nxtDay = VeDate.getNextDay(today, "" + i);
			Orders xx = new Orders();
			xx.setVegsid(id);
			xx.setStatus("完成");
			xx.setAddtime(nxtDay);
			List<Orders> xList = this.ordersService.getOrdersByCond(xx);
			for (Orders x : xList) {
				allSell += Double.parseDouble(x.getNum());
			}
		}
		//日均消耗量
		allSell = allSell / cycle;
		JSONArray allSellscount = new JSONArray();
		allSellscount.put(0);
		allSellscount.put(0);
		allSellscount.put(0);
		allSellscount.put(allSell);
		JSONObject json = new JSONObject();
		json.put("allSell", allSellscount.toString());
		json.put("sells", sellscount.toString());
		json.put("needs", needscount.toString());
		json.put("snum", snumscount.toString());
		json.put("vegsname", vegsname.toString().toString().replaceAll("\"", ""));
		json.put("cate", cate.toString().replaceAll("\"", ""));
		return json.toString();
	}

	@RequestMapping("chartBar1.action")
	@ResponseBody
	public String chartBar1() throws JSONException {
		String id = this.getRequest().getParameter("id");
		Vegs vegs = this.vegsService.getVegsById(id);
		double snum = Double.parseDouble(vegs.getSnum());
		JSONArray vegsname = new JSONArray();
		vegsname.put(vegs.getVegsname());
		JSONArray snumscount = new JSONArray();
		snumscount.put(snum);
		snumscount.put(0);
		snumscount.put(0);
		snumscount.put(0);
		JSONArray cate = new JSONArray();
		cate.put("库存");
		cate.put("需求量");
		cate.put("当日消耗量");
		cate.put("日均消耗量");
		Orders orders = new Orders();
		orders.setVegsid(id);
		orders.setStatus("未完成");
		List<Orders> needList = this.ordersService.getOrdersByCond(orders);
		double needs = 0;
		for (Orders x : needList) {
			needs += Double.parseDouble(x.getNum());
		}
		JSONArray needscount = new JSONArray();
		needscount.put(0);
		needscount.put(needs);
		needscount.put(0);
		needscount.put(0);
		orders.setStatus("完成");
		List<Orders> sellList = this.ordersService.getOrdersByCond(orders);
		double sell = 0;
		for (Orders x : sellList) {
			sell += Double.parseDouble(x.getNum());
		}
		JSONArray sellscount = new JSONArray();
		sellscount.put(0);
		sellscount.put(0);
		sellscount.put(sell);
		sellscount.put(0);
		Conf conf = this.confService.getConfById("1");
		String today = VeDate.getStringDateShort();
		String ltoday = "" + (Integer.parseInt(today.substring(0, 3)) - 1) + today.substring(4);
		int cycle = Integer.parseInt(conf.getCycles());
		double allSell = 0;
		double lallSell = 0;
		for (int i = cycle; i >= 0; i--) {
			String nxtDay = VeDate.getNextDay(today, "" + i);
			String lnxtDay = VeDate.getNextDay(ltoday, "" + i);
			Orders xx = new Orders();
			xx.setVegsid(id);
			xx.setStatus("完成");
			xx.setAddtime(nxtDay);
			List<Orders> xList = this.ordersService.getOrdersByCond(xx);
			for (Orders x : xList) {
				allSell += Double.parseDouble(x.getNum());
			}
			Orders yy = new Orders();
			yy.setVegsid(id);
			yy.setStatus("完成");
			yy.setAddtime(lnxtDay);
			List<Orders> yList = this.ordersService.getOrdersByCond(xx);
			for (Orders x : yList) {
				lallSell += Double.parseDouble(x.getNum());
			}
		}
		allSell = allSell / cycle;
		JSONArray allSellscount = new JSONArray();
		allSellscount.put(0);
		allSellscount.put(0);
		allSellscount.put(0);
		allSellscount.put(allSell);
		JSONObject json = new JSONObject();
		json.put("allSell", allSellscount.toString());
		json.put("sells", sellscount.toString());
		json.put("needs", needscount.toString());
		json.put("snum", snumscount.toString());
		json.put("vegsname", vegsname.toString().toString().replaceAll("\"", ""));
		json.put("cate", cate.toString().replaceAll("\"", ""));
		String memo = "";
		String url = "";
		StringBuffer buffer = new StringBuffer();
		buffer.append("<table class='table' >");
		buffer.append("<thead>");
		buffer.append("<tr>");
		buffer.append("<th class='text-center'>蔬菜名称</th>");
		buffer.append("<th class='text-center'>库存数量</th>");
		buffer.append("<th class='text-center'>最大库存数量</th>");
		buffer.append("<th class='text-center'>最小库存数量</th>");
		buffer.append("<th class='text-center'>进货周期</th>");
		buffer.append("<th class='text-center'>库存需求</th>");
		buffer.append("<th class='text-center'>采购建议</th>");
		buffer.append("<th class='text-center'>导出报表</th>");
		buffer.append("</tr>");
		buffer.append("</thead>");
		buffer.append("<tr align='center'>");
		buffer.append("<td>" + vegs.getVegsname() + "</td>");
		if (0 == snum) {
			buffer.append("<td><font color='red'>" + vegs.getSnum() + "</font></td>");
			buffer.append("<td>" + conf.getThemax() + "</td>");
			buffer.append("<td><font color='red'>" + conf.getThemin() + "</font></td>");
			buffer.append("<td>" + conf.getCycles() + "</td>");
			buffer.append("<td><font color='red'>" + conf.getThemin() + "</font></td>");
			memo += "蔬菜未进货 建议进货数量 " + conf.getThemin();
			String banner = "进货计划单";
			String s1 = "蔬菜名称,蔬菜类型,当前库存数,需要采购数,生成日期";
			String[] strTitle = s1.split(",");
			List<String[]> strList = new ArrayList<String[]>();
			String strTemp = vegs.getVegsname() + "," + vegs.getCatename() + "," + vegs.getSnum() + "," + conf.getThemin() + ","
					+ VeDate.getStringDate();
			String[] str = strTemp.split(",");
			strList.add(str);
			Excel excel = new Excel();
			String paths = this.getSession().getServletContext().getRealPath("/");
			url = excel.getExcel(strList, strTitle, banner, paths);
		} else {
			int cycles = Integer.parseInt(conf.getCycles());
			double need = (sell * cycles) * Double.parseDouble(conf.getParama()) + (lallSell * cycles) * Double.parseDouble(conf.getParamb());
			double buy = snum - need;
			if (buy < 0) {
				buffer.append("<td>" + vegs.getSnum() + "</td>");
				String banner = "进货计划单";
				String s1 = "蔬菜名称,蔬菜类型,当前库存数,需要采购数,生成日期";
				String[] strTitle = s1.split(",");
				List<String[]> strList = new ArrayList<String[]>();
				String strTemp = vegs.getVegsname() + "," + vegs.getCatename() + "," + vegs.getSnum() + "," + Math.abs(buy) + ","
						+ VeDate.getStringDate();
				String[] str = strTemp.split(",");
				strList.add(str);
				Excel excel = new Excel();
				String paths = this.getSession().getServletContext().getRealPath("/");
				url = excel.getExcel(strList, strTitle, banner, paths);
				memo += "蔬菜 " + vegs.getVegsname() + " 缺货 建议进货数量 " + Math.abs(buy);
				buffer.append("<td>" + conf.getThemax() + "</td>");
				buffer.append("<td>" + conf.getThemin() + "</td>");
				buffer.append("<td>" + conf.getCycles() + "</td>");
				buffer.append("<td><font color='red'>" + Math.abs(buy) + "</font></td>");
			}

		}
		buffer.append("<td><font color='red'>" + memo + "</font></td>");
		if ("".equals(memo)) {
			buffer.append("<td></td>");
		} else {
			buffer.append("<td><a href='" + url + "'><font color='green'>下载报表</font></a></td>");
		}
		buffer.append("</tr></table>");

		String html = buffer.toString();
		json.put("html", html.toString().toString().replaceAll("\"", ""));

		return json.toString();
	}

	@RequestMapping("print.action")
	public String print() {
		String banner = "进货计划单";
		String s1 = "蔬菜名称,蔬菜类型,当前库存数,需要采购数,生成日期";
		String[] strTitle = s1.split(",");
		List<String[]> strList = new ArrayList<String[]>();
		Conf conf = this.confService.getConfById("1");
		int cycle = Integer.parseInt(conf.getCycles());
		String today = VeDate.getStringDateShort();
		String ltoday = "" + (Integer.parseInt(today.substring(0, 3)) - 1) + today.substring(4);
		List<Vegs> list = this.vegsService.getAllVegs();

		String url = "";
		StringBuffer buffer = new StringBuffer();
		buffer.append("<table class='table' >");
		buffer.append("<thead>");
		buffer.append("<tr>");
		buffer.append("<th class='text-center'>蔬菜名称</th>");
		buffer.append("<th class='text-center'>库存数量</th>");
		buffer.append("<th class='text-center'>最大库存数量</th>");
		buffer.append("<th class='text-center'>最小库存数量</th>");
		buffer.append("<th class='text-center'>进货周期</th>");
		buffer.append("<th class='text-center'>库存需求</th>");
		buffer.append("<th class='text-center'>采购建议</th>");
		buffer.append("</tr>");
		buffer.append("</thead>");
		for (Vegs vegs : list) {
			String id = vegs.getVegsid();
			double snum = Double.parseDouble(vegs.getSnum());
			double allSell = 0;
			double lallSell = 0;
			for (int i = cycle; i >= 0; i--) {
				String nxtDay = VeDate.getNextDay(today, "" + i);
				String lnxtDay = VeDate.getNextDay(ltoday, "" + i);
				Orders xx = new Orders();
				xx.setVegsid(id);
				xx.setStatus("完成");
				xx.setAddtime(nxtDay);
				List<Orders> xList = this.ordersService.getOrdersByCond(xx);
				for (Orders x : xList) {
					allSell += Double.parseDouble(x.getNum());
				}
				Orders yy = new Orders();
				yy.setVegsid(id);
				yy.setStatus("完成");
				yy.setAddtime(lnxtDay);
				List<Orders> yList = this.ordersService.getOrdersByCond(xx);
				for (Orders x : yList) {
					lallSell += Double.parseDouble(x.getNum());
				}
			}
			allSell = allSell / cycle;
			Orders orders = new Orders();
			orders.setVegsid(id);
			orders.setStatus("完成");
			List<Orders> sellList = this.ordersService.getOrdersByCond(orders);
			double sell = 0;
			for (Orders x : sellList) {
				sell += Double.parseDouble(x.getNum());
			}
			String memo = "";
			if (0 == snum) {
				buffer.append("<tr align='center'>");
				buffer.append("<td>" + vegs.getVegsname() + "</td>");
				buffer.append("<td><font color='red'>" + vegs.getSnum() + "</font></td>");
				buffer.append("<td>" + conf.getThemax() + "</td>");
				buffer.append("<td><font color='red'>" + conf.getThemin() + "</font></td>");
				buffer.append("<td>" + conf.getCycles() + "</td>");
				buffer.append("<td><font color='red'>" + conf.getThemin() + "</font></td>");
				memo = "蔬菜未进货 建议进货数量 " + conf.getThemin();
				buffer.append("<td><font color='red'>" + memo + "</font></td>");
				buffer.append("</tr>");
				String strTemp = vegs.getVegsname() + "," + vegs.getCatename() + "," + vegs.getSnum() + "," + conf.getThemin() + ","
						+ VeDate.getStringDate();
				String[] str = strTemp.split(",");
				strList.add(str);
			} else {
				int cycles = Integer.parseInt(conf.getCycles());
				double need = (sell * cycles) * Double.parseDouble(conf.getParama())
						+ (lallSell * cycles) * Double.parseDouble(conf.getParamb());
				double buy = snum - need;
				double low = snum - sell * cycles;
				if (Math.abs(buy) > Math.abs(low)) {
					if (need != 0) {
						if (buy < 0) {
							String strTemp = vegs.getVegsname() + "," + vegs.getCatename() + "," + vegs.getSnum() + "," + Math.abs(buy)
									+ "," + VeDate.getStringDate();
							String[] str = strTemp.split(",");
							strList.add(str);
							memo = "蔬菜 " + vegs.getVegsname() + " 缺货 建议进货数量 " + Math.abs(buy);
							buffer.append("<tr align='center'>");
							buffer.append("<td>" + vegs.getVegsname() + "</td>");
							buffer.append("<td>" + vegs.getSnum() + "</td>");
							buffer.append("<td>" + sell * (cycles + 1) + "</td>");
							buffer.append("<td>" + sell * cycles + "</td>");
							buffer.append("<td>" + conf.getCycles() + "</td>");
							buffer.append("<td><font color='red'>" + Math.abs(buy) + "</font></td>");
							buffer.append("<td><font color='red'>" + memo + "</font></td>");
							buffer.append("</tr>");
						}
					}
				} else {
					if (low < 0) {
						String strTemp = vegs.getVegsname() + "," + vegs.getCatename() + "," + vegs.getSnum() + "," + Math.abs(buy) + ","
								+ VeDate.getStringDate();
						String[] str = strTemp.split(",");
						strList.add(str);
						memo = "蔬菜 " + vegs.getVegsname() + " 缺货 建议进货数量 " + Math.abs(low);
						buffer.append("<tr align='center'>");
						buffer.append("<td>" + vegs.getVegsname() + "</td>");
						buffer.append("<td>" + vegs.getSnum() + "</td>");
						buffer.append("<td>" + sell * (cycles + 1) + "</td>");
						buffer.append("<td><font color='red'>" + sell * cycles + "</font></td>");
						buffer.append("<td>" + conf.getCycles() + "</td>");
						buffer.append("<td><font color='red'>" + Math.abs(buy) + "</font></td>");
						buffer.append("<td><font color='red'>" + memo + "</font></td>");
						buffer.append("</tr>");
					}
				}
			}
		}
		buffer.append("</table>");
		String html = buffer.toString();
		Excel excel = new Excel();
		String paths = this.getSession().getServletContext().getRealPath("/");
		url = excel.getExcel(strList, strTitle, banner, paths);
		this.getRequest().setAttribute("html", html);
		this.getRequest().setAttribute("url", url);
		return "print";
	}

}
