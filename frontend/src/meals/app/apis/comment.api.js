import axios from 'axios';

const BASE_URL = process.env.REACT_APP_BACKEND_API;

export const COMMENTAPI = {
    saveComment: (data) => axios.post(`${BASE_URL}/api/comments_meals`, data),
    getComments: () => axios.get(`${BASE_URL}/api/comments_meals`),
    getCommentsByPostId: (id) => axios.get(`${BASE_URL}/api/comments_meals/post/${id}`),
    updateCommentById: (id, data) => axios.put(`${BASE_URL}/api/comments_meals/${id}`, data),
    deleteCommentById: (id) => axios.delete(`${BASE_URL}/api/comments_meals/${id}`),
};