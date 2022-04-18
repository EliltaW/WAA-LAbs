import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import Comment from "../Comment/Comment";
import "./PostDetails.css";

const PostDetails = (props) => {
  const [postDetail, setPostDetail] = useState({});
  const navigate = useNavigate();

  const params = useParams();
  useEffect(() => {
    if (params.id) {
      axios
        .get(
          "http://localhost:8080/api/v1/posts/" + params.post_id + "/comments"
        )
        .then((response) => {
          console.log(response.data);
          setPostDetail(response.data);
          console.log(postDetail);
        })
        .catch((err) => console.log(err.message));
    }
  }, [params.post_id]);

  const deleteButtonClicked = (post_id) => {
    axios
      .delete("http://localhost:8080/api/v1/posts/" + post_id)
      .then((response) => {
        navigate("/posts");
      })
      .catch((err) => console.log(err.message));
  };

  let postDetailsDisplay = null;
  if (params.post_id) {
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
            deleteButtonClicked(params.post_id);
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
