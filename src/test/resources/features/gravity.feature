Feature: Details of simple planetary motion
  As an avid science geek
  I want to see a simulation of how the Earth orbits around the Sun
  So that I can tweak it for different velocities and positions


  Scenario: Play the simplest simulation
    Given I have a body Sun of mass 10 at x,y position 0,0
    Given I have a body Earth of mass 1 at x,y position 0,10
    And the Sun has a velocity of 0,0
    And the Earth has a velocity of 0,1