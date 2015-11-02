INSERT INTO device (id, customer_id) (SELECT -1, id from customer where customer_number = '123456');
