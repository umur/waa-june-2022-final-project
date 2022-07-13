import React, { useState, useEffect } from "react";
import axios from "axios";
import Button from "react-bootstrap/Button";

function FileUploadPage() {
  const [selectedFile, setSelectedFile] = useState();
  const [isFilePicked, setIsFilePicked] = useState(false);

  const changeHandler = (event) => {
    setSelectedFile(event.target.files[0]);
    setIsFilePicked(true);
  };

  //   const handleSubmission = () => {
  //     useEffect(() => {
  //       const formData = new FormData();
  //       formData.append("File", selectedFile);
  //       axios.post("http://localhost:8080/upload", formData);
  //     });
  //   };

  const handleSubmission = (e) => {
    e.preventDefault();
    const formData = new FormData();

    formData.append("file", selectedFile);

    fetch("http://localhost:8080/upload", {
      method: "POST",
      body: formData,
    }).then((res) => {
      if (res.ok) {
        alert("File uploaded successfully");
      }
    });
  };

  return (
    <div>
      <input
        variant="primary"
        type="file"
        name="file"
        onChange={changeHandler}
      />
      {isFilePicked ? (
        <div>
          <p>Filename: {selectedFile.name}</p>
          <p>Filetype: {selectedFile.type}</p>
          <p>Size in bytes: {selectedFile.size}</p>
          <p></p>
        </div>
      ) : (
        <p>Select a file to show details</p>
      )}
      <div>
        <Button variant="secondary" onClick={handleSubmission}>
          Submit
        </Button>
      </div>
    </div>
  );
}

export default FileUploadPage;
