import React, { useEffect } from "react";
import Posts from "../../Components/Posts";
import { useDispatch, useSelector } from "react-redux";
import { getPostsByUserId } from "../../app/actions/post.actions";
import PostAdd from "../../Components/PostAdd";
import UserProfile from "./user-profile";
import SharedPosts from "../SharedPosts";
import Notifications from "../../Components/NotificationList";

function User() {
  const dispatch = useDispatch();
  const post = useSelector((state) => state.post);
  const user = useSelector((state) => state.user);

  useEffect(() => {
    if (user.userId) {
      dispatch(getPostsByUserId(user.userId));
    }
  }, [dispatch, user.userId]);

  return (
    <div className="container mt-3 mb-5 row">
      
      <div className="col-md-3">
        <UserProfile />
      </div>

      <div className="col-md-7">
        <PostAdd />
        <nav>
          <div class="nav nav-tabs " id="nav-tab" role="tablist">
            <button
              class="nav-link active"
              id="nav-home-tab"
              data-bs-toggle="tab"
              data-bs-target="#nav-home"
              type="button"
              role="tab"
              aria-controls="nav-home"
              aria-selected="true"
            >
              POSTS
            </button>
            <button
              class="nav-link"
              id="nav-profile-tab"
              data-bs-toggle="tab"
              data-bs-target="#nav-profile"
              type="button"
              role="tab"
              aria-controls="nav-profile"
              aria-selected="false"
            >
              SHARED POSTS
            </button>
          </div>
        </nav>
        <div class="tab-content" id="nav-tabContent">
          <div
            class="tab-pane fade show active"
            id="nav-home"
            role="tabpanel"
            aria-labelledby="nav-home-tab"
          >
            <Posts posts={post.posts} fetchType="GET_ALL_USER_POSTS" />
          </div>
          <div
            class="tab-pane fade"
            id="nav-profile"
            role="tabpanel"
            aria-labelledby="nav-profile-tab"
          >
            <SharedPosts />
          </div>
        </div>
      </div>
      <div className="col-md-3" style={{ position: "fixed", top: "100px", right: "30px" }}>
        <Notifications />
      </div>
    </div>
  );
}

export default User;
