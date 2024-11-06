INSERT INTO books (id, title, author) VALUES
(1, '1984', 'George Orwell'),
(2, 'Animal Farm', 'George Orwell'),
(3, 'Harry Potter and the Philosopher\'s Stone', 'J.K. Rowling'),
(4, 'Harry Potter and the Chamber of Secrets', 'J.K. Rowling'),
(5, 'The Hobbit', 'J.R.R. Tolkien'),
(6, 'The Lord of the Rings', 'J.R.R. Tolkien');

INSERT INTO members (member_id, name, last_name) VALUES
(1, 'Alice', 'Johnson'),
(2, 'Bob', 'Smith'),
(3, 'Charlie', 'Brown');

INSERT INTO rentals (id, book_id, member_id, rental_date, return_date) VALUES
(1, 1, 1, '2021-08-01 10:00:00', '2021-08-15 10:00:00'),
(2, 3, 2, '2021-08-05 10:00:00', '2021-08-20 10:00:00'),
(3, 5, 3, '2021-08-10 10:00:00', '2021-08-25 10:00:00');