import "./App.css";
import Dashboard from "./components/Dashboard";
import Header from "./components/Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import AddProject from "./components/Project/AddProject";

function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <Switch>
          <Route exact path="/dashboard">
            <Dashboard />
          </Route>
          <Switch>
            <Route path="/addProject">
              <AddProject />
            </Route>
          </Switch>
        </Switch>
      </div>
    </Router>
  );
}

export default App;
