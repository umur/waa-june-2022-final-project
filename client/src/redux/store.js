import { applyMiddleware, createStore } from "redux";
import axiosMiddleware from "redux-axios-middleware";
import thunk from "redux-thunk";
import rootReducer from "./reducers/rootReducer";
import HttpService from "../services/HttpService";

const setup = () => {
  const middleware = applyMiddleware(
    thunk,
    axiosMiddleware(HttpService.getAxiosClient())
  );
  return createStore(rootReducer, middleware);
};

const StoreService = {
  setup,
};

export default StoreService;
