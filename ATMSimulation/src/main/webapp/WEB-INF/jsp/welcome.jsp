<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Access the bootstrap Css like this,
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="..${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
	<link rel="stylesheet" href="..${pageContext.request.contextPath}/webjars/font-awesome/4.6.2/css/font-awesome.min.css"></link>

    <link rel="stylesheet" type="text/css" href="..${pageContext.request.contextPath}/css/main.css" />
    
</head>
<body>
  <form:form id="testForm" modelAttribute="atm" method="post" action="transfer.html">
	<div class="container">
	 <div class="page-header">
        <h1>${applicationName}</h1>
      </div>
       <spring:bind path="*">
	   	<c:if test="${not empty status.errorMessages}">
			<div class="col-md-offset-2 panel-error2"><form:errors path="*" element="div"/></div>
		</c:if>
	   </spring:bind>
      <div class="row">
        <div class="col-sm-8 col-md-offset-2">
        <div class="panel panel-primary">
            <div class="panel-heading">
              <h3 class="panel-title">Bank Balance</h3>
            </div>
            <div class="panel-body">
                  <div class="col-md-12">
          <table class="table table-striped">
            <thead>
              <tr>
                <th></th>
                <th>TYPE</th>
                <th>NUMBER</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1</td>
                <td>50</td>
                <td>${atm.current50Note}</td>
              </tr>
              <tr>
                <td>2</td>
                <td>20</td>
                <td>${atm.current20Note}</td>
              </tr>
            </tbody>
          </table>
        </div>
            </div>
          </div>
        </div>
       </div>
        
       <div class="row">
        <div class="col-sm-8 col-md-offset-2">
        <div class="panel panel-primary">
            <div class="panel-heading">
              <h3 class="panel-title">User Balance</h3>
            </div>
            <div class="panel-body">
                                <div class="col-md-12">
          <table class="table table-striped">
            <thead>
              <tr>
                <th></th>
                <th>TYPE</th>
                <th>NUMBER</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1</td>
                <td>50</td>
                <td>${atm.user50Note}</td>
              </tr>
              <tr>
                <td>2</td>
                <td>20</td>
                <td>${atm.user20Note}</td>
              </tr>
            </tbody>
          </table>
          	<div class="row well">
          	 <div class="col-md-12">
               <div class="col-sm-2">Request : </div><div class="col-sm-10" id="number" ></div>
               </div>
        	</div>
            </div>
          </div>
        </div>
       </div>
         <div class="row">
        <div class="col-sm-8 col-md-offset-3">
        <p>
			<button id="number1" type="button" class="btn btn-lg btn-default">1</button> 
			<button id="number2" type="button" class="btn btn-lg btn-default">2</button> 
			<button id="number3" type="button" class="btn btn-lg btn-default">3</button>
			<button id="transfer" type="button" class="btn btn-lg btn-success">transfer</button>
        </p>
        </div>
       </div>
       <div class="row">
        <div class="col-sm-8 col-md-offset-3">
        <p>
			<button id="number4" type="button" class="btn btn-lg btn-default">4</button> 
			<button id="number5" type="button" class="btn btn-lg btn-default">5</button> 
			<button id="number6" type="button" class="btn btn-lg btn-default">6</button>
			<button id="clear" type="button" class="btn btn-lg btn-danger">clear</button>
        </p>
        </div>
       </div>
        <div class="row">
        <div class="col-sm-8 col-md-offset-3">
        <p>
			<button id="number7" type="button" class="btn btn-lg btn-default">7</button> 
			<button id="number8" type="button" class="btn btn-lg btn-default">8</button> 
			<button id="number9" type="button" class="btn btn-lg btn-default">9</button>
		    <button id="initialize" type="button" class="btn btn-lg btn-info">initialize</button>
        </p>
        </div>
          <div class="row">
        <div class="col-sm-6 col-md-offset-2 leftlayout">
		    <button id="number0" type="button" class="btn btn-lg btn-default">0</button>
        </div>
       </div>
        <input type="hidden" id="numbers" name="numbers" value=""/>
        <input type="hidden" id="current20Note" name="current20Note" value=""/>
        <input type="hidden" id="current50Note" name="current50Note" value=""/>
        <input type="hidden" id="user20Note" name="user20Note" value=""/>
        <input type="hidden" id="user50Note" name="user50Note" value=""/>
 </div>
 </div>
 </form:form>
 
	<script type="text/javascript" src="..${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="..${pageContext.request.contextPath}/webjars/jquery/2.2.3/jquery.min.js"></script>
    <script type="text/javascript" src="..${pageContext.request.contextPath}/js/main.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	  $("#number1").width(100);
	  $("#number2").width(100);
	  $("#number3").width(100);
	  $("#number4").width(100);
	  $("#number5").width(100);
	  $("#number6").width(100);
	  $("#number7").width(100);
	  $("#number8").width(100);
	  $("#number9").width(100);
	  $("#number0").width(100);
	  $("#transfer").width(100);
	  $("#clear").width(100);
	  $("#initialize").width(100);
	
	 $("#number").text('${atm.userBalance}');
	 
	 $("#current20Note").val('${atm.current20Note}');
	 $("#current50Note").val('${atm.current50Note}');
	 $("#user20Note").val('${atm.user20Note}');
	 $("#user50Note").val('${atm.user50Note}');
	
	$("#number1").click(function(){
		numberClick("1");
    }); 
	
	$("#number2").click(function(){
		numberClick("2");
    }); 
	
	$("#number3").click(function(){
		numberClick("3");
    }); 
	
	$("#number4").click(function(){
		numberClick("4");
    }); 
	
	$("#number5").click(function(){
		numberClick("5");
    }); 
	
	$("#number6").click(function(){
		numberClick("6");
    }); 
	
	$("#number7").click(function(){
		numberClick("7");
    }); 
	
	$("#number8").click(function(){
		numberClick("8");
    }); 
	
	$("#number9").click(function(){
		numberClick("9");
    }); 
	
	$("#number0").click(function(){
		numberClick("0");
    }); 
	
	
	$("#transfer").click(function(){
		transfer();
    });
	
	$("#initialize").click(function(){
		initialize();
    });
	
	$("#clear").click(function(){
		clear();
    });
});

function numberClick(num){
	if ($("#number").text()) {
		var x = $("#number").text();
		if(parseInt(x) == 0) x = '';
		x = x + String(num);
		$("#number").text(x);
		convertToCurrency($("#number").text());
    }else{
	$("#number").text(String(num));
    }
}

function convertToCurrency(currencyText){
	currencyText = String(currencyText).replace(new RegExp(',', 'g'), '');
	var currencyReg = "(\\d)(?=(\\d{3})+(?!\\d))";
	currencyText = currencyText.toString().replace(new RegExp(currencyReg, 'g'), "$1,");
	$("#number").text(currencyText);
}

function transfer(){
	document.forms[0].elements["numbers"].value  = $("#number").text();
	document.forms[0].action = "transfer.html";
	document.forms[0].submit();
}

function initialize(){
	window.location.replace("${pageContext.request.contextPath}/initialize.html");
}

function clear(){
	$("#number").text("");
}
</script>
</body>

</html>