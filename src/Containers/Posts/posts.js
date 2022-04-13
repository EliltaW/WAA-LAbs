import Post from "../../Components/Post/post";

const Posts = (props) => {
  const postList = props.posts.map((post) => {
    return (
      <Post
        title={post.title}
        author={post.author}
        id={post.id}
        key={post.id}
        onClick={props.onClick}
      />
    );
  });
  return postList;
};
export default Posts;
