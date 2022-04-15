import axios from "axios";
import { useEffect, useState } from "react";
import Content from "../Content/Content";

const PostDetails = (props) => {
  const [postDetail, setPostDetail] = useState({});

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/v1/posts/" + props.id + "/content")
      .then((response) => {
        setPostDetail(response.data);
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
          Contents
          {postDetail.content != null
            ? postDetail.content.map((cont) => {
                return <Content content={cont.Content} key={cont.id} />;
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
