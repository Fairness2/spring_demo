import axios from "axios";

const { headers } = axios.defaults;
headers.common['X-Requested-With'] = 'XMLHttpRequest';

let instance = axios.create();

export default instance;