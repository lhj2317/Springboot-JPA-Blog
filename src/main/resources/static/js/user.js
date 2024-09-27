let index={
	init: function(){
		$("#btn-save").on("click",()=>{  //function()대신 ()>{}를 사용한 이유는 this를 바인딩하기 위해서!!!
			this.save();
		});
		$("#btn-login").on("click",()=>{  //function()대신 ()>{}를 사용한 이유는 this를 바인딩하기 위해서!!!
			this.login();
		});
	},
	
	save : function(){
		//alert("user의 save함수 호출됨");
		let data = {
			username:$("#username").val(),
			password:$("#password").val(),
			email: $("#email").val()
		};
		
		//console.log(data);
		
		// ajax 호출시 default가 비동기 호출
		// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
		// ajax가 통신을 성공공하고 서버가 json을 리턴해주면 자동으로 자바오브젝트로 변환해주네요.
		$.ajax({ 	// 회원가입수행 요청
			type: "POST",
			url: "/blog/api/user",
			data: JSON.stringify(data),  //http body 데이터
			contentType: "application/json; charset=utf-8",   // body데이터가 어떤 타입인지 (MIME)
			dataType: "json"  // 요청을 서버로 해서 응답이 왔을때 기본적으로 모든것이 문자열(생긴게 josn이라면 ) => javascript 오브젝트로 변경
		}).done(function(resp){ 			// 정상이면 실행
			alert("회원가입이 완료되었습니다.");
			//console.log(resp);
			location.href ="/blog";
		}).fail(function(error){ 			// 실패면 실행
			alert(JSON.stringify(error));
		}); 
		
	},
	
	login : function(){
		//alert("user의 save함수 호출됨");
		let data = {
			username:$("#username").val(),
			password:$("#password").val() 
		};
		
		//console.log(data);
		
		// ajax 호출시 default가 비동기 호출
		// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
		// ajax가 통신을 성공공하고 서버가 json을 리턴해주면 자동으로 자바오브젝트로 변환해주네요.
		$.ajax({ 	// 
			type: "POST",
			url: "/blog/api/user/login",
			data: JSON.stringify(data),  //http body 데이터
			contentType: "application/json; charset=utf-8",   // body데이터가 어떤 타입인지 (MIME)
			dataType: "json"  // 요청을 서버로 해서 응답이 왔을때 기본적으로 모든것이 문자열(생긴게 josn이라면 ) => javascript 오브젝트로 변경
		}).done(function(resp){ 			// 정상이면 실행
			alert("로그인이 완료되었습니다."); 
			location.href ="/blog";
		}).fail(function(error){ 			// 실패면 실행
			alert(JSON.stringify(error));
		}); 
		
	}
}

index.init();