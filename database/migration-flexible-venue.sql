-- Apply once before running the flexible venue edition. Existing records are preserved.
ALTER TABLE sections MODIFY category VARCHAR(40) NOT NULL;
ALTER TABLE sections ADD COLUMN IF NOT EXISTS ticket_name VARCHAR(50) NULL;
ALTER TABLE sections ADD COLUMN IF NOT EXISTS ticket_price DECIMAL(10,2) NULL;
ALTER TABLE sections ADD COLUMN IF NOT EXISTS early_bird BOOLEAN NOT NULL DEFAULT 0;
ALTER TABLE seats ADD COLUMN IF NOT EXISTS area_code VARCHAR(30) NULL;
ALTER TABLE seats MODIFY label VARCHAR(64) NOT NULL;
ALTER TABLE tickets MODIFY seat_label VARCHAR(64) NOT NULL;
ALTER TABLE tickets MODIFY category VARCHAR(80) NOT NULL;
CREATE TABLE IF NOT EXISTS venue_plans(event_id BIGINT PRIMARY KEY,stage_x INT NOT NULL,stage_y INT NOT NULL,stage_width INT NOT NULL,stage_height INT NOT NULL,FOREIGN KEY(event_id) REFERENCES events(id)) ENGINE=InnoDB;
CREATE TABLE IF NOT EXISTS venue_areas(event_id BIGINT NOT NULL,code VARCHAR(30) NOT NULL,name VARCHAR(40) NOT NULL,type_code VARCHAR(40) NOT NULL,x INT NOT NULL,y INT NOT NULL,width INT NOT NULL,height INT NOT NULL,seat_rows INT NOT NULL,seat_columns INT NOT NULL,row_offset INT NOT NULL,shape VARCHAR(12) NOT NULL,blocked_cells TEXT NOT NULL,PRIMARY KEY(event_id,code),FOREIGN KEY(event_id) REFERENCES events(id)) ENGINE=InnoDB;
