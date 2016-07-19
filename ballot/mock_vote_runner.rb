require 'csv'
require_relative 'ballot_box.rb'

class MockVoteRunner
  def initialize(box)
    @box = box
  end
  def csv_reader (filename)
    CSV.foreach(filename) do |row|
      row.each do |item|
        vote_instance = item.split(":")
        puts "#{vote_instance}-----"
        @box.vote(vote_instance[0], vote_instance[1])
      end
    end
  end
end

box = BallotBox.new
runner = MockVoteRunner.new(box)
runner.csv_reader("votes.csv")