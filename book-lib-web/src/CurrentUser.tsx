import { useEffect, useState } from 'react';
import axios from 'axios';
import { User } from './types/user'

const { API_BASE_URL } = process.env;

const CurrentUser: React.FC = () => {
  const [user, setUser] = useState<User | null>(null);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchCurrentUser = async () => {
      try {
        const response = await axios.get(`${API_BASE_URL}/api/user/current`, 
            { withCredentials: true }
        );
        setUser(response.data);
      } catch (err) {
        setError(err instanceof Error ? err.message : 'Произошла ошибка');
      } finally {
        setLoading(false);
      }
    };

    fetchCurrentUser();
  }, []);

  if (loading) {
    return <div>Загрузка...</div>;
  }

  if (error) {
    return <div>Ошибка: {error}</div>;
  }

  return (
    <div>
      {user ? (
        <>
          <p>Пользователь: {user.username}</p>
          <p>Роль: {user.role}</p>
        </>
      ) : (
        <p>Пользователь не найден</p>
      )}
    </div>
  );
};

export default CurrentUser;