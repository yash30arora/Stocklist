
import './App.css';

import Login from './components/Login';
import { BrowserRouter as Router, Route, Routes, BrowserRouter } from 'react-router-dom';
import Signup from './components/Signup';
import Landingpage from './components/Landingpage';
import NavBar from './components/NavBar';
import Stockapi from './components/Stockapi';
import Privateroute from './components/Privateroute';
import Wishlist from './components/Wishlist';



function App() {
  return (
    <div>
      <BrowserRouter>
      
    
    
        <Routes>
        
            <Route exact path='/' element={<Landingpage/>}/>
            <Route exact path='/signup' element={<Signup/>}/>
            <Route exact path='/login' element={<Login/>}/>
            
            <Route exact path='/user' element={<Privateroute />}>
            <Route exact path='dashboard' element={<Stockapi/>}/>
            <Route exact path='wishlist' element={<Wishlist/>}/>
              </Route>
        </Routes>
    
    </BrowserRouter>
</div>
  );
}

export default App;
