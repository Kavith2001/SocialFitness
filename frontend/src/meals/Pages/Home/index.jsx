import React, { useEffect } from "react";
import Posts from "../../Components/Posts";
import { useDispatch, useSelector } from "react-redux";
import { getPosts } from "../../app/actions/post.actions";
import NewUsersSuggest from "../../Components/NewUsersSuggest";
import Notifications from "../../Components/NotificationList/index"

function Home() {
  const dispatch = useDispatch();
  const post = useSelector((state) => state.post);

  useEffect(() => {
    dispatch(getPosts());
  }, [dispatch]);

  return (
    <div className="" style={{marginLeft:"30px"}}>
      <div className="row">
        <hr></hr>
        <div className="col-md-3">
          <div className="sticky-top" style={{marginTop:"2px"}}>
            {/* Sidebar */}
            <NewUsersSuggest />
          </div>
        </div>
        <div className="col-md-6">
          {/* Main Content */}
          <div className="row">
            <div className="col-12">
              {/* Status Update Form */}
              {/* You can add a status update form here */}
            </div>
            <div className="" style={{marginRight:"10px",marginTop:"2px"}}>
              {/* News Feed */}
              <Posts posts={post.posts} fetchType="GET_ALL_POSTS" />
            </div>
          </div>
        </div>
        <div className="col-md-3">
          <div className="sticky-top">
            {/* Right Sidebar */}
            {/* You can add friend suggestions or trending topics here */}
          </div>
          
          <div className="col-mt-5" style={{marginRight:"10px",marginTop:"2px"}}>
          <Notifications/>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Home;
