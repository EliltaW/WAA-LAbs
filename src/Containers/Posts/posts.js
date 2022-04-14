import Post from "../../Components/Post/post";
import { useEffect, useState } from "react";
import axios from "axios";

const Posts = (props) => {
  const [postsState, setPostsState] = useState([
    { post_id: 111, post_title: "Happiness", author_name: "John" },
    { post_id: 112, post_title: "MIU", author_name: "Dean" },
    { post_id: 113, post_title: "Enjoy Life", author_name: "JAsmine" },
  ]);

  const fetchPosts = () => {
    axios
      .get("http://localhost:8080/api/v1/posts")
      .then((response) => {
        console.log(response.data);
        setPostsState(response.data);
      })
      .catch((error) => {
        console.log(error.message);
      });
  };
  useEffect(() => {
    fetchPosts();
  }, []);

  const postList = postsState.map((post) => {
    return (
      <div>
        <Post
          title={post.post_title}
          author={post.author_name}
          id={post.post_id}
          key={post.post_id}
          onClick={props.onClick}
          handleClickedPost={props.handleClickedPost}
          setSelected={() => {
            props.setSelected(post.post_id);
          }}
        />
      </div>
    );
  });
  return postList;
};
export default Posts;
