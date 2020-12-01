import logo from './logo.svg';
import React from "react"
import './App.css';
import { BrowserRouter, Route, Switch} from "react-router-dom";

import Home from "./Home";
import NoMatch from "./NoMatch";

function App() {
  return (
      <BrowserRouter>
          <Switch>
                  <Route exact path="/home" component={Home} />
          </Switch>
      </BrowserRouter>

  );
}

export default App;
