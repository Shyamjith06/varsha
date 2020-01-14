function validate()
{
var letters=/^[a-zA-Z]+$/;
	var name=document.getElementById("userName").value;
	if((!name.match(letters)||name.match(" ")))
		{
		alert("please enter a valid Name");
		return false;
		}
	
	
	var balance=document.getElementById("openingBalance").value;
	if(balance<=0)
		{
		alert("Balance Should be more than zero");
		return false;
		}
	return true;
}