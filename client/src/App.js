import "./App.css";
import Footer from "./components/Footer";
import { BrowserRouter } from "react-router-dom";
import Header from "./components/header";

import Router from "./pages/Router";
import store from "./redux/store";
import { Provider } from "react-redux";

import "./App.css";
import Registration from "./pages/faculty/Registration";
import { useEffect } from "react";
import { useNavigate } from "react-router";
import Menu from "./components/Menu";
import Body from "./pages/layout/Body";
import PageSection from "./pages/layout/PageSection";

const reduxStore = store.setup();

function App() {
  return (
    <Provider store={reduxStore}>
      <BrowserRouter>
        <Header></Header>
        <Body></Body>
        <Footer></Footer>
      </BrowserRouter>
    </Provider>
  );
}

export default App;
