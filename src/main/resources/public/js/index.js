(function (window) {
  var WMP = window.WMP || {};
  WMP.index = WMP.index || {};

  $(document).ready(function () {
    console.log("event ready");
	$("#printBtn").on("click", function () {
	  WMP.index.getResult();
	});
  });
  
  /**
   * get result data from remote
   */
  WMP.index.getResult = function getResult() {
	var data = $("#frm").serialize();
    $.ajax({ 
      processData: false,
      data: data,
      type: "GET",
      url: "/string", 
      success: function (response, textStatus, jqXHR) { 
        if(response) {
          response.quotient ? WMP.index.setQuotient(response.quotient) : WMP.index.setQuotient(0);
          response.remainder ? WMP.index.setRemainder(response.remainder) : WMP.index.setRemainder(0);
    	}
      },
      error: function (xhr, textStatus, errorThrown) {
    	console.log(xhr.responseText);
      }
    });
    return false; 
  };

  WMP.index.setQuotient = function getResult(data) {
	$("#quotient").text(data);
  }

  WMP.index.setRemainder = function getResult(data) {
	$("#remainder").text(data);
  }
  
  window.WMP = window.WMP || WMP;
})
(window);
