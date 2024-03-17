import React, { useEffect, useState } from "react";
import axios from "axios";
import Pagination from "./Pagination"; 
import Card from "react-bootstrap/Card";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import { Button, Container } from "react-bootstrap";
import NavBar from "./NavBar";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const Stockapi = () => {
  const [country, setCountry] = useState("");
  const [stockData, setStockData] = useState(null);
  useEffect(() => {
    console.log("Stock data changed:", stockData);
  }, [stockData]);

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.get(
        `http://localhost:8090/Stock/getstock/${country}`,
        {
          headers: {
            Authorization: `Bearer ${localStorage.getItem("token")}`,
          },
        }
      );

      console.log(response.data);
      // Handle the API response
      console.log(response.data.data);
      setStockData(response.data.data);
      console.log(stockData);
    } catch (error) {
      // Handle the error
      console.error(error);
    }
  };

  const handleCountryChange = (event) => {
    setCountry(event.target.value);
  };

  const addToWishlist = async (stock) => {
    try {
      const emailid = localStorage.getItem("email");
      const response = await fetch(
        `http://localhost:7004/wishlist/addWishlist/${emailid}`,
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${localStorage.getItem("token")}`,
          },
          body: JSON.stringify(stock),
        }
      );

      if (response.ok) {
        toast("Save to Wishlist");
        const result = await response.json();
      } else {
        toast.error("Stock Already exist");
      }
    } catch (error) {
      console.error("Error", error);
    }
  };

  const [currentPage, setCurrentPage] = useState(1);
  const [stocksPerPage] = useState(6); // Change the number of stocks per page as needed

  // Logic to paginate the stock data
  const indexOfLastStock = currentPage * stocksPerPage;
  const indexOfFirstStock = indexOfLastStock - stocksPerPage;
  const currentStocks = stockData?.slice(indexOfFirstStock, indexOfLastStock);

  const paginate = (pageNumber) => setCurrentPage(pageNumber);
  

  return (
    <div>
      <NavBar />
      <div className="api">
        <br />
        <br />
        <br />
        <br />
        <div>
          <div
            id="search1"
            className=" container d-flex flex-column align-items-center text-center"
          >
            <h2>Search for Stock</h2>
            <br />
            <form onSubmit={handleSubmit}>
              <label style={{ color: "Black" }}>
                Country: &nbsp;
                <input
                  type="text"
                  value={country}
                  onChange={handleCountryChange}
                />
              </label>
              <br></br>
              <div className="Container d-flex justify-content-center align-items-center">
                <Button className="search" type="submit" variant="success">
                  Search
                </Button>
              </div>
            </form>
          </div>
          <br />

          <Container>
            {currentStocks && currentStocks.length > 0 && (
              <Row xs={1} md={3} className="g-4">
                {currentStocks.map((stock, index) => (
                  <Col key={index}>
                    <Card style={{ height: "55vh", backgroundColor: 'rgba(0, 0, 0, 0.9)'}}>
                      <Card.Body>
                        <Card.Title></Card.Title>
                        <Card.Text style={{ color: 'white'}}>
                          <h3 className="card-text ">symbol:{stock.symbol}</h3>
                          <p className="card-text" style={{ color: 'white'}}>Name: {stock.name}</p>
                          <p className="card-text" style={{ color: 'white'}}>Currency: {stock.currency}</p>
                          <p className="card-text" style={{ color: 'white'}}>Exchange: {stock.exchange}</p>
                          <p className="card-text" style={{ color: 'white'}}>MicCode: {stock.mic_code}</p>
                          <p className="card-text" style={{ color: 'white'}}>Country: {stock.country}</p>
                          <Button id ="addtowishbutton" onClick={() => addToWishlist(stock)}>
                            <h6>Add to Wishlist</h6>
                          </Button>
                        </Card.Text>
                      </Card.Body>
                    </Card>
                  </Col>
                ))}
              </Row>
            )}
          </Container>

          {/* Render pagination component */}
          <Pagination
            currentPage={currentPage}
            totalPages={Math.ceil(stockData?.length / stocksPerPage)}
            onPageChange={paginate}
          />
        </div>
      </div>
    </div>
  );
};

export default Stockapi;
