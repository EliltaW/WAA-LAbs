import Posts from "./Posts/Posts";
import { useState } from "react";
export default function Dashboard() {
  const [postsState, setPostsState] = useState([
    { id: 111, title: "Happiness", author: "John" },
    { id: 112, title: "MIU", author: "Dean" },
    { id: 113, title: "Enjoy Life", author: "JAsmine" },
  ]);

  const onChange = (events) => {
    // const copy = { ...postsState };
    // copy[events.target.name] = events.target.value;
    // setPostsState(copy);
  };

  return (
    <div>
      <Posts posts={postsState} />
      <div>
        <input
          type={"text"}
          label={"title"}
          name={"title"}
          onChange={(event) => {
            onChange(event);
          }}
          value={postsState.title}
        />
        <button>Edit Title</button>
      </div>
    </div>
  );
}
