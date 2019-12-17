document.getElementById("download").onclick=download;
document.getElementById("delete").onclick=delete1;
function download()
{
	location="/file/"+name;
}
function delete1()
{
	var xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function()
	{
		if(this.readyState==4&&this.status==200)
		{
			location="/";
		}
		else if(this.readyState==4)
		{
			console.log(this.responseText);
			alert("Hata");
		}
	};
	xhr.open("DELETE","/api/file/"+id,true);
	xhr.send();
}