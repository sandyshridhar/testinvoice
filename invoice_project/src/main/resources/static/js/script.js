


function mySave()
{

    var bill_to=document.getElementById("bill_to").value;

    var invoice_date=document.getElementById("invoice_date").value;
    var invoice=document.getElementById("invoice").value;
//    console.log(invoice);
    var due_date=document.getElementById("due_date").value;
    var status=document.getElementById("status").value;
    var attachment=document.getElementById("myfile").value;

    var table=document.getElementById("data_table");
    var table_len=(table.rows.length)-1;

    var FromDate = new Date(invoice_date);
    var ToDate = new Date(due_date);



    if(bill_to.trim() ==""||bill_to.trim()==null)
    {
        alert("Bill To must be filled out");
        return false;
    }
    else if(invoice.trim() ==""||invoice.trim()==null)
    {
        alert("invoice must be filled out");
        return false;
    }else if(due_date.trim() ==""||due_date.trim()==null)
    {
        alert("due_date must be filled out");
        return false;
    }
    else if(status.trim() ==""||status.trim()==null)
    {
        alert("status must be filled out");
        return false;
    }
    else if(FromDate>ToDate)
    {
        alert("Invalid Date Range!");
        return false;
    }
    else if(table_len  ==0||table_len ==null)
    {
        alert("At lest one Invoice Detail is required.");
        return false;
    }

    let file_extension=attachment.substring(attachment.lastIndexOf('.') + 1);

    if(file_extension!="")
    {
        if((String(file_extension.toLowerCase())) == "jpg"||(String(file_extension.toLowerCase())) == "png" || (String(file_extension.toLowerCase())) == "jpeg"||(String(file_extension.toLowerCase())) == "excel"||(String(file_extension.toLowerCase())) == "doc"||(String(file_extension.toLowerCase())) == "pdf")
        {
        }else
        { alert("required only excel/doc/pdf/image Files.");
        return false;}
    }
}

function add_row()
{
var auto_id=document.getElementById("auto_id").value;
var  product=document.getElementById("product").value;
var description=document.getElementById("description").value;
var price=document.getElementById("price").value;
var qty=document.getElementById("qty").value;
var tax=document.getElementById("tax").value;
var total=parseInt(price)*parseInt(qty)

if(product ==""||product.trim()==null)
{
     alert("product must be filled out");
     return false;
}else if(description==""||description.trim()==null)
{
     alert("description must be filled out");
     return false;
}
else if(price==""||price.trim()==null)
{
     alert("price must be filled out");
     return false;
}
else if(qty==""||qty.trim()==null)
{
     alert("qty must be filled out");
     return false;
}
else
{

var table=document.getElementById("data_table");
var table_len=(table.rows.length)-1;

var row = table.insertRow(table_len).outerHTML="<tr id='row"+table_len+"'> " +
//"<td id='auto_id"+table_len+"'>"+auto_id+"</td> " +
//"<td id='product"+table_len+"' name='product'>"+product+"</td> " +
//"<td id='description"+table_len+"' name='description'>"+description+"</td> " +
//"<td id='price"+table_len+"' name='price'>"+price+"</td> " +
//"<td id='qty"+table_len+"' name='qty'>"+qty+"</td> " +
//"<td id='tax"+table_len+"' name='tax'>"+tax+"</td> " +
//"<td id='total"+table_len+"' name='total'>"+total+"</td> " +

"<td id='auto_id"+table_len+"'><input type='text' value='"+auto_id+"' class='form-control'></td> " +
"<td id='product"+table_len+"'><input type='text'  name='product' value='"+product+"' class='form-control'></td> " +
"<td id='description"+table_len+"' ><input type='text' name='description' value='"+description+"' class='form-control'></td> " +
"<td id='price"+table_len+"' ><input type='text' name='price' value='"+price+"' class='form-control'></td> " +
"<td id='qty"+table_len+"' ><input type='text' name='qty' value='"+qty+"' class='form-control'></td> " +
"<td id='tax"+table_len+"' ><input type='text' name='tax' value='"+tax+"' id='tax1"+table_len+"' class='form-control'></td> " +
"<td id='total"+table_len+"' ><input type='text' name='total' value='"+total+"' id='tot"+table_len+"' class='form-control'></td> " +

"<td><i class='fa fa-trash' style='font-size:24px' onclick='delete_row("+table_len+")'> </i></td> " +
"</tr>";

var sub_total=0;
var total_tax=0;

for(var i=0;i<=table_len;i++)
{
   sub_total+= parseInt(document.getElementById("tot"+i).value);
   total_tax+=parseInt(document.getElementById("tax1"+i ).value);
}
//console.log( total_tax );

document.getElementById("auto_id").value=parseInt(auto_id)+1 ;
document.getElementById("product").value="";
document.getElementById("description").value="";
document.getElementById("price").value="";
document.getElementById("qty").value="";
document.getElementById("tax").value=0;
//document.getElementById("total").value="";
document.getElementById("sub_total").innerHTML=sub_total;
document.getElementById("total_tax").innerHTML=total_tax;
document.getElementById("grand_total1").value=sub_total+total_tax;
//alert(sub_total+total_tax);
}
}

 function delete_row(no)
 {
     document.getElementById("row"+no+"").outerHTML="";

    var table=document.getElementById("data_table");
    var table_len=(table.rows.length)-1;
    console.log( parseInt(document.getElementById("tot" ).value))

          document.getElementById("sub_total").innerHTML=sub_total;
          document.getElementById("total_tax").innerHTML=total_tax;
          document.getElementById('grand_total').innerHTML=sub_total+total_tax;
 }




