const Post = (props) => {
  return (
    <div className="Content">
      <div>{props.id}</div>
      <div>{props.title}</div>
      <div>{props.author}</div>
    </div>
  );
};

export default Post;
