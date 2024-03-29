-- SQL Lite
SELECT b.id, COUNT(DISTINCT buses_with_passengers.pId) AS passengers_on_board
FROM buses b
LEFT JOIN (
	-- Buses with Passengers
	SELECT * FROM (
		SELECT
			b.id AS busId,
			b.origin AS busOrigin,
			b.destination AS busDest,
			time(b.time) AS busTime,
			min(time(b.time)) OVER (PARTITION BY p.id) AS minBusTime,
			p.id AS pId
		FROM buses b
		INNER JOIN passengers p
			ON (b.origin == p.origin AND b.destination == p.destination AND time(p.time) <= time(b.time))
	) WHERE (minBusTime == busTime)
) buses_with_passengers
	ON (b.id == buses_with_passengers.busId)
GROUP BY b.id;