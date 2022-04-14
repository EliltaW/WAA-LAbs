import "./App.css";
import { useState, useEffect } from "react";
import Dashboard from "./Containers/Dashboard";

function App() {
  const [postsState, setPostsState] = useState([
    { id: 111, title: "Happiness", author: "John" },
    { id: 112, title: "MIU", author: "Dean" },
    { id: 113, title: "Enjoy Life", author: "JAsmine" },
  ]);

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
    <div className="App">
      <h1>Welcome TO Today's Posts</h1>
      <Dashboard updateTitle={updateTitle} postsState={postsState} />
    </div>
  );
}

export default App;
