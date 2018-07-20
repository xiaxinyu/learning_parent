package org.example.thread.concurrent.timeout;

public class Result {
	private int sequence;
	private long limit;
	private long result;
	private long cost;

	public Result(int sequence, long limit, long result, long cost) {
		super();
		this.sequence = sequence;
		this.limit = limit;
		this.result = result;
		this.cost = cost;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public long getLimit() {
		return limit;
	}

	public void setLimit(long limit) {
		this.limit = limit;
	}

	public long getResult() {
		return result;
	}

	public void setResult(long result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Result [sequence=" + sequence + ", limit=" + limit + ", result=" + result + ", cost=" + cost + "]";
	}
}
