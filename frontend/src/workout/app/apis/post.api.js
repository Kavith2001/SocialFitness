import axios from 'axios';

const BASE_URL = process.env.REACT_APP_BACKEND_API;

export const POSTAPI = {
    savePost: (data) => axios.post(`${BASE_URL}/api/posts/workout`, data),
    getPosts: () => axios.get(`${BASE_URL}/api/posts/workout`),
    getPostById: (id) => axios.get(`${BASE_URL}/api/posts/workout/${id}`),
    getPostsByUserId: (id) => axios.get(`${BASE_URL}/api/posts/user/${id}`),
    updatePostById: (id, data) => axios.put(`${BASE_URL}/api/posts/workout/${id}`, data),
    likePostById: (id, data) => axios.put(`${BASE_URL}/api/posts/like/${id}`, data),
    deletePostById: (id) => axios.delete(`${BASE_URL}/api/posts/workout/${id}`),
};