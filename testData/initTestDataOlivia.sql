

INSERT INTO activity (title, description, start_date, end_date, requirements)
VALUES ('Mountain Hiking', 'A guided hike through mountain trails.', '2026-04-10', '2026-04-12', 'Good physical condition, hiking boots');

INSERT INTO activity (title, description, start_date, end_date, requirements)
VALUES ('Kayaking Adventure', 'Kayaking on a scenic river with instructors.', '2026-05-03', '2026-05-03', 'Basic swimming ability');

INSERT INTO activity (title, description, start_date, end_date, requirements)
VALUES ('Rock Climbing Course', 'Learn basic rock climbing techniques.', '2026-06-15', '2026-06-17', 'No prior experience required');

INSERT INTO activity (title, description, start_date, end_date, requirements)
VALUES ('Mountain Biking', 'Trail biking through forest terrain.', '2026-07-08', '2026-07-08', 'Ability to ride a bike confidently');

INSERT INTO activity (title, description, start_date, end_date, requirements)
VALUES ('Camping Weekend', 'Outdoor camping with survival basics.', '2026-08-20', '2026-08-22', 'Warm clothing and outdoor interest');

INSERT INTO activity (title, description, start_date, end_date, requirements)
VALUES ('Forest Survival Training', 'Learn survival skills in the wilderness.', '2026-09-05', '2026-09-06', 'Participants must be 18+');

INSERT INTO activity (title, description, start_date, end_date, requirements)
VALUES ('Night Navigation', 'Navigation training using maps and compasses at night.', '2026-10-10', '2026-10-10', 'Basic map reading skills recommended');

INSERT INTO activity (title, description, start_date, end_date, requirements)
VALUES ('Winter Hiking', 'Hiking in snowy terrain with safety training.', '2026-12-05', '2026-12-06', 'Warm winter gear required');

INSERT INTO activity (title, description, start_date, end_date, requirements)
VALUES ('Team Building Adventure', 'Outdoor activities designed for team cooperation.', '2026-06-01', '2026-06-01', 'Suitable for corporate groups');

INSERT INTO activity (title, description, start_date, end_date, requirements)
VALUES ('Beginner Orienteering', 'Introduction to orienteering in the forest.', '2026-05-18', '2026-05-18', 'Comfortable walking in nature');


INSERT INTO equipment (name, status, activity_id) VALUES ('Helmet', 'AVAILABLE', 1);
INSERT INTO equipment (name, status, activity_id) VALUES ('Climbing Rope', 'AVAILABLE', 1);
INSERT INTO equipment (name, status, activity_id) VALUES ('Harness', 'IN_USE', 1);
INSERT INTO equipment (name, status, activity_id) VALUES ('Kayak Paddle', 'AVAILABLE', 2);
INSERT INTO equipment (name, status, activity_id) VALUES ('Life Jacket', 'AVAILABLE', 2);
INSERT INTO equipment (name, status, activity_id) VALUES ('Tent', 'MAINTENANCE', 3);
INSERT INTO equipment (name, status, activity_id) VALUES ('Sleeping Bag', 'AVAILABLE', 3);
INSERT INTO equipment (name, status, activity_id) VALUES ('Mountain Bike', 'IN_USE', 4);
INSERT INTO equipment (name, status, activity_id) VALUES ('Headlamp', 'AVAILABLE', 4);
INSERT INTO equipment (name, status, activity_id) VALUES ('First Aid Kit', 'AVAILABLE', 5);
