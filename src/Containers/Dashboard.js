import Posts from "./Posts/Posts";
import { useState } from "react";
export default function Dashboard() {
  const [postsState, setPostsState] = useState([
    { id: 111, title: "Happiness", author: "John" },
    { id: 112, title: "MIU", author: "Dean" },
    { id: 113, title: "Enjoy Life", author: "JAsmine" },
  ]);

  return (
    <div>
      <Posts posts={postsState} />
    </div>
  );
}
