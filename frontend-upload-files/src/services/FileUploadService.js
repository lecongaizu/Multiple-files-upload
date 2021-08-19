import axios from 'axios';
const API_URL = "http://localhost:8080/api/v1/files";

class UploadFilesService {
    // POST -Upload files
    upload(file, onUploadProgress) {
        let formData = new FormData();

        formData.append("file", file);

        return axios.post(API_URL, formData, {
            headers: {
                "Content-Type": "multipart/form-data",
            },
            onUploadProgress,
        });
    }

    // GET - Get list files
    getFiles() {
        return axios.get(API_URL);
    }

    // DELETE- Delete file
    deleteFiles = (id) => {
        return axios.delete(API_URL + '/' + id);
    }

}

export default new UploadFilesService();