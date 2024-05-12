import React, { useRef } from "react"; // import
import { useDispatch, useSelector } from "react-redux"; // import
import { getPostsByUserId, savePost } from "../../app/actions/post.actions"; // import
import storage from "../../util/firebaseConfig"; // import
import { ref, uploadBytesResumable, getDownloadURL } from "firebase/storage";// import
import './recipies.css'; // css

function Recipies() { // class
  const dispatch = useDispatch(); // dispatch
  const user = useSelector((state) => state.user); // user
  const fileInputRef = useRef(null ); // constfil


  const [caption, setCaption] = React.useState(""); //usestate
  const [imgLink, setImgLink] = React.useState(""); //set state2
  const [desc, setDesc] = React.useState(""); //setstate3


  const handleSubmit = async (e) => {
    e.preventDefault(); // preventdef
    const post = { // open c
      userId: user.userId, //userID
      caption, //caption
      imgLink, //imglinl
      desc, //desc
    };

    await dispatch (savePost(post)); // post
    await dispatch(getPostsByUserId(user.userId)); //id
    setCaption(""); // set caption

    setImgLink(""); // set image
    setDesc(""); // set description
    fileInputRef.current.value = ""; // fileinput


  };

  const uploadImage = (e) => { // upload image
    const files = e.target.files; // constfile
  
    if (files.length === 0)// if condition {
      alert("Please upload at least one image!"); // alermsg
      return;
    }
  
    // upload up to 4 images
    const maxImages =  4; //max 4 files
    const numImages = Math.min(maxImages, files.length); // numimgs
  
    for (let i = 0; i < numImages; i++) {
      const file = files[i]; 
      const storageRef  = ref(storage, `/posts /${file.name}`); //storage
  
      const uploadTask = uploadBytesResumable(storageRef, file); //task uplosad
  
      uploadTask.on( // commenting
        "state_changed", // comment
        (snapshot) => {
          Math.round((snapshot.bytesTransferred  / snapshot.totalBytes) * 100); //rounding
        },
        (err) => console.log(err), // error
        () => {
          getDownloadURL(uploadTask.snapshot.ref).then((url) => { // getdownurl
            setImgLink((prevLinks) => [...prevLinks,  url]); // setimglink
            //setImglink

          });
        }

      
        );
    }
  
  
  
  return (
    <div className="recipe" style={{ backgroundImage: 'url("https://www.shutterstock.com/image-photo/food-background-spices-herbs-utensil-260nw-2255294345.jpg")', backgroundSize: 'cover', backgroundPosition: 'center', width: '100%' , height: '100%'}}>
      <div className="card-body" > 

        <form onSubmit={handleSubmit}> 
          <center><h1 className="mt-2">Eat Healthy </h1> </center> 
          <div style={{height: '30px'}}></div>
          <center><h2 className="mt-2">Share Your all Recipies With Us </h2>
          <div className="mt-2 mb-3">
            <label className="form-label "></label>


            <input

              type="text " // type
              style={{marginTop: '50px', width: '500px'}} // styles
              className="form-control " // classname
              placeholder="Please Enter the recipe name " // name
              value={caption} // value

              onChange={(e) =>  setCaption  (e.target.value)} // onchange
            />

            <br></br>
            <input // inpt

              type="text" 
              style={{marginTop: '10px',  width: '501px'}} // styles
              className="form-control " // classname
              placeholder=" Please Enter the recipe description  " //placeholder
              value={desc} // value
              onChange={(e) => setDesc(e.target.value)} //setdesc value
            />
          </div>
            <i>*maximum 4 images </i>

          <div className="mb-3">

            {imgLink && (
              
              <img

                src={imgLink} // imglink
                className="img-fluid me-3" // classname
                alt="Profile" // profile
              />

            )}

            <input
              type="file" // title
              className="form-control " // classname
              style={{width: '500px'}} //styles
              onChange={(e) => uploadImage(e)} // uploadimg
              ref={fileInputRef } // fileref
              multiple  // multi
            />
          </div></center>
          <br></br> 
          

          <center><button style={{marginBottom: '200px'}} type="submit" className="btn btn-outline-primary"> 
            POST  
          </button></center> 


        </form> 
      </div>
    </div>

  );
            }
            
export default Recipies;
