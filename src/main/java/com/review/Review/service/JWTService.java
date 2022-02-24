/**
 * 
 */
package com.review.Review.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import lombok.extern.slf4j.Slf4j;

/**
 * @author macbook
 *
 */
@Slf4j
@Service
public class JWTService implements IJWTService {

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

//	@Value("${jwt.secret}")
	private static final String JWT_SECRET = "Some$ecretKey";

	private Clock clock = DefaultClock.INSTANCE;

	private Long expiration = (long) 200;

	/**
	 * 
	 * @param userJwt
	 * @param claims
	 * @return
	 */
	public String generateToken(String userJwt, Map<String, Object> claims) {
		return doGenerateToken(claims, userJwt);
	}

	/**
	 * 
	 * @param token
	 * @return
	 */
	public boolean isTokenExpired(String token) {
		final Claims claims = extractClaims(token);
		Date now = new Date();

		return now.after(claims.getExpiration());
	}

	/**
	 * 
	 * @param token
	 * @return
	 */
	public String getUsernameFromToken(String token) {
		return extractClaims(token).getSubject();
	}

	/**
	 * 
	 * @param token
	 * @param userJwt
	 * @return
	 */
	public Boolean validateToken(String token, String userJwt) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userJwt) && !isTokenExpired(token));
	}

	/**
	 * 
	 * @param createdDate
	 * @return
	 */
	private Date calculateExpirationDate(Date createdDate) {
		return new Date(createdDate.getTime() + expiration * 1000);
	}

	/**
	 * 
	 * @param claims
	 * @param subject
	 * @return
	 */
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		final Date createdDate = clock.now();
		final Date expirationDate = calculateExpirationDate(createdDate);

		System.out.println("fechaActual: " + createdDate);
		System.out.println("fechaExp: " + expirationDate);

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(createdDate)
				.setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
	}

	/**
	 * 
	 * @param token
	 * @return
	 */
	private static Claims extractClaims(String token) {
		return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
	}

	public static void main(String[] args) {
		JWTService jwt = new JWTService();

		Map<String, Object> mapClaims = new HashMap<String, Object>();

//		String token = jwt.generateToken("user1", mapClaims);
//		System.out.println("TOKEN " + token);

		String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTY0NTQ3NDA5MSwiaWF0IjoxNjQ1NDczODkxfQ.hDmX7ah71bnsAABFkQ4SG2mGXEKr_MGJx76NKDCzGb1ugEpztuxb7C6rVh7OvqHEMGf6HOuWC4w4O8v6W5DiaQ";

		boolean jwtStatus = jwt.validateToken(token, "user1");
		System.out.println("Token valido? " + jwtStatus);

		boolean expirado = jwt.isTokenExpired(token);
		System.out.println("token expirado? " + expirado);

	}

}
