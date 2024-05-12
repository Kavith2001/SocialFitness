import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  getNotificationsByUserId,
  updateNotificationsById,
} from "../../app/actions/notification.action";
import { CiSquareRemove } from "react-icons/ci";
import { AiOutlineNotification } from "react-icons/ai";

function NotificationDropdown() {
  const dispatch = useDispatch();
  const userId = useSelector((state) => state.user.userId);
  const notifications = useSelector(
    (state) => state.notification.notifications
  );

  useEffect(() => {
    if (userId) {
      dispatch(getNotificationsByUserId(userId));
    }
  }, [dispatch, userId]);

  const handleOnRead = (id) => {
    const updateNotification = {
      id,
      isRead: true,
    };
    dispatch(updateNotificationsById(updateNotification));
  };
// notification design part
  return (
    <div className="card p-3 post">
      <h4>Notifications</h4>
      <div className="notification-list" style={{ maxHeight: "300px", overflowY: "auto" }}>
        {notifications && notifications.length ? (
          <ul className="list-group">
            {[...notifications]
              .reverse()
              .slice(-20)
              .map((notification) => (
                <li key={notification.id} className="list-group-item">
                  <AiOutlineNotification className="me-2" />
                  <span className="me-2">{notification.message}</span>
                  <CiSquareRemove
                    size={20}
                    className="text-danger"
                    onClick={() => {
                      handleOnRead(notification.id);
                    }}
                  />
                </li>
              ))}
          </ul>
        ) : (
          <p>No Notifications yet</p>
        )}
      </div>
    </div>
  );
}

export default NotificationDropdown;
