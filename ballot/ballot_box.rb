require 'net/http'
require 'json'

class BallotBox
  def initialize
    candidate_list = ['person','chicken','hamster']
    File.new "candidate_result.txt"
  end

  def vote(candidate)
    #File.write('candidate_result.txt', "#{candidate}")
    open('candidate_result.txt', 'a') { |f|
      f.puts candidate
    }
    return "receive #{candidate}"
  end

  def sendfile
    url = URI.parse('http://10.161.100.98:8080')
    params = createJson
    puts params.to_json
    resp = Net::HTTP.post_form(url,params)
    "vote file received : #{resp.code}"
  end

  def createJson
    params = {"vote_list"=>[]}
    vote_file = File.open('candidate_result.txt')
    vote_file.each do |line|
      params['vote_list'] << line.strip
    end
    vote_file.close
    params
  end


end