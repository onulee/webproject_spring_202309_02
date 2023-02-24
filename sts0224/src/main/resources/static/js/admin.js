/**
 * 
 */
 var chartObj;
    function chartBtn(){
	    var monthData=[];
	    var saleData=[];
	    var labelData;
	    var changeYear = $(".changeYear").val();
    	//---------------------------------------------------
    	//  데이터 가져오기
    	$.ajax({
    		type:"post",
    		url:"total_sale_chart.do",
    		data:{"changeYear":changeYear},
    		dataType:"json",
    		success:function(data){
    			alert("성공");
    			console.log(data);
    			//chart그래프 초기화 
    			$("#myChart").remove(); //canvas를 삭제
    			$('#div_chart').append('<canvas id="myChart"><canvas>'); //다시 추가
    			
    			labelData = '[ '+data.syear+' 년 월매출 현황 ]';
    			
    			monthData = data.monthData;
    			saleData = data.saleData;
    			
    			//---------------------------------------------------
    	    	//alert("차트그리기 시작");
    			
    	    	let ctx = document.getElementById('myChart');

    	    	
    	    	new Chart(ctx, {
    	    	    type: 'line',
    	    	    data: {
    	    	      labels: monthData,
    	    	      datasets: [{
    	    	        label: labelData,
    	    	        data: saleData,
    	    	        backgroundColor: [
    	    	            'rgba(255, 99, 132, 0.2)',
    	    	            'rgba(255, 159, 64, 0.2)',
    	    	            'rgba(255, 205, 86, 0.2)',
    	    	            'rgba(75, 192, 192, 0.2)',
    	    	            'rgba(54, 162, 235, 0.2)',
    	    	            'rgba(153, 102, 255, 0.2)'
    	    	        ],
    	    	        borderColor: [
    	   	              'rgb(255, 99, 132)',
    	   	              'rgb(255, 159, 64)',
    	   	              'rgb(255, 205, 86)',
    	   	              'rgb(75, 192, 192)',
    	   	              'rgb(54, 162, 235)',
    	   	              'rgb(153, 102, 255)'
    	   	            ],  
    	    	        borderWidth: 1
    	    	      }]
    	    	    },
    	    	    options: {
    	    	      scales: {
    	    	        y: {
    	    	          beginAtZero: true
    	    	        }
    	    	      }
    	    	    }//options
    	    	  });
    	    	  //-------------------------------------
    		},//success function
    		error:function(){
    			alert("실패");
    		}
    		
    	});//ajax
    	
    	
    	
    }//chartBtn