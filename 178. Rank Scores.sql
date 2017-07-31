# http://www.cnblogs.com/grandyang/p/5351611.html
# Write your MySQL query statement below
SELECT Score, (SELECT COUNT(DISTINCT Score) FROM Scores WHERE Score >= s.Score) Rank 
FROM Scores s 
ORDER BY Score DESC;