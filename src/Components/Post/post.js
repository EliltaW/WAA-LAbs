import { useContext } from "react";
import { Selected } from "../../Store/Selected";
import "../../index.css";
const Post = (props) => {
  const setSelected = useContext(Selected);

  return (
    <div
      className="Content"
      onClick={() => {
        setSelected(props.id);
      }}
    >
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
