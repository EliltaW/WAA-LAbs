import Posts from "./Posts/Posts";
import { useState, useEffect } from "react";
export default function Dashboard(props) {
  const [title, setTitle] = useState("");

  const onChange = (event) => {
    event.preventDefault();
    props.updateTitle(title);
  };

  return (
    <div>
      <Posts posts={props.postsState} />
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
