import React, { useState, useEffect, useRef } from "react";
import UploadService from "../services/FileUploadService";
import "../css/FileUploadComponent.css"

/**
 * The coponent for delete/list/upload file using Hooks
 */
const UploadFiles = () => {
    const [selectedFiles, setSelectedFiles] = useState(undefined);
    const [displayMessage, setMessage] = useState([]);
    const [fileInfos, setFileInfos] = useState([]);

    // Using useEffect to display list files
    useEffect(() => {
        UploadService.getFiles().then((response) => {
            setFileInfos(response.data);
        });
    }, []);

    // Eevent to select file which want to upload
    const selectFiles = (event) => {
        setSelectedFiles(event.target.files);
    };

    // Using to check upload status
    const upload = (idx, file) => {
        return UploadService.upload(file, (event) => {
        })
            .then(() => {
                setMessage((prevMessage) => ([
                    ...prevMessage,
                    "Uploaded the file : " + file.name,
                ]));
            })
            .catch(() => {
                setMessage((prevMessage) => ([
                    ...prevMessage,
                    "Could not upload the file: " + file.name,
                ]));
            });
    };

    /**
     * Event to upload file when click button upload
     */
    const uploadFiles = () => {
        const files = Array.from(selectedFiles);
        const uploadPromises = files.map((file, i) => upload(i, file));
        Promise.all(uploadPromises)
            .then(() => UploadService.getFiles())
            .then((files) => {
                setFileInfos(files.data);
            });

        setMessage([]);
    };

    /**
     * Event to delete file in list
     * @param {number} id 
     */
    const deleteFileUpload = (id, name) => {
        setMessage(() => ([
            "Deleted the file successfully: " + name,
        ]));
        UploadService.deleteFiles(id).then((res) => {
            setFileInfos(fileInfos.filter(fileInfo => fileInfo.id !== id));
        });
    };

    return (
        <div>
            <div className="row my-3">
                <div className="col-8">
                    <label className="btn btn-default p-0">
                        <input type="file" multiple onChange={selectFiles} />
                    </label>
                </div>

                <div className="col-4">
                    <button
                        className="btn btn-success btn-sm"
                        disabled={!selectedFiles}
                        onClick={uploadFiles}
                    >
                        Upload
                    </button>
                </div>
            </div>

            {displayMessage.length > 0 && (
                <div className="alert alert-secondary" role="alert">
                    <ul>
                        {displayMessage.map((item, i) => {
                            return <li key={i}>{item}</li>;
                        })}
                    </ul>
                </div>
            )}

            <div className="card">
                <div className="card-header">List of Files</div>
                <ul className="list-group list-group-flush">
                    {fileInfos &&
                        fileInfos.map((file, index) => (
                            <li className="list-group-item" key={index}>
                                <a href={file.url}>{file.name}</a>
                                <div className="box-button">
                                    <button onClick={() => deleteFileUpload(file.id, file.name)} className="delete-button">Delete </button>
                                </div>
                            </li>
                        ))}
                </ul>
            </div>
        </div>
    );
};

export default UploadFiles;