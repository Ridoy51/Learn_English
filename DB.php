<?php
$conn=mysql_connect("localhost","root","");
mysql_select_db($conn, "test");
$qry="select * from word";
$raw=mysql_query($conn,$qry);

while ($res=mysqli_fetch_array($raw)) {
	$data[]=$res;
}
print(json_encode($data));
?>