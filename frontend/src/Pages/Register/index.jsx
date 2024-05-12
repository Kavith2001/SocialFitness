import React from "react";
import { useDispatch } from "react-redux";
import { register } from "../../app/actions/user.actions";
import "./Register.css"; // Import CSS file for styling

//Register Function
function Register() {
  const dispatch = useDispatch();
  const [username, setUsername] = React.useState("");
  const [password, setPassword] = React.useState("");
  const [confirmPassword, setConfirmPassword] = React.useState("");
  const [error, setError] = React.useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!username || !password || !confirmPassword) {
      setError("All fields are required");
      return;
    }

    if (password !== confirmPassword) {
      setError("Passwords do not match");
      return;
    }

    const user = {
      username,
      password,
    };

    dispatch(register(user));
  };

  return (
    //background image come from google
    <div className="register-container" style={{ backgroundImage: `url('https://t4.ftcdn.net/jpg/03/50/81/89/360_F_350818949_lJTfzSTDr79e9Kn55PUVZjN19ct20uGc.jpg')`, backgroundSize: 'cover', backgroundPosition: 'center', boxShadow: "0px 4px 10px rgba(0, 0, 0, 0.1)" }}>
        
        <div className="register-container animated fadeIn"> {/* Apply fadeIn animation class */}
        <div className="loginform" style={{marginRight:"700px"}}>

        <center>

        <h1 style={{ color: "white", fontFamily:"cursive", fontSize: "2.5rem", fontWeight: "bold"}}>SIGN UP</h1></center>
        {error && <div className="error">{error}</div>}
        <form onSubmit={handleSubmit}>
          
            <label style={{ color: "white"}} htmlFor="username">Username</label>

            <input
              type="text"
              id="username"
              className="form-control input-width-login"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />

            <br></br>   

            <label style={{ color: "white"}} htmlFor="password">Password</label>

            <input
              type="password"
              id="password"
              className="form-control input-width-login"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
            />
            <br></br>
            <label style={{ color: "white"}}  htmlFor="confirmPassword">Confirm Password</label>
            <input
              type="password"
              id="confirmPassword"
              className="form-control input-width-login"
              value={confirmPassword}
              onChange={(e) => setConfirmPassword(e.target.value)}
            />
            <br></br>
          <button type="submit" className="btn btn-primary">
            Register
          </button>
        </form>
      </div>
      </div>
    </div>
  );
}  

export default Register;

