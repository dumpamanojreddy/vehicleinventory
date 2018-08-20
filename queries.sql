CREATE TABLE vehicle (
	id IDENTITY,
	type VARCHAR(25),
	manufacturer VARCHAR(25),
	model VARCHAR(25),
    make_year INTEGER(10),
    price DECIMAL(10,2),
	time_stamp BIGINT,
    transport_mode VARCHAR(25),
    max_speed INT,
    no_of_wheels INT,
    no_of_seats INT,VEHICLE 
	
	CONSTRAINT pk_vehicle_id PRIMARY KEY (id)
);