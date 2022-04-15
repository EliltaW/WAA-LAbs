import Posts from "./Posts/posts";

import { useState } from "react";
import PostDetails from "../Components/PostDetails/PostDetails";
import NewPost from "../Components/NewPost/NewPost";

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
  // const handleClickedPost = (id, title, author) => {
  //   setClickedPost({ id, title, author });
  // };

  return (
    <div>
      <Posts setSelected={setSelected} fetchFlag={fetchFlag} />
      <div className="Product">
        <PostDetails id={selectedState} changeFetchFlag={changeFetchFlag} />
      </div>

      <br></br>

      <div>
        <NewPost changeFetchFlag={changeFetchFlag} />
      </div>
      <br></br>
      <div>
        <input
          type={"text"}
          label={"title"}
          name={"title"}
          // value={postsState.title}
        />
        <button>Edit Title</button>
      </div>
      {/* {Object.keys(clickedPost).length !== 0 ? (
        <div>
          New Component {clickedPost.id} {clickedPost.title}{" "}
          {clickedPost.author}
        </div>
      ) : (
        ""
      )} */}
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
