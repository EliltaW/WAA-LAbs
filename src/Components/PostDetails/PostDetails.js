import axios from "axios";
import { useEffect, useState } from "react";
import Comment from "../Comment/Comment";
import "./PostDetails.css";

const PostDetails = (props) => {
  const [postDetail, setPostDetail] = useState({});

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/v1/posts/" + props.id + "/comments")
      .then((response) => {
        console.log(response.data);
        setPostDetail(response.data);
        console.log(postDetail);
      })
      .catch((err) => console.log(err.message));
  }, [props.id]);

  const deleteButtonClicked = (id) => {
    axios
      .delete("http://localhost:8080/api/v1/posts/" + id)
      .then((response) => {
        props.changeFetchFlag();
      })
      .catch((err) => console.log(err.message));
  };

  let postDetailsDisplay = null;
  if (props.id != 0) {
    postDetailsDisplay = (
      <div className="PostDetail">
        <div>Post Detail</div>
        <h1>{postDetail.name}</h1>
        <div>
          Comment
          {postDetail.comment != null
            ? postDetail.comment.map((cont) => {
                return (
                  <Comment
                    name={cont.name}
                    comment={cont.comment}
                    key={cont.id}
                  />
                );
              })
            : null}
        </div>
        <button
          onClick={() => {
            deleteButtonClicked(props.id);
          }}
        >
          Delete
        </button>
      </div>
    );
  }

  return postDetailsDisplay;
};

export default PostDetails;
