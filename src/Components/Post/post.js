const Post = (props) => {
  return (
    // <button
    //   onClick={() => {
    //     props.handleClickedPost(props.id, props.title, props.author);
    //   }}
    // >
    <div className="Content" onClick={props.setSelected}>
      <div>{props.id}</div>
      <div>{props.title}</div>
      <div>{props.author}</div>
    </div>
    // </button>
  );
};

export default Post;
