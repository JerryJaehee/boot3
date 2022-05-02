/**
 * 
 */
 
 function summernoteInit(selector, code) {
	 //summernote
	 	$("#"+selector).summernote({
 		height : 400,
 		placeholder: '내용을 입력하세요',
 		callbacks: {
 			onImageUpload:function(files) {
				//files 업로드한 이미지 파일 객체
				let formData = new FormData();
				formData.append("file", files[0]);
				
				// /board/summerFileUpload
				$.ajax({
					type:"POST",
					url:"./summerFileUpload",
					processData:false,
					contentType:false,
					data:formData,
					success:function(data) {
						$(".note-image-input").val('');
						$("#"+selector).summernote('editor.insertImage', data.trim());					
					},
					error:function() {
						alert("에러 발생");
					}
				});
				
 			}, //onImageUpload 끝
 			onMediaDelete:function(files) {
 				let fileName = $(files[0]).attr("src");
 				console.log("fileName : "+fileName);
 				$.ajax({
 					type:"GET",
 					url:"./summerFileDelete",
 					data: {
 						fileName:fileName
 					},
 					success:function(data) {
 						console.log(data.trim());
 					}
 				});
 			}// onMediaDelete 끄읕
 		}
 	});
	 
	 $("#"+selector).summernote ('code', code)	
}
 
 