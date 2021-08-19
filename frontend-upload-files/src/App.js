import React from "react";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";

import UploadFiles from "./components/FileUpload";

function App() {
  return (
    <div className="container" style={{ width: "600px" }}>
      <div className="my-3">
        <h4>Multiple Files Upload</h4>
      </div>
      <UploadFiles />
    </div>
  );
}

export default App;
