import { useState } from "react";
import NewPost from "../Components/NewPost/NewPost";
import Posts from "./Posts/posts";

export default function Dashboard() {
  let i = 114;
  console.log(i + "let");

  const [postsState, setPostsState] = useState([
    { id: 111, title: "Happiness", author: "John" },
    { id: 112, title: "MIU", author: "Dean" },
    { id: 113, title: "Enjoy Life", author: "JAsmine" },
  ]);

  const [newPostState, setNewPostState] = useState({
    title: "",
    author: "",
  });

  const onChange = (events) => {
    const updateTitle = {
      ...postsState[0],
      [events.target.name]: events.target.value,
    };
    setPostsState[0](updateTitle);
    // const copy = { ...newPostState };
    // copy[events.target.name] = events.target.value;
    // setNewPostState(copy);
  };

  const addButtonClicked = () => {
    const copy = { ...newPostState };
    copy.id = i;
    console.log(i + "before");
    i++;
    console.log(i + "after");
    const copyPostsState = [...postsState];
    copyPostsState.push(copy);
    setPostsState(copyPostsState);
  };

  // const updateTitle = (events) => {
  //   postsState[0].title = events.target.value;
  // };

  const onClick = () => {};

  return (
    <div>
      <Posts posts={postsState} onClick={onClick} />
      <div>
        <input
          type={"text"}
          label={"title"}
          name={"title"}
          value={postsState.title}
        />
        <button onClick={onChange}>Edit Title</button>
      </div>
    </div>
  );
}

// {
//    <NewPost
//         title={newPostState.title}
//         author={newPostState.author}
//         onChange={(event) => {
//           onChange(event);
//         }}
//         addButtonClicked={addButtonClicked}
//       />
// }
