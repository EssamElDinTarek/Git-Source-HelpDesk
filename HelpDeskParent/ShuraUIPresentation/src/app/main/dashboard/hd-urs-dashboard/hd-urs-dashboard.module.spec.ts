import { HDURSDashboardModule } from './hd-urs-dashboard.module';

describe('HDURSDashboardModule', () => {
  let hDURSDashboardModule: HDURSDashboardModule;

  beforeEach(() => {
    hDURSDashboardModule = new HDURSDashboardModule();
  });

  it('should create an instance', () => {
    expect(hDURSDashboardModule).toBeTruthy();
  });
});
