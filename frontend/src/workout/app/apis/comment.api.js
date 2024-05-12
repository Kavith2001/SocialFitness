import axios from 'axios';

const BASE_URL = process.env.REACT_APP_BACKEND_API;

export const COMMENTAPI = {
    saveComment: (data) => axios.post(`${BASE_URL}/api/comments_workouts`, data),
    getComments: () => axios.get(`${BASE_URL}/api/comments_workouts`),
    getCommentsByPostId: (id) => axios.get(`${BASE_URL}/api/comments_workouts/post/${id}`),
    updateCommentById: (id, data) => axios.put(`${BASE_URL}/api/comments_workouts/${id}`, data),
    deleteCommentById: (id) => axios.delete(`${BASE_URL}/api/comments_workouts/${id}`),
};