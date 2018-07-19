import { HDMGRDashboardModule } from './hd-mgr-dashboard.module';

describe('HDMGRDashboardModule', () => {
  let hDMGRDashboardModule: HDMGRDashboardModule;

  beforeEach(() => {
    hDMGRDashboardModule = new HDMGRDashboardModule();
  });

  it('should create an instance', () => {
    expect(hDMGRDashboardModule).toBeTruthy();
  });
});
