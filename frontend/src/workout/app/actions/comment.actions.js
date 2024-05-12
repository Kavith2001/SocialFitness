import { createAsyncThunk } from "@reduxjs/toolkit";
import { COMMENTAPI } from "../../../workout/app/apis/comment.api";

export const saveComment = createAsyncThunk(
  "comment/save_workoutComment",
  async (data) => {
    const response = await COMMENTAPI.saveComment(data);
    return response.data;
  }
);

export const getCommentsByPostId = createAsyncThunk(
  "comment/get_workoutCommentsByPostId",
  async (id) => {
    const response = await COMMENTAPI.getCommentsByPostId(id);
    return response.data;
  }
);

export const updateCommentById = createAsyncThunk(
  "comment/update_workoutCommentById",
  async (data) => {
    const response = await COMMENTAPI.updateCommentById(data.id, data);
    return data.id;
  }
);

export const deleteCommentById = createAsyncThunk(
  "comment/delete_workoutCommentById",
  async (id) => {
    const response = await COMMENTAPI.deleteCommentById(id);
    return id;
  }
);
