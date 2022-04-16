import axios from "axios";
import { useRef } from "react";
import "./NewPost.css";

const NewPost = (props) => {
  // const [postState, setPostState] = useState({
  //   post_title: "",
  //   author_name: "",
  // });

  // const onChange = (events) => {
  //   const updatePost = {
  //     ...postState,
  //     [events.target.name]: events.target.value,
  //   };
  //   setPostState(updatePost);
  // };

  const newPostForm = useRef();

  const addButtonClicked = (e) => {
    e.preventDefault();
    const form = newPostForm.current;
    const post = {
      post_title: form["post_title"].value,
      author_name: form["author_name"].value,
    };
    axios.post("http://localhost:8080/api/v1/posts", post).then((response) => {
      // setPostState({ post_title: "", author_name: "" });
      props.changeFetchFlag();
    });
  };
  return (
    <div className="NewPost">
      <form ref={newPostForm} onSubmit={addButtonClicked}>
        <h1>Add a post</h1>
        <label>Title</label>
        <input
          type={"text"}
          label={"post_title"}
          name={"post_title"}
          // onChange={onChange}
          // value={postState.post_title}
        />

        <label> Author </label>
        <input
          type={"text"}
          label={"author_name"}
          name={"author_name"}
          // onChange={onChange}
          // value={postState.author_name}
        />
        <button>Add Post</button>
      </form>
    </div>
  );
};

export default NewPost;
