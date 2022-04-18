import { Navigate, Route, Routes } from "react-router-dom";
import NewPost from "../Components/NewPost/NewPost";
import PostDetails from "../Components/PostDetails/PostDetails";
import Posts from "../Containers/Posts/posts";

const PageRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<Navigate replace="true" to="posts" />} />
      <Route path="posts" element={<Posts />}>
        <Route path={"post_id"} element={<PostDetails />} />
      </Route>

      <Route path="create-Post" element={<NewPost />} />
    </Routes>
  );
};

export default PageRoutes;
