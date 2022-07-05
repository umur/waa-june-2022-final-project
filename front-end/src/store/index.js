import { combineReducers, createStore, configureStore } from 'redux';
import userReducer from './reducers/user';


const allReducers = combineReducers({
    user: userReducer,
})

const store = createStore(allReducers);

export default store;