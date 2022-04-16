import "./Comment.css";
const Comment = (props) => {
  return (
    <div className="Comment">
      {props.name}
      {props.comment}
    </div>
  );
};

export default Comment;
