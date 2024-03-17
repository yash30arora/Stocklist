import React from "react"
import { useNavigate ,Link } from "react-router-dom";

import NavBar from './NavBar';


function Landingpage () {
    const navigate=useNavigate();
return(
  
    <div>
<NavBar/>

<section id="home">
<div >
<video src="/images/stock.mp4" autoPlay loop muted alt="Logo"/> 
</div>
<div class="container">
        <div class="row pt-5">
          <div class="home-text col-md-8 col-sm-12 mt-5">
            <h1>𝑺𝑻𝑶𝑪𝑲𝑳𝑰𝑺𝑻𝑰𝑵𝑮</h1>
            <p>View Every Stock</p>
            <ul class="section-btn">
              <a href="#">
              <span data-hover="Discover More">Discover More</span></a>
            </ul>
          </div>
        </div>
      </div>

      <div class="overlay"></div>
</section>


</div>





)
};
export default Landingpage;

