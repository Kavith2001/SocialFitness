import React, { useRef } from "react";
import axios from 'axios'; // Import Axios for making HTTP requests
import { useDispatch, useSelector } from "react-redux";
import { getPostsByUserId, savePost } from "../../app/actions/post.actions";
import storage from "../../util/firebaseConfig";
import { ref, uploadBytesResumable, getDownloadURL } from "firebase/storage";
//import './MealPlanning.css';

function Recipies() {
  const dispatch = useDispatch();
  const user = useSelector((state) => state.user);
  const fileInputRef = useRef(null);

  const [meal, setMeal] = React.useState("");
  const [portion, setPortion] = React.useState("");
  const [calories, setCalories] = React.useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    const post = {
      userId: user.userId,
      meal,
      portion,
      calories,
    };
    try {
      // Make a POST request to your Spring Boot backend
      await axios.post('http://localhost:8081/api/mealplan', post);
      // Handle success, maybe show a success message
      console.log('Meal saved successfully');
      // Reset form fields or do any other necessary actions
      setMeal("");
      setPortion("");
      setCalories("");
      fileInputRef.current.value = "";
    } catch (error) {
      // Handle error, maybe show an error message
      console.error('Error saving meal:', error);
    }
  };

  
  return (
    <div className="meal" style={{ backgroundSize: 'cover', backgroundPosition: 'center', width: '100%' , height: '100%'}}>
      <div className="card-body" >
        <form onSubmit={handleSubmit}>
          <center><h1 className="mt-2">Meal Planning</h1></center>
          <div style={{height: '30px'}}></div>
          <center><h2 className="mt-2">Manage and Plan Your Meals Efficiently</h2>
          <div className="mt-2 mb-3">
            <label className="form-label"></label>
            <input
              type="text"
              style={{marginTop: '50px', width: '500px'}}
              className="form-control"
              placeholder="Meal Name"
              value={meal}
              onChange={(e) => setMeal(e.target.value)}
            />
            <br></br>
            <input 
              type="text"
              style={{marginTop: '10px', width: '500px'}}
              className="form-control"
              placeholder="Portion"
              value={portion}
              onChange={(e) => setPortion(e.target.value)}
            />
            <br></br>
            <input 
              type="text"
              style={{marginTop: '10px', width: '500px'}}
              className="form-control"
              placeholder="No of Calories"
              value={calories}
              onChange={(e) => setCalories(e.target.value)}
            />
          </div>
      
          </center>

          <br></br>

          <center><button style={{marginBottom: '200px'}} type="submit" className="btn btn-outline-primary">
            Manage
          </button></center>
        </form>
      </div>
    </div>
  );
}

export default Recipies;
