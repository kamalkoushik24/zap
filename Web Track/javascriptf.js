function hello()
{
	let name = document.querySelector('#name').value;
	if (name === '')
	{
		name = unknown;
	}
    alert('Hello ' + name + '!')
}

function intro()
{
	let iname = document.querySelector('#name').value;
	if (iname === '')
	{
		iname = unknown;
	}
    document.querySelector('#iname').innerHTML = 'Hello, ' + iname + ' ! You are presently on my website which is basically an intro of me.' ;
 }

 function pgintro()
 {
 	alert("Hello this is the description of my Life")
 }