function KobisOpenAPIRestService(key,host){
	this.key = key;
	this.host = host? host:"http://www.kobis.or.kr";
	this.DAILY_BOXOFFICE_URI = "/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList";
	this.WEEKLY_BOXOFFICE_URI = "/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList";	
	this.COM_CODE_LIST_URI = "/kobisopenapi/webservice/rest/code/searchCodeList";
	this.MOVIE_LIST_URI = "/kobisopenapi/webservice/rest/movie/searchMovieList";
	this.MOVIE_INFO_URI = "/kobisopenapi/webservice/rest/movie/searchMovieInfo";
	this.COMPANY_LIST_URI = "/kobisopenapi/webservice/rest/company/searchCompanyList";
	this.COMPANY_INFO_URI = "/kobisopenapi/webservice/rest/company/searchCompanyInfo";
	this.PEOPLE_LIST_URI = "/kobisopenapi/webservice/rest/people/searchPeopleList";
	this.PEOPLE_INFO_URI = "/kobisopenapi/webservice/rest/people/searchPeopleInfo";
	this.CODE_LIST_URI = "/kobisopenapi/webservice/rest/code/searchCodeList";
}

function KobisOpenAPIError(message) {
	this.message = message;
}

KobisOpenAPIError.prototype = new Error;

KobisOpenAPIRestService.prototype.requestGet =  function(key, host, serviceURI, isJson, paramMap){
	var urlStr = host + serviceURI + (isJson?'.json?':'.xml?')
	
	var retVal = null;
	
	// $.extend(paramMap,{key:this.key});
	
	$.ajax({
		type: "get",
		url : urlStr,
		data : {
			"key" : key
		},
		success : function(responseData){
			retVal = responseData;
		},
		error : function(jqXHR, textStatus, err){
			throw new KobisOpenAPIError(jqXHR.responseText);
		},
		dataType: isJson?"json":"xml",
		async : false
	}); 
	
	return retVal;
};

KobisOpenAPIRestService.prototype.getList = function(key, host, serviceURI, isJson, movieNm, resultMax, curPage){
	var urlStr = host + serviceURI + (isJson?'.json?':'.xml?');
	var retVal = null;

	$.ajax({
		type : "Get",
		url : urlStr,
		data : {
			"key" : key,
			"movieNm" : movieNm,
			"itemPerPage" : resultMax,
			"curPage" : curPage
		},
		success : function(data){
			retVal = data;
		},
		error : function(jqXHR, textStatus, err){
			throw new KobisOpenAPIError(jqXHR.responseText);
		},
		dataType: isJson?"json":"xml",
		async : false
	});
	
	return retVal;
}

KobisOpenAPIRestService.prototype.getInfo = function(key, host, serviceURI, isJson, movieCd){
	var urlStr = host + serviceURI + (isJson?'.json?':'.xml?');
	var retVal = null;
	
	$.ajax({
		type : "GET",
		url : urlStr,
		data : {
			"key" : key,
			"movieCd" : movieCd,
		},
		success : function(data){
			retVal = data;
		},
		fail : function(jqXHR, textStatus, err){
			throw new KobisOpenAPIError(jqXHR.responseText);
		},
		dataType : isJson?"json":"xml",
		async : false
	})
	return retVal;
}

KobisOpenAPIRestService.prototype.getRank = function(key, host, serviceURI, isJson, day, resultMax){
	var urlStr = host + serviceURI + (isJson?'.json?':'.xml?');
	
	var retVal = null;
	
	$.ajax({
		type : "Get",
		url : urlStr,
		data : {
			"key" : key,
			"targetDt" : day,
			"itemPerPage" : resultMax
		},
		success : function(data){
			retVal = data;
		},
		error : function(jqXHR, textStatus, err){
			throw new KobisOpenAPIError(jqXHR.responseText);
		},
		dataType: isJson?"json":"xml",
		async : false
	});
	
	return retVal;
}

KobisOpenAPIRestService.prototype.getCode = function(key, host, serviceURI, isJson, comCd){
	var urlStr = host + serviceURI + (isJson?'.json?':'.xml?');
	console.log("Asdfasfd")
	var retVal = null;
	
	$.ajax({
		type : "Get",
		url : urlStr,
		data : {
			"key" : key,
			"comCode" : comCd
		},
		success : function(data){
			retVal = data;
		},
		error : function(jqXHR, textStatus, err){
			throw new KobisOpenAPIError(jqXHR.responseText);
		},
		dataType: isJson?"json":"xml",
		async : false
	});
	
	return retVal;
}

KobisOpenAPIRestService.prototype.getDailyBoxOffice = function(isJson, day, resultMax){
	return this.getRank(this.key, this.host, this.DAILY_BOXOFFICE_URI, isJson, day, resultMax);
};

KobisOpenAPIRestService.prototype.getWeeklyBoxOffice = function(isJson, day, resultMax){
	return this.getRank(this.key, this.host, this.WEEKLY_BOXOFFICE_URI, isJson, day, resultMax);
};

KobisOpenAPIRestService.prototype.getComCodeList = function(isJson, paramMap){
	return this.requestGet(this.key, this.host, this.COM_CODE_LIST_URI, isJson, paramMap);
};

KobisOpenAPIRestService.prototype.getMovieList = function(isJson, movieNm, resultMax, curPage){
	return this.getList(this.key, this.host, this.MOVIE_LIST_URI, isJson, movieNm, resultMax, curPage);
};

KobisOpenAPIRestService.prototype.getMovieInfo = function(isJson, movieCd){
	return this.getInfo(this.key, this.host, this.MOVIE_INFO_URI, isJson, movieCd);
};

KobisOpenAPIRestService.prototype.getCompanyList = function(isJson, paramMap){
	return this.requestGet(this.key, this.host, this.COMPANY_LIST_URI, isJson, paramMap);
};

KobisOpenAPIRestService.prototype.getCompnayInfo = function(isJson, paramMap){
	return this.requestGet(this.key, this.host, this.COMPANY_INFO_URI, isJson, paramMap);
};

KobisOpenAPIRestService.prototype.getPeopleList = function(isJson, paramMap){
	return this.requestGet(this.key, this.host, this.PEOPLE_LIST_URI, isJson, paramMap);
};

KobisOpenAPIRestService.prototype.getPeopleInfo = function(isJson, paramMap){
	return this.requestGet(this.key, this.host, this.PEOPLE_INFO_URI, isJson, paramMap);
};

KobisOpenAPIRestService.prototype.getCodeList = function(isJson, comCd){
	return this.getCode(this.key, this.host, this.CODE_LIST_URI, isJson, comCd)
}