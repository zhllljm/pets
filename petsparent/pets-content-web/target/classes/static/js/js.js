

function guangbiao()
{
	document.getElementById("uname").focus();
	var input = document.getElementById( "uname" );

	var val = input.value; //将光标的值位置给val

	input.value = "";//将光标的值设置为空

	input.value = val;


}
function getA()
{
	var sname=document.getElementById("sname").value;
	var sremark=document.getElementById("sremark").value;
	if(sname.length==0)
	{
		alert("对不起类别不能为空！")
		return false;
	}
	else if(sremark.length==0)
	{
		alert("对不起备注不能为空！")
		return  false;
	}
}
function a()
{
	document.getElementById("sname").focus();
	var input = document.getElementById( "sname" );

	var val = input.value; //将光标的值位置给val

	input.value = "";//将光标的值设置为空

	input.value = val;
}

function getB()
{
	var fname=document.getElementById("fname").value;
	var fauto=document.getElementById("fauto").value;
	var time=document.getElementById("time").value;
	var fremark=document.getElementById("fremark").value;
	if(fname.length==0)
	{
		alert("对不起电影名称不能为空！")
		return false;
	}
	else if(fauto.length==0)
	{
		alert("对不起主演不能为空！")
		return false;
	}
	else if(time.length==0)
	{
		alert("对不起上映时间不能为空！")
		return false;
	}
	else if(fremark.length==0)
	{
		alert("对不起简介不能为空！")
		return false;
	}
}
function b()
{
	document.getElementById("fname").focus();
	var input = document.getElementById( "fname" );

	var val = input.value; //将光标的值位置给val

	input.value = "";//将光标的值设置为空

	input.value = val;
}

function getC()
{
	var tname=document.getElementById("tname").value;
	var tcount=document.getElementById("tcount").value;

	var atcount=/^[0-9]*$/;
	var m=atcount.test(tcount);

	if(tname.length==0)
	{
		alert("对不起大厅名称不能为空！")
		return false;
	}
	else if(tcount.length==0)
	{
		alert("对不起座位数量不能为空！")
		return false;
	}
	else if(!m)
	{
		alert("对不起座位数只能填写整数！")
		document.getElementById("tcount").value='';
		document.getElementById("tcount").focus();
		var input = document.getElementById( "tcount" );

		var val = input.value; //将光标的值位置给val

		input.value = "";//将光标的值设置为空

		input.value = val;
		return false;
	}

}
function c()
{
	document.getElementById("tname").focus();
	var input = document.getElementById( "tname" );

	var val = input.value; //将光标的值位置给val

	input.value = "";//将光标的值设置为空

	input.value = val;
}
function getD()
{
	var ename=document.getElementById("ename").value;
	var egw=document.getElementById("egw").value;
	if(ename.length==0)
	{
		alert("对不起员工姓名不能为空！")	
		return false;
	}
	else if(egw.length==0)
	{
		alert("对不起员工岗位不能为空！")	
		return false;
	}
}
function d()
{
	document.getElementById("ename").focus();
	var input = document.getElementById( "ename" );

	var val = input.value; //将光标的值位置给val

	input.value = "";//将光标的值设置为空

	input.value = val;
}
function getE()
{
	var begintime=document.getElementById("begintime").value;
	var endtime=document.getElementById("endtime").value;
	var xmoney=document.getElementById("xmoney").value;

	var axmoney=/^[0-9]+\.{0,1}[0-9]{0,50}$/;
	var x=axmoney.test(xmoney);

	if(begintime.length==0)
	{
		alert("对不起开始时间不能为空！")
		return false;
	}
	else if(endtime.length==0)
	{
		alert("对不起结束时间不能为空！")
		return false;
	}
	else if(xmoney.length==0)
	{
		alert("对不起票价不能为空！")
		return false;
	}
	else if(!x)
	{
		alert("对不起票价只能填写数字！")

		document.getElementById("xmoney").value='';
		document.getElementById("xmoney").focus();
		var input = document.getElementById( "xmoney" );

		var val = input.value; //将光标的值位置给val

		input.value = "";//将光标的值设置为空

		input.value = val;
		return false;
	}


}
/*function e()
{
	document.getElementById("begintime").focus();
	var input = document.getElementById( "begintime" );

	var val = input.value; 将光标的值位置给val
	input.value = "";将光标的值设置为空
	input.value = val;
}*/

function getF()
{
	var seat=document.getElementById("seat").value;
	if(seat.length==0)
	{
		alert("对不起座位不能为空！")
		return false;
	}
}
function getG()
{
	var cbs = document.getElementsByName("seat");
	var checkNum = 0;
	for (var i = 0; i < cbs.length; i++) 
	{
		if (cbs[i].checked) 
		{
			checkNum++;
		}
	}

	if (checkNum == 0) 
	{
		alert("请至少选中一个座位");
		return false;
	}
}