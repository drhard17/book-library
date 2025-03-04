import { useEffect, useState } from 'react';
import axios from 'axios';
import { Book } from './types/book';


const BookList: React.FC = () => {
  const [books, setBooks] = useState<Book[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchBooks = async () => {
      try {
        const response = await axios.get(process.env.API_BASE_URL + '/api/books',
            { withCredentials: true }
        );

        if (Array.isArray(response.data)) {
          setBooks(response.data);
        } else {
        //   window.location.href = process.env.API_BASE_URL + '/login';
          const currentUrl = window.location.href;
          window.location.href = 
          `${process.env.API_BASE_URL}/login?redirect_url=${encodeURIComponent(currentUrl)}`;
        }
      } catch (error) {
        console.error('Ошибка при загрузке данных:', error);
      } finally {
        setLoading(false);
      }
    };

    fetchBooks();
  }, []);

  if (loading) {
    return <p>Загрузка...</p>;
  } 

  return (
    <div>
      <h2>Мои книги</h2>
      <ul>
        {books.map((book) => (
          <li key={book.id}>
             {book.title} - {book.author}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BookList;
