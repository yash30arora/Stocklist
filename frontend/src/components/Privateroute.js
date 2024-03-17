import React from 'react'
import { Islogin } from '../auth/Islogin'
import { Navigate, Outlet } from 'react-router-dom'




const Privateroute =()=> {

   return Islogin() ? <Outlet /> : <Navigate to={"/login"} />


}

export default Privateroute