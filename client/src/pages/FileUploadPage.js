import React,{useState} from 'react'
import axios from 'axios'
import Button from 'react-bootstrap/Button';
function FileUploadPage() {
    const [selectedFile, setSelectedFile] = useState();
    const [isFilePicked, setIsFilePicked] = useState(false);

    const changeHandler = (event) => {
        setSelectedFile(event.target.files[0]);
        setIsFilePicked(true);
    };

    const handleSubmission = () => {
        const formData = new FormData();
        formData.append('File', selectedFile);
        console.log(this.state.selectedFile); 
        axios.post("http://localhost:3000/api/uploadfile", formData )
    };

    return (
        <div>
            <input type="file" name="file" onChange={changeHandler} />
            {isFilePicked ? (
                <div>
                    <p>Filename: {selectedFile.name}</p>
                    <p>Filetype: {selectedFile.type}</p>
                    <p>Size in bytes: {selectedFile.size}</p>
                    <p>

                    </p>
                </div>
            ) : (
                <p>Select a file to show details</p>
            )}
            <div>
                <Button variant="secondary" onClick={handleSubmission}>Submit</Button>
            </div>
        </div>
    )
}

export default FileUploadPage;