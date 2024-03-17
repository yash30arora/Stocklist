import axios from 'axios';
import React, { useState } from 'react'
import Form from 'react-bootstrap/Form';
import { Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import Card from 'react-bootstrap/Card';
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import NavBar from './NavBar';
import Swal from 'sweetalert2';

function Login() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    function isValidEmail(email) {
        // Regular expression for validating email format
        const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
        return emailRegex.test(email);
    }

    async function login(event) {
        event.preventDefault();
        if (!isValidEmail(email)) {
            toast.error("Invalid email format.");
            return;
        }
        if (!email.trim() || !password.trim()) {
            toast.error("Email and password are required.");
            return;
        }
        try {
            const response = await axios.post('http://localhost:8089/login', {
                email: email,
                password: password
            });
            const { data } = response;
            Swal.fire({
                position: 'center',
                icon: 'success',
                text: 'Login successful!',
                showConfirmButton: true,
                timer: 10000
            });
            localStorage.setItem('token', data.token);
            localStorage.setItem('email', data.email);
            navigate('/user/dashboard');
        } catch (error) {
            toast.error('Email and password are incorrect.');
        }
    }

    return (
        <div>
            <NavBar />
            <div className='login-container'>
                <div className='container d-flex justify-content-center align-items-center'>
                    <Card style={{ width: '30rem', marginTop: '100px', backgroundColor: 'rgba(0, 0, 0, 0.8)', color: 'white' }}>
                        <Card.Body>
                            <Form className='login' onSubmit={login}>
                                <div className='logo'>
                                </div>
                                <h2>Login into Stocks</h2>
                                <Form.Group className="mb-3" controlId="Email">
                                    <Form.Label>Email address</Form.Label>
                                    <Form.Control type="email" placeholder="Enter email" value={email}
                                        onChange={(event) => setEmail(event.target.value)} required />
                                </Form.Group>
                                <Form.Group className="mb-3" controlId="Password">
                                    <Form.Label>Password</Form.Label>
                                    <Form.Control type="password" placeholder="Password" value={password}
                                        onChange={(event) => setPassword(event.target.value)} required />
                                </Form.Group>
                                <div className='button-group justify-content-center'>
                                    <Button type='submit' variant="success">Login</Button>
                                </div>
                            </Form>
                        </Card.Body>
                    </Card>
                </div>
            </div>
        </div>
    );
}

export default Login;
