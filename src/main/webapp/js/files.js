document.getElementById("upload").onclick=upload;
function upload()
{
	var input=document.createElement("input");
	input.type="file";
	input.onchange=function()
	{
		var file=input.files[0];
		var formData=new FormData();
		formData.append("file",file);
		var xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function()
		{
			if(this.readyState==4&&this.status==200)
			{
				var json2=JSON.parse(this.responseText);
				var xhr2=new XMLHttpRequest();
				var data={file:json2.filename};
				xhr2.onreadystatechange=function()
				{
					if(this.readyState==4&&this.status==200)
					{
						var json=JSON.parse(this.responseText);
						var html="<tr onclick='onFileSelected("+json.filename+")'>";
						html+="<td>"+json.file+"</td>";
						html+="</tr>";
						document.getElementById("files").innerHTML+=html;
					}
					else if(this.readyState==4)
					{
						console.log(this.responseText);
						alert("Hata");
					}
				};
				xhr2.open("POST","/api/file",true);
				xhr2.setRequestHeader("Content-Type","application/json");
				xhr2.send(JSON.stringify(data));
			}
			else if(this.readyState==4)
			{
				alert("Hata");
			}
		};
		xhr.open("POST","/Upload",true);
		xhr.send(formData);
	};
	input.click();
}
function onFileSelected(id)
{
	location="/File/"+id;
}