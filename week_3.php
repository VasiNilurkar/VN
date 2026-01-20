<?php
$server="localhost";
$user="root";
$pass="Vasi@8391";
$db="vn";

$conn=mysqli_connect($server,$user,$pass,$db);

if($conn)
{
    echo "Connectected Successfully!";
$msg = "";
if (isset($_POST['save']))
    {
    $name = $_POST['name'];
    $email = $_POST['email'];
    $course = $_POST['course'];
    $phone = $_POST['phone'];
    $address = $_POST['address'];

    if (!empty($name) && !empty($email) && !empty($course)) {
        $conn->query("INSERT INTO student (name,email,course,address,phone) VALUES ('$name','$email','$course','$address','$phone')");
        $msg = "Student record saved successfully!";
    } else {
        $msg = "All fields are required!";
    }
}
}
else
{
    echo "Not Connected ";
}

$result = $conn->query("SELECT * FROM student");
?>

<!DOCTYPE html>
<html>
<head>
<title>Student Records</title>
<style>
body { font-family: Arial; margin: 40px; }
input, button { padding: 8px; margin: 5px; width: 95%; }
table { width: 100%; border-collapse: collapse; margin-top: 20px; }
th, td { border: 1px solid #ccc; padding: 10px; }
th { background-color: #2c3e50; color: white; }
.form-box { width: 400px; border: 1px solid #ccc; padding: 20px; }
.msg { color: green; }
</style>
</head>

<body>

<h2>Add Student</h2>

<div class="form-box">
<form method="post">
    <input type="text" name="name" placeholder="Student Name">
    <input type="email" name="email" placeholder="Email">
    <input type="text" name="course" placeholder="Course">
    
    <input type="text" name="address" placeholder="Address">
    <input type="text" name="phone" placeholder="Phone">
    <button name="save">Save Student</button>
</form>
<p class="msg"><?php echo $msg; ?></p>
</div>

<h2>Student Records</h2>

<?php if ($result && $result->num_rows > 0) { ?>
<table>
<tr>
    <!-- <th>ID</th> -->
    <th>Name</th>
    <th>Email</th>
    <th>Course</th>
    

    <th>Address</th>
    <th>Phone</th>
</tr>

<?php while ($row = $result->fetch_assoc()) { ?>
<tr>
    
    <td><?php echo $row['name']; ?></td>
    <td><?php echo $row['email']; ?></td>
    <td><?php echo $row['course']; ?></td>
    
    <td><?php echo $row['address']; ?></td>
    <td><?php echo $row['phone']; ?></td>
</tr>
<?php } ?>
</table>

<?php } else { ?>
<p style="color:red;">No student records found.</p>
<?php }
 ?>

</body>
</html>