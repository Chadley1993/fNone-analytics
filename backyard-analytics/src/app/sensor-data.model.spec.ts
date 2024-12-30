import { SensorData } from './sensor-data.model';

describe('SensorData', () => {
  it('should create an instance', () => {
    expect(new SensorData(0, 0, 0)).toBeTruthy();
  });
});
