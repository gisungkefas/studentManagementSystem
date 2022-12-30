import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container ,Paper,Button} from '@material-ui/core';

const useStyles = makeStyles((theme) => ({
    root: {
        '& > *': {
            margin: theme.spacing(1),

        },
    },
}));

export default function Student() {
    const paperStyle={padding:'50px 20px', width:600,margin:"20px auto"}
    const[firstName,setFirstName]=useState('')
    const[lastName,setLastName]=useState('')
    const[email,setEmail]=useState('')
    const[gender,setGender]=useState('')
    const[dob,setDob]=useState('')
    const[phoneNumber,setPhoneNumber]=useState('')
    const[address,setAddress]=useState('')
    const[students,setStudents]=useState([])
    const classes = useStyles();

    const handleClick=(e)=>{
        e.preventDefault()
        const student={firstName, lastName, email, gender, dob, phoneNumber, address}
        console.log(student)
        fetch("http://localhost:8080/api/v1/student/add",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(student)

        }).then(()=>{
            console.log("New Student added")
        })
    }

    const reset = (e) => {
        e.preventDefault();
        setStudents({
            firstName:"",
            lastName:"",
            email:"",
            gender:"",
            dob:"",
            phoneNumber:"",
            address:""
        });
    };

    useEffect(()=>{
        fetch("http://localhost:8080/api/v1/student/getAll")
            .then(res=>res.json())
            .then((result)=>{
                    setStudents(result);
                }
            )
    },[])
    return (

        <Container>
            <Paper elevation={3} style={paperStyle}>
                <h1 style={{color:"blue"}}><u>Add Student</u></h1>

                <form className={classes.root} noValidate autoComplete="off">

                    <TextField id="outlined-basic" label="Student FirstName" variant="outlined" fullWidth
                               value={firstName}
                               onChange={(e)=>setFirstName(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Student LastName" variant="outlined" fullWidth
                               value={lastName}
                               onChange={(e)=>setLastName(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Student Email" variant="outlined" fullWidth
                               value={email}
                               onChange={(e)=>setEmail(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Student Gender" variant="outlined" fullWidth
                               value={gender}
                               onChange={(e)=>setGender(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Student DOB" variant="outlined" fullWidth
                               value={dob}
                               onChange={(e)=>setDob(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Student PhoneNumber" variant="outlined" fullWidth
                               value={phoneNumber}
                               onChange={(e)=>setPhoneNumber(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Student Address" variant="outlined" fullWidth
                               value={address}
                               onChange={(e)=>setAddress(e.target.value)}
                    />
                    <Button variant="contained" color="primary" onClick={handleClick}> Submit </Button>
                    <Button variant="contained" color="secondary" onClick={reset}> Clear </Button>
                </form>

            </Paper>
            <h1>Students</h1>

            <Paper elevation={3} style={paperStyle}>

                {students.map(student=>(
                    <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={student.id}>
                        Id:{student.id}<br/>
                        FirstName:{student.firstName}<br/>
                        LastName:{student.lastName}<br/>
                        Email:{student.email}<br/>
                        Gender:{student.gender}<br/>
                        Dob:{student.dob}<br/>
                        PhoneNumber:{student.phoneNumber}<br/>
                        Address:{student.address}
                    </Paper>
                ))
                }
            </Paper>
        </Container>
    );
}