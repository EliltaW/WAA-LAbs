import "../../index.css";
const Post = (props) => {
  return (
    <div className="Content">
      <h1> {props.name}</h1>
      <div className="Field">
        <div>{props.id}</div>
        <div>{props.title}</div>
        <div>{props.author}</div>
      </div>
    </div>
    // </button>
  );
};

export default Post;

// <button
//   onClick={() => {
//     props.handleClickedPost(props.id, props.title, props.author);
//   }}
// >
