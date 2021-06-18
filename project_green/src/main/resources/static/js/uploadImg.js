function showUploadedImages(arr){
	console.log(arr);
	
	var divArea = document.querySelector(".uploadResult");
	divArea.innerHTML = "";
	for(var i = 0; i<arr.length; i++){
		divArea.innerHTML += '<img src="/board/display?fileName=' + arr[i].imageURL + '"/>';
	}
}

document.querySelector(".uploadBtn").onclick = function(){
	var formData = new FormData();
	var files = document.querySelector("#uploadFiles").files;
	console.log(files);
	if (files.length == 0) {
		document.createBoard.submit();
		return false;
	}
	for(var i = 0; i<files.length; i++){
		console.log(files[i]);
		formData.append("uploadFiles", files[i]);
	}
	
	//실제 업로드 부분
	axios({
      method: "post",
      contentType: false,
      url: "/board/uploadAxios",
      data: formData,
    })
	.then(function(response){
//		showUploadedImages(response.data);
		//console.log(response)
		document.getElementById("imageUrl").value = response.data[0].imageURL;
		document.createBoard.submit();
	})
	.catch(function(){
		alert("실패");
	})
};