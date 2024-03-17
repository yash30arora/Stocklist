import { useEffect, useState } from "react";
import { Islogin } from "../auth/Islogin";
import { Logout } from "../auth/Logout";
import { Navigate, useNavigate } from "react-router-dom";
import { Currentuser } from "../auth/Currentuser";
import { Button } from "react-bootstrap";

const NavBar = () => {
  let navigate = useNavigate();
  const [isOpen, setOpen] = useState(false);
  const [login, setLogin] = useState(false);
  const [user, setUser] = useState(undefined);
  useEffect(() => {
    setLogin(Islogin);
    // setUser(Currentuser())
  }, [login]);
  const navigateHome = () => navigate("/");
  const navigateLogin = () => navigate("/Login");
  const navigateSignup = () => navigate("/Signup");
  const navigateDashboard = () => navigate("/user/dashboard");
  const navigateWishlist = () => navigate("/user/wishlist");
  const logout = () => {
    Logout(() => {
      setLogin(false);
      navigate("/");
    });
  };

  return (
    <div>
      <nav
        class="navbar navbar-expand-sm py-3 fixed-top"
        style={{ backgroundColor: "rgba(0, 0, 0, 0.5)", color: "white" }}
      >
        <div class="container">
          <a class="navbar-brand" href="#">
          🆂🆃🅾🅲🅺🅻🅸🆂🆃
          </a>
          <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <i class="fa fa-bars text-light" aria-hidden="true"></i>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto float-right text-right">
              {!login && (
                <>
                  <li class="nav-item">
                    <Button
                      type="submit"
                      className="formlevel button"
                       onClick={navigateHome} style={{ backgroundColor: "rgba(0, 0, 0, 0.5)", color: "white",margin:"5px" }}
                    >
                      Home
                    </Button>
                  </li>
                  <li class="nav-item">
                    <Button
                      type="submit"
                      className="formlevel button"
                      onClick={navigateLogin} style={{ backgroundColor: "rgba(0, 0, 0, 0.5)", color: "white",margin:"5px" }}
                    >
                      Login
                    </Button>
                  </li>
                  <li class="nav-item">
                    <Button
                      type="submit"
                      className="formlevel button"
                      onClick={navigateSignup} style={{ backgroundColor: "rgba(0, 0, 0, 0.5)", color: "white",margin:"5px" }}
                    >
                      Signup
                    </Button>
                  </li>
                </>
              )}
              {login && (
                <>
                  <li class="nav-item ">
                    <Button
                      type="submit"
                      className="formlevel button"
                      onClick={navigateDashboard} style={{ backgroundColor: "rgba(0, 0, 0, 0.5)", color: "white",margin:"5px" }}
                    >
                      Dashboard
                    </Button>
                  </li>
                  <li class="nav-item">
                    <Button
                      type="submit"
                      className="formlevel button"
                      onClick={navigateWishlist} style={{ backgroundColor: "rgba(0, 0, 0, 0.5)", color: "white",margin:"5px" }}
                    >
                      Wishlist
                    </Button>
                  </li>

                  <li class="nav-item">
                    {/* <a class="nav-link ml-5" onClick={logout} href="#">
                      Logout
                    </a> */}
                    <Button
                      type="submit"
                      className="formlevel button"
                      onClick={logout} style={{ backgroundColor: "rgba(0, 0, 0, 0.5)", color: "white",margin:"5px" }}
                    >
                      Logout
                    </Button>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link ml-5">{}</a>
                  </li>
                </>
              )}
            </ul>
          </div>
        </div>
      </nav>
    </div>
  );
};

export default NavBar;
