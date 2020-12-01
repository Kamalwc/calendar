import React from "react"
import './App.css';
import { BrowserRouter, Route, Switch} from "react-router-dom";

import Home from "./Home";
import Login from "./Login";

function App() {
  return (
      <BrowserRouter>
          <Switch>
              <Route exact path="/home" component={Home} />
              <Route exact path="/login" component={Login}/>
          </Switch>
      </BrowserRouter>

  );
}

export default App;
