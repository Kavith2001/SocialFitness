import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "./App.css";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import Navbar from "./Components/Navbar";
import Login from "./Pages/Login";
import Register from "./Pages/Register";
import Home from "./Pages/Home";
import User from "./Pages/User";
import SharedPosts from "./Pages/SharedPosts";
import Profile from "./Pages/Profile";
import UserPosts from "./Pages/UserPosts"; // post
import Meals from "../src/Pages/MealPlanning/"; // meal
import Workouts from "../src/Pages/Workouts/"; // meal


function App() {
    return (
        <div>
            <Router>
                <Navbar />
                <div className="body">
                    <Routes>
                        <Route path="/" element={<Home />} />
                        <Route path="/user" element={<User />} />
                        <Route path="/user/:userId" element={<UserPosts />} />
                        <Route path="/sharedposts" element={<SharedPosts />} />
                        <Route path="/login" element={<Login />} />
                        <Route path="/signup" element={<Register />} />
                        <Route path="/profile" element={<Profile />} />
                        <Route path="/Meals" element={<Meals />} />
                        <Route path="/Workouts" element={<Workouts />} />
                    </Routes>
                </div>
            </Router>
            <ToastContainer
                position="top-right"
                autoClose={3000}
                hideProgressBar={false}
                newestOnTop
                closeOnClick
                rtl={false}
                pauseOnFocusLoss
                draggable
                pauseOnHover
                theme="light"
            />
        </div>
    );
}

export default App;
