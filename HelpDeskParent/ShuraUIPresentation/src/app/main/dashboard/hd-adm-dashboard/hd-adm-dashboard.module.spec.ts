import { HDADMDashboardModule } from './hd-adm-dashboard.module';

describe('HDADMDashboardModule', () => {
  let hDADMDashboardModule: HDADMDashboardModule;

  beforeEach(() => {
    hDADMDashboardModule = new HDADMDashboardModule();
  });

  it('should create an instance', () => {
    expect(hDADMDashboardModule).toBeTruthy();
  });
});
