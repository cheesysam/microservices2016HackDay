require 'rspec'
require_relative 'ballot_box'

describe 'BallotBox' do

  before(:each) do
    File.open('candidate_result.txt', 'w') {|file| file.truncate(0) }
  end

  it 'should receive the name of the candidate' do
    ballotBox = BallotBox.new
    expect(ballotBox.vote('person')).to eq('receive person')
  end
  it 'should send file to collator' do
    ballotBox = BallotBox.new
    ballotBox.vote ('person')
    ballotBox.vote ('hamster')
    server_response = ballotBox.sendfile
    expect(server_response).to eq('vote file received : 200')
  end
  it 'should create a json' do
    ballotBox = BallotBox.new
    ballotBox.vote('person')
    expect(ballotBox.createJson).to eq({"vote_list"=>["person"]})
  end

end