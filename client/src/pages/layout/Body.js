import Menu from "../../components/Menu";
import PageSection from "./PageSection";
function Body() {
  return (
    <div className="container-fluid app-body">
      <div className="row">
        <Menu></Menu>
        <PageSection />
      </div>
    </div>
  );
}

export default Body;
