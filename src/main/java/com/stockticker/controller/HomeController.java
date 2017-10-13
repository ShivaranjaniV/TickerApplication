package com.stockticker.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Properties;
@RequestMapping("/rest")
@Controller
@Api(value="Home Controller")
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
}


