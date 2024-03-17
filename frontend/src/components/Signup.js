import React, { useState } from 'react';
import axios from 'axios';
import Form from 'react-bootstrap/Form';
import { Button } from 'react-bootstrap';
import Card from 'react-bootstrap/Card';
import { useNavigate } from 'react-router-dom';
import NavBar from './NavBar';
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import Swal from 'sweetalert2';

function Signup() {
    const [userid, setUserid] = useState('');
    const [name, setName] = useState("");
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const [country, setCountry] = useState("");
    const navigate = useNavigate();

    function isValidEmail(email) {
        const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
        return emailRegex.test(email);
    }

    function isValidName(name) {
      // Minimum and maximum length requirements
      const minLength = 2; // Minimum length of 2 characters
      const maxLength = 50; // Maximum length of 50 characters
  
      // Check if the name is not empty and within the length range
      return name.trim().length >= minLength && name.trim().length <= maxLength;
  }
  
    async function save(event) {
        event.preventDefault();
        if (!isValidEmail(email)) {
            toast.error("Invalid email format.");
            return;
        }
        if (!isValidName(name)) {
            toast.error("Invalid name.");
            return;
        }
        try {
            const response = await axios.post("http://localhost:8095/ProfitPilot/addUser", {
                userid,
                name,
                password,
                email,
                country
            });
            const result = response.data;
            Swal.fire({
                position: 'center',
                icon: 'success',
                text: 'Registration successful!',
                showConfirmButton: true,
                timer: 10000
            });
            console.log("Registration Successfull", response.data);
            navigate('/login');
        } catch (error) {
            toast.error("Something went wrong. Please try again later.");
        }
    }

    return (
        <div>
            <NavBar />
            <div className='register'>
                <div className='register-container'>
                    <div className='container d-flex justify-content-center align-items-center'>
                        <Card style={{ width: '35rem', marginTop: '20px', backgroundColor: 'rgba(0, 0, 0, 0.8)', color: 'white' }}>
                            <Card.Body>
                                <Form className='signup' onSubmit={save}>
                                    <h2>Register</h2>
                                    <Form.Group className="mb-2" controlId="Name">
                                        <Form.Label>Name</Form.Label>
                                        <Form.Control type="text" placeholder="Enter name" value={name}
                                            onChange={(event) => setName(event.target.value)} required />
                                    </Form.Group>
                                    <Form.Group className="mb-3" controlId="Password">
                                        <Form.Label>Password</Form.Label>
                                        <Form.Control type="password" placeholder="Password" value={password}
                                            onChange={(event) => setPassword(event.target.value)} required />
                                    </Form.Group>
                                    <Form.Group className="mb-3" controlId="Email">
                                        <Form.Label>Email</Form.Label>
                                        <Form.Control type="email" placeholder="Enter email" value={email}
                                            onChange={(event) => setEmail(event.target.value)} required />
                                    </Form.Group>
                                    <Form.Group className="mb-3" controlId="country">
                                        <Form.Label>Country</Form.Label>
                                        <Form.Control type="text" placeholder="Enter country" value={country}
                                            onChange={(event) => setCountry(event.target.value)} required />
                                    </Form.Group>
                                    <div className='button-group'>
                                        <Button type='Submit' variant="success">Signup</Button>
                                    </div>
                                </Form>
                            </Card.Body>
                        </Card>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Signup;
