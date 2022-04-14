import Posts from "./Posts/Posts";
import { useState } from "react";
export default function Dashboard() {
  const [postsState, setPostsState] = useState([
    { id: 111, title: "Happiness", author: "John" },
    { id: 112, title: "MIU", author: "Dean" },
    { id: 113, title: "Enjoy Life", author: "JAsmine" },
  ]);

  const [title, setTitle] = useState("");

  const onChange = (event) => {
    event.preventDefault();
    updateTitle(title);
  };

  const updateTitle = (title) => {
    const newFirstPost = postsState[0];
    newFirstPost.title = title;
    const newPosts = postsState;
    newPosts.shift();
    newPosts.unshift(newFirstPost);
    setPostsState(newPosts);
    console.log(postsState);
  };

  return (
    <div>
      <Posts posts={postsState} />
      <div>
        <input
          type={"text"}
          label={"title"}
          name={"title"}
          value={title}
          onChange={(e) => {
            setTitle(e.target.value);
          }}
        />
        <button
          onClick={(event) => {
            onChange(event);
          }}
        >
          Edit Title
        </button>
      </div>
    </div>
  );
}
