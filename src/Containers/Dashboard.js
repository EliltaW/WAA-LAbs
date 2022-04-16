import Posts from "./Posts/posts";
import "../index.css";
import { useState } from "react";
import PostDetails from "../Components/PostDetails/PostDetails";
import NewPost from "../Components/NewPost/NewPost";
import { Selected } from "../Store/Selected";

export default function Dashboard() {
  // const [clickedPost, setClickedPost] = useState({});
  const [fetchFlag, setFetchFlag] = useState(true);
  const [selectedState, setSelectedState] = useState(0);

  const setSelected = (id) => {
    setSelectedState(id);
    console.log(selectedState);
  };

  const changeFetchFlag = (id) => {
    setFetchFlag(!fetchFlag);
  };

  return (
    <div className="Post">
      <Selected.Provider value={setSelected}>
        <fieldset className="form">
          <div>
            <Posts fetchFlag={fetchFlag} />
          </div>
          <div>
            <PostDetails id={selectedState} changeFetchFlag={changeFetchFlag} />
          </div>

          <div>
            <NewPost changeFetchFlag={changeFetchFlag} />
          </div>
        </fieldset>
      </Selected.Provider>
    </div>
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
