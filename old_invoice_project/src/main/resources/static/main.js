<script type="text/javascript">
function addRows(){
	var table = document.getElementById('invoicetbl');
	var rowCount = table.rows.length;
	var cellCount = table.rows[0].cells.length;
	var row = table.insertRow(rowCount);
	for(var i =0; i < cellCount; i++){
		var cell = 'cell'+i;
		cell = row.insertCell(i);
		var copycel = document.getElementById('col'+i).innerHTML;
		cell.innerHTML=copycel;

	}
}
function deleteRows(){
	var table = document.getElementById('invoicetbl');
	var rowCount = table.rows.length;
	if(rowCount > '1'){
		var row = table.deleteRow(rowCount-1);
		rowCount--;
	}
	else{
		alert('There should be at least one row');
	}
}
</script>