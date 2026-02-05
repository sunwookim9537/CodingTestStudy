-- 상품코드별 오프라인 총 매출액(판매가 * 판매량) 합계 구하기
SELECT
    p.product_code AS PRODUCT_CODE,
    SUM(p.price * os.sales_amount) AS SALES
FROM PRODUCT p
JOIN OFFLINE_SALE os
    ON p.product_id = os.product_id
GROUP BY
    p.product_code
ORDER BY
    SALES DESC,           -- 매출액 내림차순
    PRODUCT_CODE ASC;     -- 매출 같으면 상품코드 오름차순