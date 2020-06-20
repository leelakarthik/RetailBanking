function random_function()
{
	var a=document.getElementById("state").value;
	if(a==="Andhrapradesh"){
		var arr=["Vijayawada","Guntur","Nellore","Vizag"];
	}
	else if(a==="Maharastra"){
		var arr=["Mumbai","Pune","Nagpur","Thane"];
	}
	else if(a==="Tamilnadu"){
		var arr=["Chennai","Salem","Coimbatore","Madurai"];
	}
	else if(a==="Karnataka"){
		var arr=["Bangalore","Mysore","Mangalore","Hubli"]
	}
	else{
		var arr=[]
	}

	var string="";

	for(i=0;i<arr.length;i++){
		string=string+"<option value="+arr[i]+">"+arr[i]+"</option>";
		console.log("string");
	}
	document.getElementById("city").innerHTML=string;
}
