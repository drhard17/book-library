import { useEffect, useState } from 'react';
import axios from 'axios';
import { Book } from './types/book';


const BookList: React.FC = () => {
  const [books, setBooks] = useState<Book[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchBooks = async () => {
      try {
        const response = await axios.get(process.env.API_BASE_URL + '/api/books');
        setBooks(response.data);
      } catch (error) {
        console.error('Ошибка при загрузке данных:', error);
      } finally {
        setLoading(false);
      }
    };

    fetchBooks();
  }, []);

  if (loading) return <p>Загрузка...</p>;
  console.log(books)
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
