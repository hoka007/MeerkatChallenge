package eu.johncasson.meerkatchallenge.game;

import eu.johncasson.meerkatchallenge.levels.Level;

/**
 * Keeps score and provides updates on the current score
 * @author John Casson
 *
 */
class Score {
	private int score = 0;
	private Level level;
	
	protected Score(Level level) {
		this.level = level;
	}

	/**
	 * Adds to the score
	 * @param toAdd The value to add
	 */
	synchronized protected void add(int toAdd) {
		score = score + toAdd;
	}
	
	/**
	 * Gets the current score
	 * @return The score
	 */
	protected int get() {
		return this.score;
	}

	/**
	 * Gets the score as text
	 * @return A text representation of the current score
	 */
	@Override
	public String toString() {
		int neededToWin = level.getTargetScore() - score;
		String scoreText;
		// If the target hasn't been met show the number needed to meet the target
		if(neededToWin >= 0) {
			scoreText = Integer.toString(neededToWin);
		} else {
			scoreText = "+" + (neededToWin * -1);
		}
		
		return scoreText;
	}
}
