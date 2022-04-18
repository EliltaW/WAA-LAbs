import { Link } from "react-router-dom";
import "./Header.css";

const Header = () => {
  return (
    <header>
      <nav>
        <ul>
          <li>
            <Link to="/posts">Posts</Link>
          </li>
          <li>
            <Link to="/create-post">New Post</Link>
          </li>
          <li className="right">
            <Link to="">Sign In</Link>
          </li>
        </ul>
      </nav>
    </header>
  );
};
export default Header;
