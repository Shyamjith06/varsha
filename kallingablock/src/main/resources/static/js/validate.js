function call(){
	alert("inserted");
	fetch('getdishes',{
		method: 'GET',
		headers:{
			'Content-Type':'application/json'
		}
	}).then((response) =>{
		response.json().then((x) =>{
			let loop = document.getElementById('kallingaBlock');
			console.log(x);
			let kallingaShopName = "";
		x.forEach((i) => {
		if(i.kallingaBlock.kallingaBlockName == (document.getElementById('kallingaBlock').value)){
			kallingaShopName+='<option value = "'+i.kallingaShopName+'">'+ i.kallingaShopName +'</option>'
		}
	});
	document.getElementById('ShopName').innerHTML = kallingaShopName;
	}
	 );
	 }).catch((err)=>{
		 });
}