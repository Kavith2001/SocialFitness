import React from "react";
import { useDispatch } from "react-redux";
import { Link } from "react-router-dom";
import { login } from "../../app/actions/user.actions";
import "./Login.css"; // Import CSS file for animations

//login
function Login() {
  const dispatch = useDispatch();
  const [username, setUsername] = React.useState("");
  const [password, setPassword] = React.useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    const user = {
      username,
      password,
    };
    dispatch(login(user));
  };

  return (
    //background image come from google
    <div className="register-container" style={{ backgroundImage: `url('https://t4.ftcdn.net/jpg/03/50/81/89/360_F_350818949_lJTfzSTDr79e9Kn55PUVZjN19ct20uGc.jpg')`, backgroundSize: 'cover', backgroundPosition: 'center', boxShadow: "0px 4px 10px rgba(0, 0, 0, 0.1)" }}>
    <div className="register-container animated fadeIn"> {/* Apply fadeIn animation class */}
      <div className="card-body">
        <div className="loginform" style={{marginRight:"700px"}}>
          <div className="col-6">
            <form onSubmit={handleSubmit}>
              <div className="mt-5 mb-3">
                <h1 style={{ color: "white", marginLeft:"70px", fontFamily: "cursive", fontSize: "2.5rem", fontWeight: "bold" }}>Welcome</h1>
                <br />
                <label className="form-label" style={{ color: "white", fontSize: "1.2rem" }}>Username</label>
                <input
                  type="text"
                  className="form-control input-width-login"
                  value={username}
                  onChange={(e) => setUsername(e.target.value)}
                  style={{ borderRadius: "5px", border: "1px solid #ddd" }}
                />
                <div id="emailHelp" className="form-text" style={{ color: "white", fontSize: "0.7rem" }}>
                  We'll never share your username with anyone else.
                </div>
              </div>
              <div className="mb-3">
                <label className="form-label" style={{ color: "white", fontSize: "1.2rem" }}>Password</label>
                <input
                  type="password"
                  className="form-control input-width-login"
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  style={{ borderRadius: "5px", border: "1px solid #ddd" }}
                />
              </div>
              <button type="submit" className="btn btn-primary" style={{ borderRadius: "5px", fontSize: "1.2rem", fontWeight: "bold" }}>
                LOGIN
              </button>
            </form>
            <Link to="/signup" className="text-decoration-none" style={{ color: "white", fontSize: "1rem" }}>
              If you haven't an account. Create new account
            </Link>
          </div>
        </div>
      </div>
    </div>
    </div>
  );
}

export default Login;
