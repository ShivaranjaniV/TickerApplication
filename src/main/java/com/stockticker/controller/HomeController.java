package com.stockticker.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import com.stockticker.model.CompanyNames;
import com.stockticker.model.StockData;
@RequestMapping("/rest")
@Controller
@Api(value="Home Controller")
//@PropertySource(value = "classpath:properties/stockerticker.properties")
public class HomeController {
	
/*	@Autowired
	SmartLightServiceImpl smartLightService;
*/	

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@ApiOperation(value = "Hello Stock Ticker Home",      
			notes="Its a dummy service",
			response=String.class,
			httpMethod="GET")
@RequestMapping(value = "/HelloService", method = RequestMethod.GET)
@ResponseBody
public Boolean consumeSmartBin() {
	logger.info("executing Consumer smart Bin");
	
	return true;
	
}
	@ApiOperation(value = "Gives Stock Details",      
			notes="Pass the country names whose stock details have to be searched",
			response=Object.class,
			httpMethod="POST")
	@RequestMapping(value = "/getStockDetail", method = RequestMethod.POST, consumes = "application/json", produces= "application/json")
	@ResponseBody
	
public Object getDetail(@RequestBody CompanyNames names) {
	logger.info("executing getStockDetail service");
	ArrayList<StockData> details = new ArrayList<StockData>();
	try{
	File file = new File("C:/Users/sgupta3/Desktop/stockerticker.properties");
	//	File file = new File("stockerticker.properties");
	FileInputStream fileInput = new FileInputStream(file);
	Properties properties = new Properties();
	properties.load(fileInput);
	
	
	
	
		for(String country: names.getCompanyList()){
			StockData ob = new StockData();
			
			Stock stock = YahooFinance.get(properties.getProperty(country));
			BigDecimal price = stock.getQuote().getPrice();
			//System.out.println(price);
			BigDecimal change = stock.getQuote().getChangeInPercent();
			//System.out.println(change);
			BigDecimal peg = stock.getStats().getPeg();
			BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
			
			logger.info("Exception at getStockDetail service executingnnnn");
			ob.setCompanyName(country);
			ob.setPrice(price.doubleValue());
			ob.setChange(change.doubleValue());
			boolean isProfit = change.doubleValue()<0?false:true;
			ob.setProfit(isProfit);
			details.add(ob);
			
		}
	
	
	}
	catch(Exception e){
		e.printStackTrace();
		logger.info("Exception at getStockDetail service ");
	}
	return details;
	
}

}
