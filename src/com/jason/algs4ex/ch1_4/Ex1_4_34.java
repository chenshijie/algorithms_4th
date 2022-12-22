package com.jason.algs4ex.ch1_4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/*
1.4.34 Hot or cold. Your goal is to guess a secret integer between 1 and N. You repeatedly
guess integers between 1 and N. After each guess you learn if your guess equals the
secret integer (and the game stops). Otherwise, you learn if the guess is hotter (closer to)
or colder (farther from) the secret number than your previous guess. Design an algorithm
that finds the secret number in at most ~2 lg N guesses. Then design an algorithm
that finds the secret number in at most ~ 1 lg N guesses.

1.4.34 热还是冷。你的目标是猜出1到N之间的一个秘密的整数。每次猜完一个整数后，你会知道你的猜测和这个秘密整数是否相等（如果是则游戏结束）。
如果不相等，你会知道你的猜测相比上一次猜测距离该秘密整数是比较热（接近）还是比较冷（远离）。
设计一个算法在～2lgN之内找到这个秘密整数，然后再设计一个算法在～1lgN之内找到这个秘密整数。
*/
public class Ex1_4_34 {

    public static void main(String[] args) {
        int N = 1000;
        GuessGame game = new GuessGame(100, N);

        //方案1，二分查找
        int low = 1;
        int high = game.getMax();
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (game.guess(low) == GuessResult.equal) {
                StdOut.println("success:" + low);
                break;
            }
            GuessResult guessResult = game.guess(high);
            if (guessResult == GuessResult.equal) {
                StdOut.println("success:" + high);
                break;
            } else if (guessResult == GuessResult.hot) {
                low = mid;
            } else {
                high = mid;
            }
        }

        StdOut.printf("secret num: %d, guess count: %d\n", game.getSecret(), game.guessCount);

        game.reStart();

        //方案2，每次都猜前两次的中间值
        low = 1;
        high = game.getMax();
        boolean checkLeftSide = true;
        int guessNumber = 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (game.getGuessCount() != 0) {
                if (checkLeftSide) {
                    guessNumber = mid - Math.abs(game.lastGuessNumber - mid);
                } else {
                    guessNumber = mid + Math.abs(game.lastGuessNumber - mid);
                }
            }
            int lastGuessNumber = game.getLastGuessNumber();
            GuessResult guessResult = game.guess(guessNumber);
            if (guessResult == GuessResult.equal) {
                StdOut.println("SUCCESS:" + guessNumber);
                break;
            } else {
                if (game.getGuessCount() == 1) {
                    checkLeftSide = false;
                    continue;
                }
                if (guessResult == GuessResult.hot) {
                    if (lastGuessNumber > guessNumber) {
                        high = mid;
                        checkLeftSide = false;
                    } else {
                        low = mid;
                        checkLeftSide = true;
                    }
                } else {
                    if (lastGuessNumber < guessNumber) {
                        high = mid;
                        checkLeftSide = true;
                    } else {
                        checkLeftSide = false;
                        low = mid;
                    }
                }
            }
            if (high - low == 1) {
                break;
            }

        }
        if (high - low == 1) {
            if (game.guess(low) == GuessResult.equal) {
                StdOut.println("SUCCESS:" + low);
            } else if (game.guess(high) == GuessResult.equal) {
                StdOut.println("SUCCESS:" + high);
            }
        }

        StdOut.printf("secret num: %d, guess count: %d\n", game.getSecret(), game.guessCount);

    }

    public enum GuessResult {cold, equal, hot}

    public static class GuessGame {
        private final int max;
        private final int min;
        private int secret;

        private int lastGuessNumber;

        private int guessCount = 0;

        public GuessGame(int min, int max) {
            this.min = min;
            this.max = max;
            this.secret = StdRandom.uniformInt(this.min, this.max + 1);
            lastGuessNumber = min - max;
        }

        public int getSecret() {
            return secret;
        }

        public GuessResult guess(int guessNumber) {
            guessCount++;
            if (guessNumber == this.secret) {
                return GuessResult.equal;
            }

            int lastDistance = Math.abs(this.lastGuessNumber - this.secret);
            int currentDistance = Math.abs(guessNumber - this.secret);
            lastGuessNumber = guessNumber;
            if (currentDistance < lastDistance) {
                return GuessResult.hot;
            } else {
                return GuessResult.cold;
            }
        }

        public int getGuessCount() {
            return guessCount;
        }

        public int getLastGuessNumber() {
            return lastGuessNumber;
        }

        public void reStart() {
            guessCount = 0;
            lastGuessNumber = -max;
        }

        public void reset() {
            secret = StdRandom.uniformInt(1, this.max + 1);
            reStart();
        }

        public int getMax() {
            return max;
        }
    }
}
