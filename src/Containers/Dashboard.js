import "../index.css";
import "../Containers/Header/Header.css";
import React from "react";
import { BrowserRouter } from "react-router-dom";
import PageRoutes from "../Pages/PageRoutes";
import Header from "./Header/Header";

export default function Dashboard() {
  return (
    <BrowserRouter>
      <React.Fragment>
        <div className="header">
          <Header />
        </div>
        <div className="product">
          <PageRoutes />
        </div>
      </React.Fragment>
    </BrowserRouter>
  );
}

// const updateTitle = (events) => {
//   postsState[0].title = events.target.value;
// };

// const onClick = () => {};

// const copy = { ...newPostState };
// copy.id = i;
// console.log(i + "before");
// i++;
// console.log(i + "after");
// const copyPostsState = [...postsState];
// copyPostsState.push(copy);
// setPostsState(copyPostsState);

// const updateTitle = {
//   ...postsState[0],
//   [events.target.name]: events.target.value,
// };
// setPostsState[0](updateTitle);
// const copy = { ...newPostState };
// copy[events.target.name] = events.target.value;
// setNewPostState(copy);

//  { {Object.keys(clickedPost).length !== 0 ? (
//         <div>
//           New Component {clickedPost.id} {clickedPost.title}{" "}
//           {clickedPost.author}
//         </div>
//       ) : (
//         ""
//       )} }

// const handleClickedPost = (id, title, author) => {
//   setClickedPost({ id, title, author });
// };
